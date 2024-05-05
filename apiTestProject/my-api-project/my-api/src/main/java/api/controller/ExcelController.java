package api.controller;

import api.service.excel.ExcelUtil;
import api.service.excel.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ExcelController {

    @RequestMapping("testExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {

        UserEntity user1 = UserEntity.builder().id(1L).userName("张三").age(10).birth(new Date()).build();
        UserEntity user2 = UserEntity.builder().id(2L).userName("小李").age(16).birth(new Date()).build();
        UserEntity user3 = UserEntity.builder().id(3L).userName("小王").age(14).birth(new Date()).build();
        List<UserEntity> userList = Stream.of(user1, user2, user3).collect(Collectors.toList());

        //导出操作
        ExcelUtil.exportExcel(userList, null, "用户", UserEntity.class, "测试用户导出.xlsx", response);

    }
}
