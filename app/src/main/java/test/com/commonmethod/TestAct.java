package test.com.commonmethod;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/9/5 10:14
 * @desc:
 */

public class TestAct extends FragmentActivity {
    Button btnMove;
    TextView view1;
    float x=10;
    float y=10;
    ViewGroup vp;
    View vv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        btnMove = (Button) findViewById(R.id.btnMove);
        view1 = (TextView)findViewById(R.id.view1);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                view1.scrollBy(10,10);
                x+=10;
                y+=10;
                ObjectAnimator.ofFloat(view1,"translationX",x,y).setDuration(100).start();
//                view1.scrollTo(10,10);
                view1.invalidate();
            }
        });
    }
}
