package test.com.commonmethod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import annotation.CustomUtils;
import annotation.Person;
import utils.Commons;

public class MainActivity extends AppCompatActivity {

    Commons mCommon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path=new Commons(this).getExternalFilesDir("11");
        mCommon=new Commons(this);
        path=mCommon.getExternalCatchDir();
        path=mCommon.getSdPath();
        TextView tv=(TextView) findViewById(R.id.txtContent);
        tv.setText(path);
        Log.i("dd",path);
        CustomUtils.getInfo(Person.class);
    }
}
