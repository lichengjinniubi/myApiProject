package api.controller;

import api.manager.TestInterFace;
import api.service.ITestService;
import api.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class TestOneController {


    @Autowired
    private ITestService iTestService;

    @Autowired
    private IUserService iUserService;


    @RequestMapping("/getCar")
    public String getCar(){
        log.error("testGetCar {}", 3333);
        return iTestService.getTestData();
    }


    @RequestMapping("/testCondition")
    public String testCondition(){
        return iUserService.getUserName();
    }






}
