package api.service.testcelue.impl;

import api.bean.param.BaseParam;
import api.bean.param.TestOneParam;
import api.enums.OperateTypeEnum;
import api.service.testcelue.AbstracrCelue;
import api.service.testcelue.CelueInterface;
import org.springframework.stereotype.Service;

@Service
public class TestOneImpl implements CelueInterface<TestOneParam> {

    @Override
    public OperateTypeEnum getEnum(){
        return OperateTypeEnum.OPERATE_FIRST;
    }


    @Override
    public String getData(TestOneParam baseParam) {
        return "hhhhhhhh";
    }

    @Override
    public String getDataV2() {
        return "kkkkkkkk";
    }
}
