package test.com.commonmethod;

import java.io.Serializable;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/3/2  14:20
 * @desc:
 */

public class UserInfo implements Serializable {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
