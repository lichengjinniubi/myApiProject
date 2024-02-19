package api.service.impl.testAbstract;

import api.enums.TestSmartInstanceEnumV2;
import api.service.StrategyPatternTypeService;

public abstract class AbstraceTestClass implements StrategyPatternTypeService<TestSmartInstanceEnumV2> {

    public String getTest(){
        return "nnnnnnnnnnnnn";
    }
}
