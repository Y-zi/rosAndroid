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
public class MapList implements BaseColumns, Parcelable {

    private List<Floors> floors;
    private long defaultFloor;

    public MapList(){

    }
    protected MapList(Parcel in) {
        floors = in.createTypedArrayList(Floors.CREATOR);
        defaultFloor = in.readLong();
    }

    public static final Creator<MapList> CREATOR = new Creator<MapList>() {
        @Override
        public MapList createFromParcel(Parcel in) {
            return new MapList(in);
        }

        @Override
        public MapList[] newArray(int size) {
            return new MapList[size];
        }
    };

    public void setFloors(List<Floors> floors) {
         this.floors = floors;
     }
     public List<Floors> getFloors() {
         return floors;
     }

    public void setDefaultFloor(long defaultFloor) {
         this.defaultFloor = defaultFloor;
     }
     public long getDefaultFloor() {
         return defaultFloor;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(floors);
        dest.writeLong(defaultFloor);
    }
}