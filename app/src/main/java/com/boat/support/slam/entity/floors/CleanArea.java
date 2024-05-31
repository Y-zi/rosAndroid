package com.boat.support.slam.entity.floors;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class CleanArea implements Parcelable {

    private long cleanAreaId;
    private int sequenceId;
    private List<Lines> lines;
    private boolean closed;
    private Circle circle;
    private String type;
    private String cleanAreaName;
    private Ellipse ellipse;

    public CleanArea(String type) {
        this.type = type;
    }

    public CleanArea(Parcel in) {
        cleanAreaId = in.readLong();
        sequenceId = in.readInt();
        lines = in.createTypedArrayList(Lines.CREATOR);
        closed = in.readByte() != 0;
        circle = in.readParcelable(Circle.class.getClassLoader());
        type = in.readString();
        cleanAreaName = in.readString();
        ellipse = in.readParcelable(Ellipse.class.getClassLoader());
    }

    public static final Creator<CleanArea> CREATOR = new Creator<CleanArea>() {
        @Override
        public CleanArea createFromParcel(Parcel in) {
            return new CleanArea(in);
        }

        @Override
        public CleanArea[] newArray(int size) {
            return new CleanArea[size];
        }
    };

    public void setCleanAreaId(long shapeId) {
        this.cleanAreaId = shapeId;
    }

    public long getCleanAreaId() {
        return cleanAreaId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public void setLines(List<Lines> lines) {
        this.lines = lines;
    }

    public List<Lines> getLines() {
        return lines;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean getClosed() {
        return closed;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCleanAreaName() {
        return cleanAreaName;
    }

    public void setCleanAreaName(String cleanAreaName) {
        this.cleanAreaName = cleanAreaName;
    }


    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(cleanAreaId);
        dest.writeInt(sequenceId);
        dest.writeTypedList(lines);
        dest.writeByte((byte) (closed ? 1 : 0));
        dest.writeParcelable(circle, flags);
        dest.writeString(type);
        dest.writeString(cleanAreaName);
        dest.writeParcelable(ellipse, flags);
    }

    @Override
    public String toString() {
        return "CleanArea{" +
                "cleanAreaId=" + cleanAreaId +
                ", sequenceId=" + sequenceId +
                ", lines=" + lines +
                ", closed=" + closed +
                ", circle=" + circle +
                ", type='" + type + '\'' +
                ", cleanAreaName='" + cleanAreaName + '\'' +
                ", ellipse=" + ellipse +
                '}';
    }
}

