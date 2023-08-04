package api.manage;

import api.annotation.AutowiredStrategyPattern;
import api.enums.TestSmartInstanceEnum;
import api.enums.TestSmartInstanceEnumV2;
import api.service.ITestSmartInstance;
import api.service.ITestSmartInstanceV2;
import api.service.impl.CommonApiServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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


    Logger logger = LogManager.getLogger(TestSmartInstanceManager.class);


    public ITestSmartInstance getInstanceHandler(TestSmartInstanceEnum testSmartInstanceEnum){
        logger.info("getInstanceHandler testSmartHanlder:{}", testSmartHanlder);
        ITestSmartInstance orDefault = testSmartHanlder.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }


    public ITestSmartInstanceV2 getInstanceHandlerV2(TestSmartInstanceEnumV2 testSmartInstanceEnum){
        logger.info("getInstanceHandlerV2 testSmartHanlder:{}", testSmartHanlderV2);
        logger.error("getInstanceHandlerV2Error");
        ITestSmartInstanceV2 orDefault = testSmartHanlderV2.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }
}
