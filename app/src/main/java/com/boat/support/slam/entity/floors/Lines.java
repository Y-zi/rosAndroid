/**
  * Copyright 2022 json.cn 
  */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2022-04-25 16:42:5
 *
 * @author json.cn (i@json.cn)
 *
 */
public class Lines implements Parcelable {

    private double x;
    private double y;
    public Lines(){

    }

    protected Lines(Parcel in) {
        x = in.readDouble();
        y = in.readDouble();
    }

    public static final Creator<Lines> CREATOR = new Creator<Lines>() {
        @Override
        public Lines createFromParcel(Parcel in) {
            return new Lines(in);
        }

        @Override
        public Lines[] newArray(int size) {
            return new Lines[size];
        }
    };

    public void setX(double x) {
         this.x = x;
     }
     public double getX() {
         return x;
     }

    public void setY(double y) {
         this.y = y;
     }
     public double getY() {
         return y;
     }

    @Override
    public String toString() {
        return "Lines{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(x);
        dest.writeDouble(y);
    }
}