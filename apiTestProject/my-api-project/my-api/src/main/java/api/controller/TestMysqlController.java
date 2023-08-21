package api.controller;

import api.service.ITestMysqlService;
import api.service.ITestService;
import api.service.IUserService;
import api.service.impl.TestMysqlServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
public class TestMysqlController {

    @Autowired
    private ITestMysqlService iTestMysqlService;

    Logger logger = LogManager.getLogger(TestMysqlController.class);


    @RequestMapping("/getUser")
    public String getUser(int id){
        log.info("getUserController");
        return iTestMysqlService.getUser(id).toString();
    }

    @RequestMapping("/insertUser")
    public void insertUser(int id, String name, int tel){
        log.info("insertUserInfoForSlf4j");
        logger.info("insertUserInfo");
        iTestMysqlService.insertData(id, name, tel);
    }








}
