package widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;


/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/12/14 20:39
 * @desc:
 */
public class QNumberPicker extends NumberPicker {

    public QNumberPicker(Context context) {
        super(context);
    }

    public QNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    public void updateView(View view) {
        if (view instanceof EditText) {
            //这里修改字体的属性
            EditText etNumber = ((EditText) view);
            etNumber.setTextColor(getResources().getColor(android.R.color.black));
            etNumber.setTextSize(16);
        }
    }
}