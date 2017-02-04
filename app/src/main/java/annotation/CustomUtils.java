package annotation;

import android.util.Log;

import java.lang.reflect.Field;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/4  9:41
 * @desc:
 */

public class CustomUtils {


    public static void getInfo(Class<?> clazz) {
        String name = "";
        String gerder = "";
        String profile = "";
        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {
                Name arg0 = field.getAnnotation(Name.class);
                name = name + arg0.value();
                Log.i("dd", "name=" + name);
            }
            if (field.isAnnotationPresent(Gender.class)) {
                Gender arg0 = field.getAnnotation(Gender.class);
                gerder = gerder + arg0.gender().toString();
                Log.i("dd", "gender=" + gerder);
            }
            if (field.isAnnotationPresent(Profile.class)) {
                Profile arg0 = field.getAnnotation(Profile.class);
                profile = "[id=" + arg0.id() + ",height=" + arg0.height() + ",nativeplace=" + arg0.nativePlace() + "]";
                Log.i("dd", "profile=" + profile);
            }
        }
    }


}
