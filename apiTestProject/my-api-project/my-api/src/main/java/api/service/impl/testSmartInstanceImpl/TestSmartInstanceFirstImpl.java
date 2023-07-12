package api.service.impl.testSmartInstanceImpl;

import api.enums.TestSmartInstanceEnum;
import api.service.ITestSmartInstance;

public class TestSmartInstanceFirstImpl implements ITestSmartInstance {

    @Override
    public TestSmartInstanceEnum getType() {
        return TestSmartInstanceEnum.FOREST_CANDLE_ACTIVITY;
    }
}
