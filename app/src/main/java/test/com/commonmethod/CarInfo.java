package test.com.commonmethod;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: qiwx
 * email: qiwx@jingzhengu.com
 * @time: 2017/2/17  14:01
 * @desc:
 */

public class CarInfo implements Parcelable {
    @MNotEmpty()
    String id;
    @CheckValue("^[0-9]")
    double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*public boolean isParamEmpty() {
        boolean isEmpty = false;
        Field[] fields=getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Field f = fields[i];
            f.setAccessible(true);
            f.getName();
            f.get(CarInfo.this)

            Type type = fields[i].getGenericType();    //获取属性的类型
            Integer s;


        }


        return isEmpty;
    }*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeDouble(this.price);
    }

    public CarInfo() {
    }

    protected CarInfo(Parcel in) {
        this.id = in.readString();
        this.price = in.readDouble();
    }

    public static final Parcelable.Creator<CarInfo> CREATOR = new Parcelable.Creator<CarInfo>() {
        @Override
        public CarInfo createFromParcel(Parcel source) {
            return new CarInfo(source);
        }

        @Override
        public CarInfo[] newArray(int size) {
            return new CarInfo[size];
        }
    };
}
