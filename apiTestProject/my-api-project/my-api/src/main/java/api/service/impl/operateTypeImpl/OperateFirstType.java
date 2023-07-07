package api.service.impl.operateTypeImpl;

import api.enums.OperateTypeEnum;
import api.manage.TypeOperateHanlder;
import api.service.IOperateTypeService;
import org.springframework.stereotype.Service;


@Service
public class OperateFirstType extends TypeOperateHanlder {


    @Override
    public OperateTypeEnum getOperateEnum() {
        return OperateTypeEnum.OPERATE_FIRST;
    }


}
