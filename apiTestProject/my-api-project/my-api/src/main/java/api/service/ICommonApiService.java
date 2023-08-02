package api.service;

import api.enums.OperateTypeEnum;
import api.enums.TestSmartInstanceEnum;

public interface ICommonApiService {


    String getOperateType(OperateTypeEnum operateTypeEnum);


    TestSmartInstanceEnum getSmartInstance(TestSmartInstanceEnum testSmartInstanceEnum);
}
