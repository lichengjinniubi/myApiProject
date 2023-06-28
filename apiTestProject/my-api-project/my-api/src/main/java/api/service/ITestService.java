package api.service;

import api.manager.TestInterFace;

import java.util.Map;

public interface ITestService {


    String getTestData();


    Map<String, TestInterFace> getBeanObject();


    String getInterfaceStr();
}
