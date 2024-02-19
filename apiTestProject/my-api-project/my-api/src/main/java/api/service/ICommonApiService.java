package api.service;

import api.enums.OperateTypeEnum;
import api.enums.TestSmartInstanceEnum;
import api.enums.TestSmartInstanceEnumV2;

public interface ICommonApiService {


    String getOperateType(OperateTypeEnum operateTypeEnum);


    TestSmartInstanceEnum getSmartInstance(TestSmartInstanceEnum testSmartInstanceEnum);

    TestSmartInstanceEnumV2 getSmartInstanceV2(TestSmartInstanceEnumV2 testSmartInstanceEnum);

    String getSmartInstanceV3(TestSmartInstanceEnumV2 testSmartInstanceEnum);


    String getData(OperateTypeEnum operateTypeEnum);
}
