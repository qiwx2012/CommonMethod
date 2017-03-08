package test.com.commonmethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import widget.YearMonthDialog;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/3/8  14:16
 * @desc:
 */

public class DatePickAct extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_date_pick);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date maxDate;
                Date minDate;
                Date date = new Date();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                calendar.add(calendar.MONTH, 12);//把日期往后增加一天.整数往后推,负数往前移动
                maxDate = calendar.getTime();   //这个时间就是日期往后推一天的结果
                calendar.setTime(date);
                calendar.add(calendar.MONTH, -5);
                minDate = calendar.getTime();
                new YearMonthDialog(DatePickAct.this).showDateDialog("选择时间", maxDate, minDate,false, new YearMonthDialog.OnDateSelectListener() {
                    @Override
                    public void onDateSelected(String dateStr) {
                        Toast.makeText(DatePickAct.this,dateStr,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
