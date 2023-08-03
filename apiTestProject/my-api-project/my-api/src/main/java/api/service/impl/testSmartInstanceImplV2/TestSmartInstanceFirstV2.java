package api.service.impl.testSmartInstanceImplV2;

import api.enums.TestSmartInstanceEnumV2;
import api.service.ITestSmartInstanceV2;
import org.springframework.stereotype.Service;


@Service
public class TestSmartInstanceFirstV2 implements ITestSmartInstanceV2 {

    @Override
    public TestSmartInstanceEnumV2 getType() {
        return TestSmartInstanceEnumV2.FOREST_CANDLE_ACTIVITY_V2;
    }
}
