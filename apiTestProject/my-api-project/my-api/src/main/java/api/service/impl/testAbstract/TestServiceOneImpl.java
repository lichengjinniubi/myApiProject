package api.service.impl.testAbstract;

import api.enums.TestSmartInstanceEnumV2;
import org.springframework.stereotype.Service;

@Service
public class TestServiceOneImpl extends AbstraceTestClass{
    @Override
    public TestSmartInstanceEnumV2 getType() {
        return TestSmartInstanceEnumV2.FOREST_CANDLE_ACTIVITY_V2;
    }


    @Override
    public String getTest() {
        String test = super.getTest();
        return test + "mmmmmmmmm";
    }
}
