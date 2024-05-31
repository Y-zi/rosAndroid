/**
  * Copyright 2022 json.cn 
  */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2022-04-28 15:55:37
 *
 * @author json.cn (i@json.cn)
 *
 */
public class F2 implements Parcelable {

    private String y;
    private String x;

    protected F2(Parcel in) {
        y = in.readString();
        x = in.readString();
    }

    public static final Creator<F2> CREATOR = new Creator<F2>() {
        @Override
        public F2 createFromParcel(Parcel in) {
            return new F2(in);
        }

        @Override
        public F2[] newArray(int size) {
            return new F2[size];
        }
    };

    public void setY(String y) {
         this.y = y;
     }
     public String getY() {
         return y;
     }

    public void setX(String x) {
         this.x = x;
     }
     public String getX() {
         return x;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(y);
        dest.writeString(x);
    }
}