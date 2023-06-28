package api.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ThirdAnnotation {

    /**
     * 日志等级
     *
     * @return
     */
    String logLevel() default "debug";
}
