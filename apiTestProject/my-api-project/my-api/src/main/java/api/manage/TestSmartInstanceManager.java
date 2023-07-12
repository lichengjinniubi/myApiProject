package api.manage;

import api.annotation.AutowiredStrategyPattern;
import api.enums.TestSmartInstanceEnum;
import api.service.ITestSmartInstance;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestSmartInstanceManager {


    @AutowiredStrategyPattern
    Map<TestSmartInstanceEnum, ITestSmartInstance> testSmartHanlder = new HashMap<>();

}
