package list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/7/6 14:33
 * @desc:
 */

public class StudentTest extends Activity {
    Object ob=true;
    Boolean a=(Boolean) ob;
    Integer ac=10;
    int ab=ac;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv=new TextView(this);
        ArrayList<String> list = new ArrayList<String>();
        list.add("001");
        list.add("002");
        Student s = new Student("Tom", list);
        s.addCourses("99");
        //ArrayList<String> arrayList=s.getCourse();
        //arrayList.add("ddd");
        System.out.println(s.getCourse().size()+"=====");
        setContentView(tv);
    }
}
