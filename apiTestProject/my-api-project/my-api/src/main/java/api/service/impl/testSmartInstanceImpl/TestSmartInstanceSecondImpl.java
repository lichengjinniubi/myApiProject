package api.service.impl.testSmartInstanceImpl;

import api.enums.TestSmartInstanceEnum;
import api.service.ITestSmartInstance;

public class TestSmartInstanceSecondImpl implements ITestSmartInstance {
    @Override
    public TestSmartInstanceEnum getType() {
        return TestSmartInstanceEnum.GIFT_TO_COIN_SEND_RANK_ACTIVITY;
    }
}
