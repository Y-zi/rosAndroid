/**
 * Copyright 2022 json.cn
 */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Auto-generated: 2022-04-28 15:55:37
 *
 * @author json.cn (i@json.cn)
 *
 */
public class ShapeAreas implements Parcelable {

    private long shapeId;
    private int orderNum;
    private List<Lines> lines;
    private boolean closed;
    private Circle circle;
    private String type;
    private Ellipse ellipse;


    protected ShapeAreas(Parcel in) {
        shapeId = in.readLong();
        orderNum = in.readInt();
        lines = in.createTypedArrayList(Lines.CREATOR);
        closed = in.readByte() != 0;
        circle = in.readParcelable(Circle.class.getClassLoader());
        type = in.readString();
        ellipse = in.readParcelable(Ellipse.class.getClassLoader());
    }

    public static final Creator<ShapeAreas> CREATOR = new Creator<ShapeAreas>() {
        @Override
        public ShapeAreas createFromParcel(Parcel in) {
            return new ShapeAreas(in);
        }

        @Override
        public ShapeAreas[] newArray(int size) {
            return new ShapeAreas[size];
        }
    };

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
    }
    public long getShapeId() {
        return shapeId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
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
        dest.writeLong(shapeId);
        dest.writeInt(orderNum);
        dest.writeTypedList(lines);
        dest.writeByte((byte) (closed ? 1 : 0));
        dest.writeParcelable(circle, flags);
        dest.writeString(type);
        dest.writeParcelable(ellipse, flags);
    }
}