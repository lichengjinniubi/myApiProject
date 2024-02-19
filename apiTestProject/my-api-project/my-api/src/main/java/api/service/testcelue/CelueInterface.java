package api.service.testcelue;

import api.bean.param.BaseParam;
import api.enums.OperateTypeEnum;

public interface CelueInterface<E extends BaseParam> {

    OperateTypeEnum getEnum();


    String getData(E baseParam);




    String getDataV2();
}
