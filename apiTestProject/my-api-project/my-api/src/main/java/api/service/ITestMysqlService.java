package api.service;

import api.bean.mysql.User;

public interface ITestMysqlService {

    User getUser(int id);


    void insertData(int id, String name, int tel);
}
