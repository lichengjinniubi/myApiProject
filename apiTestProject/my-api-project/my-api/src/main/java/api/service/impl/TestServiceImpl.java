package api.service.impl;

import api.manager.TestInterFace;
import api.service.ITestService;
import coreService.service.IUserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class TestServiceImpl implements ITestService, ApplicationContextAware {


    private ApplicationContext applicationContext;


    @Override
    public String getTestData() {
        return "1111";
    }

    @Override
    public Map<String, TestInterFace> getBeanObject() {
        return applicationContext.getBeansOfType(TestInterFace.class);
    }

    @Override
    public String getInterfaceStr() {
        Map<String, TestInterFace> stringTestInterFaceMap = applicationContext.getBeansOfType(TestInterFace.class);
        String aa = "";

        for(Map.Entry<String, TestInterFace> mapEntry : stringTestInterFaceMap.entrySet()){
            aa = aa + mapEntry.getValue().getDD();
        }
        return aa;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
