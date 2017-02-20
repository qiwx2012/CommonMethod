package test.com.commonmethod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import annotation.CustomUtils;
import annotation.Person;
import sort.InsertSort;
import utils.Commons;

public class MainActivity extends AppCompatActivity {

    Commons mCommon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = new Commons(this).getExternalFilesDir("11");
        mCommon = new Commons(this);
        path = mCommon.getExternalCatchDir();
        path = mCommon.getSdPath();
        TextView tv = (TextView) findViewById(R.id.txtContent);
        tv.setText(path);
        Log.i("dd", path);
        CustomUtils.getInfo(Person.class);
        CarInfo carInfo = new CarInfo();
        carInfo.setId("");
        carInfo.setPrice(33);
        try {
            AnnotationUtil.checkValue(carInfo);
           // reflect(carInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new InsertSort().test();


    }


    public void reflect(CarInfo e) throws Exception {
        Class cls = e.getClass();
        Field[] fields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            String methodName = method.getName();
            System.out.println("方法名+++++:" + methodName);
            if (methodName.contains("get")) {
                Object object = method.invoke(e);
                System.out.println("方法名:" + methodName + "值：" + String.valueOf(object));
            }
        }

        /*for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(e));
        }*/
    }
}
