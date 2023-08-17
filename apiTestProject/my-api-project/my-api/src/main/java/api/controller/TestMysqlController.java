package api.controller;

import api.service.ITestMysqlService;
import api.service.ITestService;
import api.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestMysqlController {

    @Autowired
    private ITestMysqlService iTestMysqlService;


    @RequestMapping("/getUser")
    public String getUser(int id){

        return iTestMysqlService.getUser(id).toString();
    }








}
