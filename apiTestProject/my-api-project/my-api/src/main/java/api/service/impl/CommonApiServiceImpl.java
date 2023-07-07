package api.service.impl;

import api.enums.OperateTypeEnum;
import api.manage.OperateTypeManager;
import api.service.ICommonApiService;
import api.service.IOperateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonApiServiceImpl implements ICommonApiService {

    @Autowired
    private OperateTypeManager operateTypeManager;

    @Override
    public String getOperateType(OperateTypeEnum operateTypeEnum) {
        IOperateTypeService iOperateTypeService = operateTypeManager.getOperateHandler(operateTypeEnum);
        return iOperateTypeService.getOperateEnum().getType();
    }
}
