package annotation;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/4  9:37
 * @desc:
 */

public class Person {
    @Name("小明")
    private String Name;
    @Gender(gender = Gender.GenderType.Male)
    private String gender;
    @Profile(id = 1001, height = 180, nativePlace = "CN")
    private String profile;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
