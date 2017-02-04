package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/4  9:29
 * @desc:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {

    public enum GenderType {
        Male("男"),
        Female("女"),
        Other("中性");
        public String genderStr;

        private GenderType(String arg) {
            genderStr = arg;
        }

        @Override
        public String toString() {
            return genderStr;
        }
    }

    GenderType gender() default GenderType.Male;
}
