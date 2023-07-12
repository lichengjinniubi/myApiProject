package api.spring.strategypattern;

import api.annotation.AutowiredStrategyPattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


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

            }
        }


        return SmartInstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
