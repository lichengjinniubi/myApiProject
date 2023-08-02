package api.service.impl;

import api.enums.OperateTypeEnum;
import api.enums.TestSmartInstanceEnum;
import api.manage.OperateTypeManager;
import api.manage.TestSmartInstanceManager;
import api.service.ICommonApiService;
import api.service.IOperateTypeService;
import api.service.ITestSmartInstance;
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
}
