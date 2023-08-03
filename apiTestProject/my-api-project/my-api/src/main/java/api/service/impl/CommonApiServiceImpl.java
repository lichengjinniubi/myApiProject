package api.service.impl;

import api.enums.OperateTypeEnum;
import api.enums.TestSmartInstanceEnum;
import api.enums.TestSmartInstanceEnumV2;
import api.manage.OperateTypeManager;
import api.manage.TestSmartInstanceManager;
import api.service.ICommonApiService;
import api.service.IOperateTypeService;
import api.service.ITestSmartInstance;
import api.service.ITestSmartInstanceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonApiServiceImpl implements ICommonApiService {

    @Autowired
    private OperateTypeManager operateTypeManager;

    @Autowired
    private TestSmartInstanceManager testSmartInstanceManager;

    @Override
    public String getOperateType(OperateTypeEnum operateTypeEnum) {
        IOperateTypeService iOperateTypeService = operateTypeManager.getOperateHandler(operateTypeEnum);
        return iOperateTypeService.getOperateEnum().getType();
    }

    @Override
    public TestSmartInstanceEnum getSmartInstance(TestSmartInstanceEnum testSmartInstanceEnum) {
        ITestSmartInstance instanceHandler = testSmartInstanceManager.getInstanceHandler(testSmartInstanceEnum);
        return instanceHandler.getType();
    }


    @Override
    public TestSmartInstanceEnumV2 getSmartInstanceV2(TestSmartInstanceEnumV2 testSmartInstanceEnum) {
        ITestSmartInstanceV2 instanceHandlerV2 = testSmartInstanceManager.getInstanceHandlerV2(testSmartInstanceEnum);
        return instanceHandlerV2.getType();
    }
}
