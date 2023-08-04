package api.controller;


import api.enums.OperateTypeEnum;
import api.enums.TestSmartInstanceEnum;
import api.enums.TestSmartInstanceEnumV2;
import api.manage.TypeOperateHanlder;
import api.service.ICommonApiService;
import api.service.IOperateTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OperateTypeController {





    @Autowired
    private ICommonApiService iCommonApiService;


    @RequestMapping("/getOperate")
    public String getOperate(){
        return iCommonApiService.getOperateType(OperateTypeEnum.OPERATE_FIRST);
    }


    @RequestMapping("/getSmartInstance")
    public String getSmartInstance(){
        TestSmartInstanceEnum smartInstance = iCommonApiService.getSmartInstance(TestSmartInstanceEnum.FOREST_CANDLE_ACTIVITY);
        return smartInstance.name();
    }

    @RequestMapping("/getSmartInstanceV2")
    public String getSmartInstanceV2(String type){
        TestSmartInstanceEnumV2 testSmartInstanceEnumV2 = TestSmartInstanceEnumV2.valueOf(type);
        TestSmartInstanceEnumV2 smartInstance = iCommonApiService.getSmartInstanceV2(testSmartInstanceEnumV2);
        return smartInstance.name();
    }
}
