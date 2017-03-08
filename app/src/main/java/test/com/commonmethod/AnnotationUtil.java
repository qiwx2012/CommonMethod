package test.com.commonmethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/17  14:54
 * @desc: 通过注解对java类进行校验
 */

public class AnnotationUtil {

    private static final Logger logger = Logger.getLogger("AnnotationUtil");

    public static String checkValue(Object obj) {
        return parseAnnotation(CheckValue.class, obj, true);
    }
    public static String checkEmpty(Object obj) {
        return parseAnnotation(MNotEmpty.class, obj, true);
    }


    private static String parseAnnotation(Class<? extends Annotation> aClazz, Object obj, boolean hasParent) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Field[] bothField = fields;
      /*  if (hasParent) {
            Class<?> superClazz = clazz.getSuperclass();
            Field[] superFields = superClazz.getDeclaredFields();
            bothField = (Field[]) ArrayUtils.addAll(fields, superFields);
        }*/

        for (Field field : bothField) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(aClazz);
            if (annotation == null)
                continue;
            field.setAccessible(true);

            try {
                if (annotation instanceof CheckValue) {
                    CheckValue cv = (CheckValue) annotation;
                    String regex = cv.value();
                    if (regex.toString().isEmpty()) {
                        // 输入的正则表达式为空，所以不做校验
                        // continue;
                        // MNotEmpty ne = (MNotEmpty)annotation;
                        Object oValue = field.get(obj);
                        if (oValue == null) {
                            sb.append("字段" + field.getName() + "不能为null|");
                            flag = true;
                        } else {
                            if (oValue instanceof String) {
                                String value = (String) oValue;
                                if (value.isEmpty()) {
                                    sb.append("字段" + field.getName() + "不能为空|");
                                    flag = true;
                                }
                            } else {
                                logger.info("字段" + field.getName() + "不是字符串，不能判断是否为空");
                            }
                        }
                    } else {
                        Pattern pattern = Pattern.compile(regex);
                        String value = String.valueOf(field.get(obj));
                        Matcher m = pattern.matcher(value);
                        if (!m.matches()) {
                            sb.append("字段" + field.getName() + "格式错误|");
                            flag = true;
                        }
                    }

                } else if (annotation instanceof MNotEmpty) {
                    Object oValue = field.get(obj);
                    Boolean isCanEmpty=((MNotEmpty) annotation).value();
                    if(isCanEmpty){

                    }else{
                        if (oValue == null) {
                            sb.append("字段" + field.getName() + "不能为null|");
                            flag = true;
                        } else {
                            if (oValue instanceof Boolean) {
                                String value = String.valueOf(oValue);
                                if (value.isEmpty()) {
                                    sb.append("字段" + field.getName() + "不能为空|");
                                    flag = true;
                                }
                            } else {
                                logger.info("字段" + field.getName() + "不是字符串，不能判断是否为空");
                            }
                        }
                    }


                }
            } catch (Exception e) {
                sb.append(e.getMessage());
                flag = true;
               // logger.error("解析注解出错：", e);
                // e.printStackTrace();
            }

        }

        if (flag) {
            return sb.toString();
        } else {
            return null;
        }
    }
}
