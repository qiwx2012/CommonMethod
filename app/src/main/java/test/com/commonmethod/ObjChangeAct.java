package test.com.commonmethod;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/3/2  14:18
 * @desc: 改变对象
 */

public class ObjChangeAct extends Activity {

    TextView txtContent;
    UserInfo userInfo;
    String name;
    int age;
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    Stack<Activity> activityStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obj_change);
        txtContent = (TextView) findViewById(R.id.txtContent);
        userInfo = new UserInfo();
        userInfo.setAge(22);
        userInfo.setName("jame");
        age = userInfo.getAge();
        name = userInfo.getName();
        // txtContent.setText(userInfo.getName());
        txtContent.setText(userInfo.getAge() + "");
        findViewById(R.id.btnChange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfo.setName("lucy");
                userInfo.setAge(100);
                txtContent.setText(age + "");

            }
        });
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        //list = list1;//引用
        //list=list1.subList(0,list1.size());//引用
        //list.addAll(list1);//赋值
       // list=new ArrayList<>(list1);
        list=(ArrayList<String>) list1.clone();
        Log.i("dd", "list->"+list.toString());
        list1.set(0, "aaaaa");
        Log.i("dd", "list->"+list.toString());
        Log.i("dd", "list1->"+list1.toString());
        activityStack=new Stack<Activity>();
        try{
            if(!activityStack.isEmpty()){
                Activity a= activityStack.lastElement();
            }else{
                Log.i("dd", "list1->"+list1.toString());
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
