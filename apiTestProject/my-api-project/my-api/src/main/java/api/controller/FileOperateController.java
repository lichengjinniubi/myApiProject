package api.controller;

import api.service.ITestService;
import api.service.IUserService;
import api.service.file.FileOperate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FileOperateController {


    @Autowired
    private FileOperate fileOperate;

    @RequestMapping("/testFile")
    public String testFile(){
        fileOperate.fileInputTest();
        return "";
    }


    @RequestMapping("/testFileCopy")
    public String testFileCopy(){
        fileOperate.copyFileTest();
        return "";
    }








}
