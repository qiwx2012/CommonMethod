package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/4  9:34
 * @desc:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile {
    public int id() default -1;

    public int height() default 0;

    public String nativePlace() default "";


}
