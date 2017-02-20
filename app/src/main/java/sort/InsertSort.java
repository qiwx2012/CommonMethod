package sort;

import android.util.Log;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/20  14:30
 * @desc: 插入排序
 */

public class InsertSort {
    int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public void insertSort() {

        for (int i = 1; i < a.length; i++) {

            for (int j = i; j >= 0; j--) {
                //值互换
             /*   //方法1
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }*/
                //方法2
                if (a[j] < a[j - 1]) {
                    a[j] = a[j - 1] - a[j];//获取a和b的差
                    a[j - 1] = a[j - 1] - a[j];//换值1
                    a[j] = a[j - 1] + a[j];//换值2

                } else {
                    break;
                }
               /* //方法3
                if (a[j] < a[j - 1]) {
                    a[j] = a[j] ^ a[j - 1];
                    a[j - 1] = a[j] ^ a[j - 1];
                    a[j] = a[j] ^ a[j - 1];
                }*/


            }

        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "==");
        }
    }

    public void test() {
        int x = 9, y = 76;
      /*  x = y - x;
        y = y - x;
        x = x + y;*/
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        Log.i("dd", "x=" + x + "y=" + y);
    }

}
