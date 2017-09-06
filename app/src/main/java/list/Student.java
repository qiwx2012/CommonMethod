package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/7/6 14:30
 * @desc:
 */

public class Student {
    private String name;
    private List<String> course;

    public Student(String name,ArrayList<String> course){
        this.name=name;
        this.course=course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourse() {
        return Collections.unmodifiableList(course);
    }
    public void addCourses(String course){
        this.course.add(course);

    }
}
