package api;

import api.service.impl.test.Test2ServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestApplication {


    public static void main(String[] args) {
         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("api");
         Test2ServiceImpl bean = applicationContext.getBean(Test2ServiceImpl.class);
         String s = bean.testString();
        System.out.println(s);
    }
}
