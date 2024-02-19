package api.manage;

import api.annotation.AutowiredStrategyPattern;
import api.enums.TestSmartInstanceEnum;
import api.enums.TestSmartInstanceEnumV2;
import api.service.ITestSmartInstance;
import api.service.ITestSmartInstanceV2;
import api.service.impl.CommonApiServiceImpl;
import api.service.impl.testAbstract.AbstraceTestClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestSmartInstanceManager {


    @AutowiredStrategyPattern
    Map<TestSmartInstanceEnum, ITestSmartInstance> testSmartHanlder = new HashMap<>();

    @AutowiredStrategyPattern
    Map<TestSmartInstanceEnumV2, ITestSmartInstanceV2> testSmartHanlderV2 = new HashMap<>();


    @AutowiredStrategyPattern
    Map<TestSmartInstanceEnumV2, AbstraceTestClass> testSmartHanlderV3 = new HashMap<>();



    Logger logger = LogManager.getLogger(TestSmartInstanceManager.class);


    private static final org.slf4j.Logger loggerV2 = LoggerFactory.getLogger("info");


    public ITestSmartInstance getInstanceHandler(TestSmartInstanceEnum testSmartInstanceEnum){
        logger.error("getInstanceHandler testSmartHanlder:{}", testSmartHanlder);
        ITestSmartInstance orDefault = testSmartHanlder.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }


    public ITestSmartInstanceV2 getInstanceHandlerV2(TestSmartInstanceEnumV2 testSmartInstanceEnum){
        loggerV2.info("getInstanceHandlerV2 testSmartHanlder:{}", testSmartHanlderV2);
        logger.error("getInstanceHandlerV2Error");
        ITestSmartInstanceV2 orDefault = testSmartHanlderV2.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }

    public AbstraceTestClass getInstanceHandlerV3(TestSmartInstanceEnumV2 testSmartInstanceEnum){
        logger.info("getInstanceHandlerV3 testSmartHanlder:{}", testSmartHanlderV2);
        AbstraceTestClass orDefault = testSmartHanlderV3.getOrDefault(testSmartInstanceEnum, null);
        return orDefault;
    }
}
