package api.service;

import api.enums.TestSmartInstanceEnum;

public interface ITestSmartInstance extends StrategyPatternTypeService<TestSmartInstanceEnum>{

    public TestSmartInstanceEnum getType();

}
