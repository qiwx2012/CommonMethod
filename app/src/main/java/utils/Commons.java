package utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by qiwx on 2017/1/2.
 */

public class Commons {


    Context mContext;
    //这是分支项目

    public Commons(Context context) {
        mContext = context;
    }

    //获取SDCard/Android/data/你的应用的包名/files/ 目录/，一般放一些长时间保存的数据
    //idr 是目录 可以为空没有此目录自动创建
    public String getExternalFilesDir(String dir) {
        if (null == dir)
            dir = "";
        return mContext.getExternalFilesDir(dir).getAbsolutePath() + File.separator;

    }
    //通过Context.getExternalCacheDir()方法可以获取到 SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据

    public String getExternalCatchDir() {
        return mContext.getExternalCacheDir().getAbsolutePath() + File.separator;

    }

    //获取sd卡目录SDCard/0/
    public String getSdPath() {
        String path = "";
        File file = null;
        boolean sdExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdExist) {
            file = Environment.getExternalStorageDirectory();
        } else {
            path = "";
        }
        path = file.getAbsolutePath() + File.separator;
        return path;
    }
   /*选择与与当天相差
     field 相差域 年月日
     amount 相差值 正数当天以后，负数当天以前
   */

    public static Date getAmountDate(int field, int amount) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();

    }

}
