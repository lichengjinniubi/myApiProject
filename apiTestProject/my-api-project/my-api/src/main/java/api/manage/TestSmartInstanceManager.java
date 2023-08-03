package api.manage;

import api.annotation.AutowiredStrategyPattern;
import api.enums.TestSmartInstanceEnum;
import api.enums.TestSmartInstanceEnumV2;
import api.service.ITestSmartInstance;
import api.service.ITestSmartInstanceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TestSmartInstanceManager {


    @AutowiredStrategyPattern
    Map<TestSmartInstanceEnum, ITestSmartInstance> testSmartHanlder = new HashMap<>();

    @AutowiredStrategyPattern
    Map<TestSmartInstanceEnumV2, ITestSmartInstanceV2> testSmartHanlderV2 = new HashMap<>();



    public ITestSmartInstance getInstanceHandler(TestSmartInstanceEnum testSmartInstanceEnum){
        log.info("getInstanceHandler testSmartHanlder:{}", testSmartHanlder);
        ITestSmartInstance orDefault = testSmartHanlder.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }


    public ITestSmartInstanceV2 getInstanceHandlerV2(TestSmartInstanceEnumV2 testSmartInstanceEnum){
        log.info("getInstanceHandlerV2 testSmartHanlder:{}", testSmartHanlderV2);
        ITestSmartInstanceV2 orDefault = testSmartHanlderV2.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }
}
