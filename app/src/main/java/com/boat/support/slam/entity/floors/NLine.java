package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

public class NLine implements Parcelable {

    private long id ;
    private long startNid ;
    private long endNid ;
    private int type;
    private int direction;
    private float weight;
    private float speed;


    public NLine(){}
    protected NLine(Parcel in) {
        id = in.readLong();
        startNid = in.readLong();
        endNid = in.readLong();
        type = in.readInt();
        direction = in.readInt();
        weight = in.readFloat();
        speed = in.readFloat();
    }

    public static final Creator<NLine> CREATOR = new Creator<NLine>() {
        @Override
        public NLine createFromParcel(Parcel in) {
            return new NLine(in);
        }

        @Override
        public NLine[] newArray(int size) {
            return new NLine[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartNid() {
        return startNid;
    }

    public void setStartNid(long startNid) {
        this.startNid = startNid;
    }

    public long getEndNid() {
        return endNid;
    }

    public void setEndNid(long endNid) {
        this.endNid = endNid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeLong(startNid);
        parcel.writeLong(endNid);
        parcel.writeInt(type);
        parcel.writeInt(direction);
        parcel.writeFloat(weight);
        parcel.writeFloat(speed);
    }
}
