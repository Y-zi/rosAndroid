/**
  * Copyright 2022 json.cn 
  */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2022-04-28 15:54:38
 *
 * @author json.cn (i@json.cn)
 *
 */
public class Position implements Parcelable {

    private double y;
    private double x;

    protected Position(Parcel in) {
        y = in.readDouble();
        x = in.readDouble();
    }

    public static final Creator<Position> CREATOR = new Creator<Position>() {
        @Override
        public Position createFromParcel(Parcel in) {
            return new Position(in);
        }

        @Override
        public Position[] newArray(int size) {
            return new Position[size];
        }
    };

    public void setY(Double y) {
         this.y = y;
     }
     public double getY() {
         return y;
     }

    public void setX(double x) {
         this.x = x;
     }
     public double getX() {
         return x;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(y);
        dest.writeDouble(x);
    }
}