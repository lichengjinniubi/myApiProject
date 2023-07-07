package api.controller;


import api.enums.OperateTypeEnum;
import api.manage.TypeOperateHanlder;
import api.service.ICommonApiService;
import api.service.IOperateTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
