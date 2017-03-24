package test.com.commonmethod;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fragment.FrgRecycleViewDmeo;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/3/24 15:49
 * @desc: 容器 测试代码
 */

public class ActContainer extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_container);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.flContent, new FrgRecycleViewDmeo());
        ft.commitAllowingStateLoss();
    }
}
