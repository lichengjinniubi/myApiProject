package api;


import api.enums.OperateTypeEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }


    public static void getData(Object ...args){
        for(Object s : args){
            System.out.println(s);
        }




    }
}
