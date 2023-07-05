package api;


import coreService.service.impl.CoreUserServiceImpl;
import coreService.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppApplicationV2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CoreUserServiceImpl.class);
        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(CoreUserServiceImpl.class));

    }
}
