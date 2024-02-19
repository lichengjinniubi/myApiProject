package api.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class TestAspect {

    @Around("execution(* api.*.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        //获得方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ThirdAnnotation thirdAnnotation = method.getAnnotation(ThirdAnnotation.class);
        log.info("doAroundMethod logLevel:{} method:{}", thirdAnnotation != null ? thirdAnnotation.logLevel() : "empty", method.getName());

        //获取实例并获取其注解
        Class<?> targetClass = joinPoint.getTarget().getClass();
        String superClass = targetClass.getSuperclass().toString();
        ConditionalOnProperty conditionalOnProperty = targetClass.getAnnotation(ConditionalOnProperty.class);
        log.info("getClassInfo targetClass:{} superClass:{} conditionalOnProperty:{}", targetClass, superClass, conditionalOnProperty);


        //通过注解获取实例
//        Signature instance = joinPoint.getSignature();
//        ConditionalOnProperty conditionalOnProperty = instance.getClass().getAnnotation(ConditionalOnProperty.class);
//        log.info("ConditionalOnPropertyInfo class:{} value:{}", instance.toShortString(), conditionalOnProperty);
        Object result = joinPoint.proceed(args);
        log.info("processResult result:{}", result);
        return result;
    }


    @AfterReturning(value = "execution(* api.*.*.*(..))", returning = "retval")
    public void dealReturn(Object retval){
        log.info("dealReturn retval:{}", retval);
    }



    @AfterThrowing(value = "execution(* api.*.*.*(..))", throwing = "e")
    public void dealError(Exception e){
        log.info("dealError error:{}", e.getMessage());
    }

    @Before("execution(* api.*.*.*(..))")
    public void testBefore(){
        log.info("testBefore");
    }
}
