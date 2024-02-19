package api.service.impl;

import api.bean.param.BaseParam;
import api.enums.OperateTypeEnum;
import api.enums.TestSmartInstanceEnum;
import api.enums.TestSmartInstanceEnumV2;
import api.manage.OperateTypeManager;
import api.manage.TestSmartInstanceManager;
import api.service.ICommonApiService;
import api.service.IOperateTypeService;
import api.service.ITestSmartInstance;
import api.service.ITestSmartInstanceV2;
import api.service.impl.testAbstract.AbstraceTestClass;
import api.service.testcelue.CelueInterface;
import api.service.testcelue.CelueManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommonApiServiceImpl implements ICommonApiService {

    @Autowired
    private OperateTypeManager operateTypeManager;

    @Autowired
    private TestSmartInstanceManager testSmartInstanceManager;


    @Autowired
    private CelueManager celueManager;


    Logger logger = LogManager.getLogger(CommonApiServiceImpl.class);
    @Override
    public String getOperateType(OperateTypeEnum operateTypeEnum) {

        IOperateTypeService iOperateTypeService = operateTypeManager.getOperateHandler(operateTypeEnum);
        return iOperateTypeService.getOperateEnum().getType();
    }

    @Override
    public TestSmartInstanceEnum getSmartInstance(TestSmartInstanceEnum testSmartInstanceEnum) {
        logger.error("testLichengjin");
        ITestSmartInstance instanceHandler = testSmartInstanceManager.getInstanceHandler(testSmartInstanceEnum);
        return instanceHandler.getType();
    }


    @Override
    public TestSmartInstanceEnumV2 getSmartInstanceV2(TestSmartInstanceEnumV2 testSmartInstanceEnum) {

        ITestSmartInstanceV2 instanceHandlerV2 = testSmartInstanceManager.getInstanceHandlerV2(testSmartInstanceEnum);
        return instanceHandlerV2.getType();
    }


    @Override
    public String getSmartInstanceV3(TestSmartInstanceEnumV2 testSmartInstanceEnum) {
        AbstraceTestClass instanceHandlerV3 = testSmartInstanceManager.getInstanceHandlerV3(testSmartInstanceEnum);
        return instanceHandlerV3.getTest();
    }

    @Override
    public String getData(OperateTypeEnum operateTypeEnum) {
        CelueInterface handler = celueManager.getHandler(operateTypeEnum);
        BaseParam baseParam = new BaseParam();
        return handler.getData(baseParam);
    }
}
