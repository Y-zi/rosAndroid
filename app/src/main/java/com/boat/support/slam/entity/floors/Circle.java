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
public class Circle implements Parcelable {

    private Position position;
    private double radius;


    protected Circle(Parcel in) {
        position = in.readParcelable(Position.class.getClassLoader());
        radius = in.readDouble();
    }

    public static final Creator<Circle> CREATOR = new Creator<Circle>() {
        @Override
        public Circle createFromParcel(Parcel in) {
            return new Circle(in);
        }

        @Override
        public Circle[] newArray(int size) {
            return new Circle[size];
        }
    };

    public void setPosition(Position position) {
         this.position = position;
     }
     public Position getPosition() {
         return position;
     }

    public void setRadius(double radius) {
         this.radius = radius;
     }
     public double getRadius() {
         return radius;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(position, flags);
        dest.writeDouble(radius);
    }
}