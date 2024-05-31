package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

public class NPoint implements Parcelable {

    private long nId ;
    private String nName ;
    private long x ;
    private long y ;

    protected NPoint(Parcel in) {
        nId = in.readLong();
        nName = in.readString();
        x = in.readLong();
        y = in.readLong();
    }

    public static final Creator<NPoint> CREATOR = new Creator<NPoint>() {
        @Override
        public NPoint createFromParcel(Parcel in) {
            return new NPoint(in);
        }

        @Override
        public NPoint[] newArray(int size) {
            return new NPoint[size];
        }
    };

    public long getnId() {
        return nId;
    }

    public void setnId(long nId) {
        this.nId = nId;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(nId);
        parcel.writeString(nName);
        parcel.writeLong(x);
        parcel.writeLong(y);
    }
}
