package widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import test.com.commonmethod.R;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/9/6 14:19
 * @desc:
 */

public class CircleView extends View {
    private int mColor = Color.BLUE;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = typedArray.getColor(R.styleable.CircleView_circle_color, Color.BLUE);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //pading必须自己处理
        int padingleft = getPaddingLeft();
        Log.e("dd", "padleft:" + padingleft);
        int padingright = getPaddingRight();
        Log.e("dd", "padingright:" + padingright);
        int padingTop = getPaddingTop();
        Log.e("dd", "padingTop:" + padingTop);
        int padingBottom = getPaddingBottom();
        Log.e("dd", "padingBottom:" + padingBottom);

        int width = getWidth() - padingleft - padingright;
        int height = getHeight() - padingTop - padingBottom;
        Log.e("dd", "width:" + getWidth() + "height:" + getHeight());
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(padingleft + width / 2, padingTop + height / 2, radius, mPaint);

    }
}
