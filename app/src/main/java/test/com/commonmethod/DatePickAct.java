package test.com.commonmethod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import utils.Commons;
import widget.TimePickerDialog;

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
                maxDate = Commons.getAmountDate(Calendar.DATE, 5);
                minDate = Commons.getAmountDate(Calendar.DATE, -4);
                new TimePickerDialog
                        .Builder(DatePickAct.this)
                        .setIsShowDay(true)
                        .setMaxDate(maxDate)
                        .setminDate(minDate)
                        .setTitle("选择时间")
                        .setOnDateSelectListener(new TimePickerDialog.OnDateSelectListener() {
                            @Override
                            public void onDateSelected(String dateStr) {
                                Toast.makeText(DatePickAct.this, dateStr, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build().show();


            }
        });
    }
}
