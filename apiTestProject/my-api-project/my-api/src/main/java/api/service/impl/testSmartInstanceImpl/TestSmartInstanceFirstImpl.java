package api.service.impl.testSmartInstanceImpl;

import api.enums.TestSmartInstanceEnum;
import api.service.ITestSmartInstance;
import org.springframework.stereotype.Service;

@Service
public class TestSmartInstanceFirstImpl implements ITestSmartInstance {

    @Override
    public TestSmartInstanceEnum getType() {
        return TestSmartInstanceEnum.FOREST_CANDLE_ACTIVITY;
    }
}
