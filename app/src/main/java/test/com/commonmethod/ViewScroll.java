package test.com.commonmethod;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by JZG on 2017/3/23.
 */

public class ViewScroll extends Activity {

    View view1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_scroll);
        view1=findViewById(R.id.view1);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scroller scroller=new Scroller(ViewScroll.this);
                view1.computeScroll();

            }
        });
    }


}
