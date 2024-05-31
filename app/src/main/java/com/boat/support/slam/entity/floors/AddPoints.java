/**
  * Copyright 2023 json.cn 
  */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2023-03-08 13:16:44
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class AddPoints implements Parcelable {

    private long y;
    private long x;

    protected AddPoints(Parcel in) {
        y = in.readLong();
        x = in.readLong();
    }

    public static final Creator<AddPoints> CREATOR = new Creator<AddPoints>() {
        @Override
        public AddPoints createFromParcel(Parcel in) {
            return new AddPoints(in);
        }

        @Override
        public AddPoints[] newArray(int size) {
            return new AddPoints[size];
        }
    };

    public void setY(long y) {
         this.y = y;
     }
     public long getY() {
         return y;
     }

    public void setX(long x) {
         this.x = x;
     }
     public long getX() {
         return x;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(y);
        dest.writeLong(x);
    }

    @Override
    public String toString() {
        return "AddPoints{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}