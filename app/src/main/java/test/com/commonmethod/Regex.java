package test.com.commonmethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/17  14:45
 * @desc: 参数注解类
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Regex {
    boolean canEmpty() default true;

    String[] regs();
}
