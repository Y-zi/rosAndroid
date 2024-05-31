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
public class SystemPoints implements Parcelable {

    private double positionYaw;
    private double positionX;
    private double positionY;
    private long pointId;
    private String pointName;

    protected SystemPoints(Parcel in) {
        positionYaw = in.readDouble();
        positionX = in.readDouble();
        positionY = in.readDouble();
        pointId = in.readLong();
        pointName = in.readString();
    }

    public static final Creator<SystemPoints> CREATOR = new Creator<SystemPoints>() {
        @Override
        public SystemPoints createFromParcel(Parcel in) {
            return new SystemPoints(in);
        }

        @Override
        public SystemPoints[] newArray(int size) {
            return new SystemPoints[size];
        }
    };

    public void setPositionYaw(double positionYaw) {
         this.positionYaw = positionYaw;
     }
     public double getPositionYaw() {
         return positionYaw;
     }

    public void setPositionX(double positionX) {
         this.positionX = positionX;
     }
     public double getPositionX() {
         return positionX;
     }

    public void setPositionY(double positionY) {
         this.positionY = positionY;
     }
     public double getPositionY() {
         return positionY;
     }

    public void setPointId(long pointId) {
         this.pointId = pointId;
     }
     public long getPointId() {
         return pointId;
     }

    public void setPointName(String pointName) {
         this.pointName = pointName;
     }
     public String getPointName() {
         return pointName;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(positionYaw);
        dest.writeDouble(positionX);
        dest.writeDouble(positionY);
        dest.writeLong(pointId);
        dest.writeString(pointName);
    }
}