package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

public class WifiEntry implements Parcelable {

    String wifi_name;
    String wifi_pass;

    protected WifiEntry(Parcel in) {
        wifi_name = in.readString();
        wifi_pass = in.readString();
    }

    public WifiEntry(){}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wifi_name);
        dest.writeString(wifi_pass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WifiEntry> CREATOR = new Creator<WifiEntry>() {
        @Override
        public WifiEntry createFromParcel(Parcel in) {
            return new WifiEntry(in);
        }

        @Override
        public WifiEntry[] newArray(int size) {
            return new WifiEntry[size];
        }
    };

    public String getWifi_name() {
        return wifi_name;
    }

    public void setWifi_name(String wifi_name) {
        this.wifi_name = wifi_name;
    }

    public String getWifi_pass() {
        return wifi_pass;
    }

    public void setWifi_pass(String wifi_pass) {
        this.wifi_pass = wifi_pass;
    }
}
