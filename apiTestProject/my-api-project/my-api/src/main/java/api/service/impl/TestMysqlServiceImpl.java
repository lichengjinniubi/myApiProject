package api.service.impl;

import api.bean.mysql.User;
import api.mybatis.mapper.UserMapper;
import api.service.ITestMysqlService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestMysqlServiceImpl implements ITestMysqlService {

    Logger logger = LogManager.getLogger(TestMysqlServiceImpl.class);
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUser(int id) {
        User user = new User();
        try {

            user = userMapper.findById(id);
        }catch (Exception e){
            logger.error("getUserError", e);
        }
        logger.info("getUserId id:{} user:{}", id, user);
        return user;
    }


    @Override
    public void insertData(int id, String name, int tel) {
        try {
            userMapper.insertData(id, name, tel);
        }catch (Exception e) {
            logger.error("insertDataError", e);
        }
    }
}
