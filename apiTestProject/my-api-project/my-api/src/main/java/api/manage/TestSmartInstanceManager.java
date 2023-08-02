package api.manage;

import api.annotation.AutowiredStrategyPattern;
import api.enums.TestSmartInstanceEnum;
import api.service.ITestSmartInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TestSmartInstanceManager {


    @AutowiredStrategyPattern
    Map<TestSmartInstanceEnum, ITestSmartInstance> testSmartHanlder = new HashMap<>();



    public ITestSmartInstance getInstanceHandler(TestSmartInstanceEnum testSmartInstanceEnum){
        log.info("getInstanceHandler testSmartHanlder:{}", testSmartHanlder);
        ITestSmartInstance orDefault = testSmartHanlder.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }
}
