package api.service.impl.testAbstract;

import api.enums.TestSmartInstanceEnumV2;
import org.springframework.stereotype.Service;

@Service
public class TestServiceTwoImpl extends AbstraceTestClass{
    @Override
    public TestSmartInstanceEnumV2 getType() {
        return TestSmartInstanceEnumV2.GIFT_TO_COIN_SEND_RANK_ACTIVITY_V2;
    }


    @Override
    public String getTest() {
        String test = super.getTest();
        return test + "bbbbbbbb";
    }
}
