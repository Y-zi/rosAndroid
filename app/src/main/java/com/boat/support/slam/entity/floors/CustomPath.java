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
public class CustomPath implements Parcelable {

    private long pathId;
    private List<Lines> lines;
    private boolean closed;
    private int state;
    private String name;

    protected CustomPath(Parcel in) {
        pathId = in.readLong();
        state = in.readInt();
        lines = in.createTypedArrayList(Lines.CREATOR);
        closed = in.readByte() != 0;
        name = in.readString();
    }

    public static final Creator<CustomPath> CREATOR = new Creator<CustomPath>() {
        @Override
        public CustomPath createFromParcel(Parcel in) {
            return new CustomPath(in);
        }

        @Override
        public CustomPath[] newArray(int size) {
            return new CustomPath[size];
        }
    };

    public long getPathId() {
        return pathId;
    }

    public void setPathId(long pathId) {
        this.pathId = pathId;
    }

    public List<Lines> getLines() {
        return lines;
    }

    public void setLines(List<Lines> lines) {
        this.lines = lines;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(pathId);
        dest.writeInt(state);
        dest.writeTypedList(lines);
        dest.writeByte((byte) (closed ? 1 : 0));
        dest.writeString(name);
    }
}