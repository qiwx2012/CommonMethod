package widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import test.com.commonmethod.R;

/**
 * email: qiwx@jingzhengu.com
 *
 * @time: 2017/3/13
 * @desc:
 */
public class TimePickerDialog {

    private Activity mContext;
    private OnDateSelectListener mListener;

    String title;
    QNumberPicker npYear;
    QNumberPicker npMonth;
    QNumberPicker npDay;
    TextView tvDay;
    boolean isShowDay = true;//是否显示天,默认显示
    Date maxDate;
    Date minDate;
    Date selectDate;
    int scroll2Year;
    int scroll2Month;
    Calendar minCalendar;
    Calendar maxCalendar;
    Calendar selectCalendar;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");


    public TimePickerDialog() {

    }

    private TimePickerDialog(TimePickerDialog td) {
        //当前日期
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //最大日期
        if (null == td.maxDate) {
            calendar.add(calendar.YEAR, 100);
            maxDate = calendar.getTime();
        } else {
            this.maxDate = td.maxDate;
        }
        //最小日期
        if (null == td.minDate) {
            calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.YEAR, -100);
            minDate = calendar.getTime();
        } else {
            this.minDate = td.minDate;
        }
        //默认选择日期
        if (null == td.selectDate) {
            calendar = new GregorianCalendar();
            calendar.setTime(date);
            selectDate = calendar.getTime();
        } else {
            selectDate = td.selectDate;
        }
        this.isShowDay = td.isShowDay;
        this.title = td.title;
        this.mContext = td.mContext;
        this.mListener = td.mListener;
    }


    /* title 标题
    *  maxDate 最大日期限制
    *  minDate 最小日期限制
    *  listener 选择监听
    *
    *
    * */
    // 对打
   /* public void showDateDialog(String title, Date maxDate, Date minDate, OnDateSelectListener listener) {

        showDateDialog(title, maxDate, minDate, true, listener);
    }

    public void showDateDialog(String title, Date maxDate, Date minDate, boolean isShowDay, OnDateSelectListener listener) {
        this.title = title;
        this.mListener = listener;
        this.isShowDay = isShowDay;
        this.maxDate = maxDate;
        this.minDate = minDate;
        View view = mContext.getLayoutInflater().inflate(R.layout.layout_year_month_picker, null);
       // initView(view, isShowDay);
    }*/

    private void initView() {
        View view = mContext.getLayoutInflater().inflate(R.layout.layout_year_month_picker, null);
        npYear = (QNumberPicker) view.findViewById(R.id.npYear);
        npMonth = (QNumberPicker) view.findViewById(R.id.npMonth);
        npDay = (QNumberPicker) view.findViewById(R.id.npDay);
        tvDay = (TextView) view.findViewById(R.id.tvDay);
        npYear.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        npMonth.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        npDay.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        npYear.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                scroll2Year = view.getValue();
                updateMonth(scroll2Year);
                updateDay(scroll2Year, scroll2Month);
            }
        });
        npMonth.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                scroll2Month = view.getValue();
                updateDay(scroll2Year, scroll2Month);

            }
        });
        npDay.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {


            }
        });
        selectCalendar = Calendar.getInstance();
        maxCalendar = Calendar.getInstance();
        minCalendar = Calendar.getInstance();
        //最大日期
        maxCalendar.setTime(maxDate);
        npYear.setMaxValue(maxCalendar.get(Calendar.YEAR));
       /* npMonth.setMaxValue(12);
        npMonth.setMinValue(1);
        npDay.setMaxValue(30);
        npDay.setMinValue(1);*/
        //最小日期
        minCalendar.setTime(minDate);
        npYear.setMinValue(minCalendar.get(Calendar.YEAR));
        //选择日期
        selectCalendar.setTime(selectDate);
        scroll2Year = selectCalendar.get(Calendar.YEAR);
        scroll2Month = selectCalendar.get(Calendar.MONTH) + 1;
        npYear.setValue(scroll2Year);
        updateMonth(scroll2Year);
        npMonth.setValue(scroll2Month);
        updateDay(scroll2Year, scroll2Month);
        npDay.setValue(selectCalendar.get(Calendar.DATE));
        //如果isShow为false天不显示
        if (!isShowDay) {
            tvDay.setVisibility(View.GONE);
            npDay.setVisibility(View.GONE);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(view);
        builder.setTitle(title)
                .setPositiveButton("确定", new DialogOkListener())
                .setNegativeButton("取消", new DialogCancleListener())
                .create()
                .show();
    }

    //更新月份
    private void updateMonth(int scroll2Year) {

        Date date = null;
        Date max = null;
        Date min = null;
        try {
            max = sdf.parse(maxCalendar.get(Calendar.YEAR) + "-" + (maxCalendar.get(Calendar.MONTH) + 1));
            min = sdf.parse(minCalendar.get(Calendar.YEAR) + "-" + (maxCalendar.get(Calendar.MONTH) + 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (null == max || null == min)
            return;
        try {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                date = sdf.parse(scroll2Year + "-" + (i + 1));
                if (date.after(min) && date.before(max)) {
                    temp.add(i);
                }
            }
            if (temp.size() >= 1) {
                npMonth.setMinValue(temp.get(0) + 1);
                npMonth.setValue(temp.get(0) + 1);
                npDay.setValue(1);
                npMonth.setMaxValue(temp.get(temp.size() - 1) + 1);

            } else {
                npMonth.setMaxValue(maxCalendar.get(Calendar.MONTH) + 1);
                npMonth.setMinValue(maxCalendar.get(Calendar.MONTH) + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //更新日期
    private void updateDay(int scroll2Year, int scroll2Month) {
        Date date = null;
        try {
            int maxDays = getMonthMaxDays(scroll2Year, scroll2Month);
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < maxDays; i++) {
                date = sdf1.parse(scroll2Year + "-" + (scroll2Month) + "-" + (i + 1));
                if (date.after(minDate) && date.before(maxDate)) {
                    temp.add(i);
                }
            }
            if (temp.size() >= 1) {
                npDay.setMinValue(temp.get(0) + 1);
                npDay.setValue(temp.get(0) + 1);
                npDay.setMaxValue(temp.get(temp.size() - 1) + 1);
            } else {
                npDay.setMinValue(selectCalendar.get(Calendar.DATE));
                npDay.setValue(selectCalendar.get(Calendar.DATE));
                npDay.setMaxValue(selectCalendar.get(Calendar.DATE));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    class DialogOkListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            if (isShowDay) {
                mListener.onDateSelected(npYear.getValue() + "-" + npMonth.getValue() + "-" + npDay.getValue());
            } else {
                mListener.onDateSelected(npYear.getValue() + "-" + npDay.getValue());
            }


        }
    }

    class DialogCancleListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();


        }
    }

    //获取选择日期
    private Date getSelectedDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int year = npYear.getValue();
        int month = npMonth.getValue();
        int day = npDay.getValue();
        String dd = "" + year + "-" + month + "-" + day;
        Date selectDate = null;
        try {
            selectDate = df.parse(dd);
        } catch (ParseException e) {
            e.printStackTrace();
            selectDate = new Date();
        }
        return selectDate;
    }

    public interface OnDateSelectListener {
        void onDateSelected(String dateStr);
    }

    //返回当前月天数
    private int getMonthMaxDays(int selectedYear, int selectedMonth) {
        int maxday = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date date = sdf.parse(selectedYear + "-" + selectedMonth);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date);
            maxday = calendar1.getActualMaximum(Calendar.DATE);

        } catch (Exception e) {
            e.printStackTrace();
            maxday = 31;
        }
        return maxday;
    }

    public void show() {
        initView();

    }

    public static class Builder {
        TimePickerDialog target;

        public Builder(Activity context) {
            target = new TimePickerDialog();
            target.mContext = context;
        }

        public Builder setMaxDate(Date maxDate) {
            target.maxDate = maxDate;
            return this;
        }

        public Builder setminDate(Date minDate) {
            target.minDate = minDate;
            return this;
        }

        public Builder setTitle(String title) {
            target.title = title;
            return this;

        }

        public Builder setIsShowDay(boolean isShowDay) {
            target.isShowDay = isShowDay;
            return this;
        }

        public Builder setOnDateSelectListener(OnDateSelectListener mListener) {
            target.mListener = mListener;
            return this;
        }

        public TimePickerDialog build() {
            return new TimePickerDialog(target);
        }

    }


}
