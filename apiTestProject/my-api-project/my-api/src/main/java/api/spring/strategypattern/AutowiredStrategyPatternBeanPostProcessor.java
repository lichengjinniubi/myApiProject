package api.spring.strategypattern;

import api.annotation.AutowiredStrategyPattern;
import api.manage.TestSmartInstanceManager;
import api.service.StrategyPatternTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


@Component
@Slf4j
public class AutowiredStrategyPatternBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    private ApplicationContext applicationContext;

    public AutowiredStrategyPatternBeanPostProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if(beanName.equals("testSmartInstanceManager")){
            Field[] fields = bean.getClass().getDeclaredFields();
            for(Field field : fields){

                if(Modifier.isStatic(field.getModifiers())){
                    continue;
                }
                AutowiredStrategyPattern annotation = field.getAnnotation(AutowiredStrategyPattern.class);
                if(annotation == null){
                    continue;
                }
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();

                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                log.info("AutowiredStrategyPatternBeanPostProcessor field:{} parameterizedType:{} actualTypeArguments:{}", field, parameterizedType, actualTypeArguments);
                Class<?> key = (Class<?>) actualTypeArguments[0];
                Class<?> val = (Class<?>) actualTypeArguments[1];

                Map<String, ?> beansOfTypes = applicationContext.getBeansOfType(val);
                log.info("AutowiredStrategyPatternBeanPostProcessorV2 val:{} beansOfTypes:{}", val, beansOfTypes);
                Map<Object, Object> data = new HashMap<>();

                for(Object obj : beansOfTypes.values()){
                    StrategyPatternTypeService<?> type = (StrategyPatternTypeService) obj;
                    Object type1 = type.getType();
                    if(key == type1.getClass()){
                        data.put(type1, obj);
                    }
                }

                log.info("AutowiredStrategyPatternBeanPostProcessorV3 data:{}", data);
                //ReflectionUtils.makeAccessible(field);
                field.setAccessible(true);
                try {
                    field.set(bean, data);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return SmartInstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
