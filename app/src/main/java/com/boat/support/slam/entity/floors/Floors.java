/**
  * Copyright 2022 json.cn 
  */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

import java.util.List;

/**
 * Auto-generated: 2022-04-25 16:48:29
 *
 * @author json.cn (i@json.cn)
 *
 */
public class Floors implements BaseColumns, Parcelable {

    private String floorName;
    private long floorId;
    private long defaultmap;
    private List<Maps> maps;

    public Floors(){

    }

    @Override
    public String toString() {
        return "Floors{" +
                "floorName='" + floorName + '\'' +
                ", floorId=" + floorId +
                ", defaultmap=" + defaultmap +
                ", maps=" + maps +
                '}';
    }

    protected Floors(Parcel in) {
        floorName = in.readString();
        floorId = in.readLong();
        defaultmap = in.readLong();
        maps = in.createTypedArrayList(Maps.CREATOR);
    }

    public static final Creator<Floors> CREATOR = new Creator<Floors>() {
        @Override
        public Floors createFromParcel(Parcel in) {
            return new Floors(in);
        }

        @Override
        public Floors[] newArray(int size) {
            return new Floors[size];
        }
    };

    public void setFloorName(String floorName) {
         this.floorName = floorName;
     }
     public String getFloorName() {
         return floorName;
     }

    public void setFloorId(long floorId) {
         this.floorId = floorId;
     }
     public long getFloorId() {
         return floorId;
     }


    public void setDefaultmap(long defaultmap) {
        this.defaultmap = defaultmap;
    }
    public long getDefaultmap() {
        return defaultmap;
    }

    public void setMaps(List<Maps> maps) {
        this.maps = maps;
    }
    public List<Maps> getMaps() {
        return maps;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(floorName);
        dest.writeLong(floorId);
        dest.writeLong(defaultmap);
        dest.writeTypedList(maps);
    }
}