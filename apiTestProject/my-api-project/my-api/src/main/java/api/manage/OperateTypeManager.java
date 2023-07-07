package api.manage;

import api.enums.OperateTypeEnum;
import api.service.IOperateTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class OperateTypeManager implements ApplicationContextAware, InitializingBean{


    private Map<OperateTypeEnum, IOperateTypeService> operateDataMap = new HashMap<>();

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, IOperateTypeService> operateMap = applicationContext.getBeansOfType(IOperateTypeService.class);
        operateMap.values().forEach(v -> operateDataMap.put(v.getOperateEnum(), v));
        log.info("TypeOperateHanlder info:{}", operateMap);
    }


    public IOperateTypeService getOperateHandler(OperateTypeEnum operateTypeEnum){
        IOperateTypeService res = operateDataMap.getOrDefault(operateTypeEnum, null);
        return res;
    }
}
