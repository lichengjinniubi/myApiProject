package api.service.testcelue;


import api.enums.OperateTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CelueManager implements ApplicationContextAware, InitializingBean {

    @Autowired
    ApplicationContext applicationContext;

    private Map<OperateTypeEnum, CelueInterface> celueMMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CelueInterface> beansOfType = applicationContext.getBeansOfType(CelueInterface.class);
        beansOfType.forEach((k, v) -> {
            celueMMap.put(v.getEnum(), v);
        });

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public CelueInterface getHandler(OperateTypeEnum operateTypeEnum){
        return celueMMap.get(operateTypeEnum);
    }
}
