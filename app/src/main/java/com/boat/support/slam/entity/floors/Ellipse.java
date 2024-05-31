/**
  * Copyright 2022 json.cn 
  */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2022-04-28 15:55:37
 *
 * @author json.cn (i@json.cn)
 *
 */
public class Ellipse implements Parcelable {

    private String p;
    private F2 f2;
    private F1 f1;

    protected Ellipse(Parcel in) {
        p = in.readString();
        f2 = in.readParcelable(F2.class.getClassLoader());
        f1 = in.readParcelable(F1.class.getClassLoader());
    }

    public static final Creator<Ellipse> CREATOR = new Creator<Ellipse>() {
        @Override
        public Ellipse createFromParcel(Parcel in) {
            return new Ellipse(in);
        }

        @Override
        public Ellipse[] newArray(int size) {
            return new Ellipse[size];
        }
    };

    public void setP(String p) {
         this.p = p;
     }
     public String getP() {
         return p;
     }

    public void setF2(F2 f2) {
         this.f2 = f2;
     }
     public F2 getF2() {
         return f2;
     }

    public void setF1(F1 f1) {
         this.f1 = f1;
     }
     public F1 getF1() {
         return f1;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(p);
        dest.writeParcelable(f2, flags);
        dest.writeParcelable(f1, flags);
    }
}