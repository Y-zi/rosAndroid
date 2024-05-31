package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class CleanAreaEnty implements Parcelable {
    String type;
    String name;
    long cleanAreaId;
    List<Lines> points;
    float radius;
    boolean closed;

    protected CleanAreaEnty(Parcel in) {
        type = in.readString();
        name = in.readString();
        cleanAreaId = in.readLong();
        points = in.createTypedArrayList(Lines.CREATOR);
        radius = in.readFloat();
        closed = in.readByte() != 0;
    }

    public static final Creator<CleanAreaEnty> CREATOR = new Creator<CleanAreaEnty>() {
        @Override
        public CleanAreaEnty createFromParcel(Parcel in) {
            return new CleanAreaEnty(in);
        }

        @Override
        public CleanAreaEnty[] newArray(int size) {
            return new CleanAreaEnty[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCleanAreaId() {
        return cleanAreaId;
    }

    public void setCleanAreaId(long cleanAreaId) {
        this.cleanAreaId = cleanAreaId;
    }

    public List<Lines> getPoints() {
        return points;
    }

    public void setPoints(List<Lines> points) {
        this.points = points;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(name);
        dest.writeLong(cleanAreaId);
        dest.writeTypedList(points);
        dest.writeFloat(radius);
        dest.writeByte((byte) (closed ? 1 : 0));
    }
}
