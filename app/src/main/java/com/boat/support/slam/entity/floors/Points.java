/**
  * Copyright 2022 json.cn 
  */
package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Auto-generated: 2022-04-25 16:48:29
 *
 * @author json.cn (i@json.cn)
 *
 */
public class Points implements Parcelable {

    private double positionYaw;
    private double positionX;
    private double positionY;
    private String pointName;
    private long pointId;
    private long resId;
    private String pointWords;
    private String naviPointWords;
    private long navipointResid;
    private int isCircle;
    private String alias;
    private int isGo;
    private int waitTime;
    private int naviwordsOrRes = 0; //导航中资源或文字播报（1文字 2资源 0无）
    private int wordOrRes = 0;      //到点资源或文字播报（1文字 2资源 0无）
    private int isWaitOpen;
    private int isAliasOpen;

    public Points(){}


    protected Points(Parcel in) {
        positionYaw = in.readDouble();
        positionX = in.readDouble();
        positionY = in.readDouble();
        pointName = in.readString();
        pointId = in.readLong();
        resId = in.readLong();
        pointWords = in.readString();
        naviPointWords = in.readString();
        navipointResid = in.readLong();
        isCircle = in.readInt();
        alias = in.readString();
        isGo = in.readInt();
        waitTime = in.readInt();
        naviwordsOrRes = in.readInt();
        wordOrRes = in.readInt();
        isWaitOpen = in.readInt();
        isAliasOpen = in.readInt();
    }

    public static final Creator<Points> CREATOR = new Creator<Points>() {
        @Override
        public Points createFromParcel(Parcel in) {
            return new Points(in);
        }

        @Override
        public Points[] newArray(int size) {
            return new Points[size];
        }
    };

    public void setPositionYaw(double positionYaw) {
         this.positionYaw = positionYaw;
     }
     public double getPositionYaw() {
         return positionYaw;
     }

    public void setPositionX(double positionX) {
         this.positionX = positionX;
     }
     public double getPositionX() {
         return positionX;
     }

    public void setPositionY(double positionY) {
         this.positionY = positionY;
     }
     public double getPositionY() {
         return positionY;
     }

    public void setPointName(String pointName) {
         this.pointName = pointName;
     }
     public String getPointName() {
         return pointName;
     }

    public void setPointId(long pointId) {
         this.pointId = pointId;
     }
     public long getPointId() {
         return pointId;
     }

    public long getResId() {
        return resId;
    }

    public void setResId(long resId) {
        this.resId = resId;
    }

    public String getPointWords() {
        return pointWords;
    }

    public void setPointWords(String pointWords) {
        this.pointWords = pointWords;
    }

    public String getNaviPointWords() {
        return naviPointWords;
    }

    public void setNaviPointWords(String naviPointWords) {
        this.naviPointWords = naviPointWords;
    }

    public long getNavipointResid() {
        return navipointResid;
    }

    public void setNavipointResid(long navipointResid) {
        this.navipointResid = navipointResid;
    }

    public int getIsCircle() {
        return isCircle;
    }

    public void setIsCircle(int isCircle) {
        this.isCircle = isCircle;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getIsGo() {
        return isGo;
    }

    public void setIsGo(int isGo) {
        this.isGo = isGo;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getNaviwordsOrRes() {
        return naviwordsOrRes;
    }

    public void setNaviwordsOrRes(int naviwordsOrRes) {
        this.naviwordsOrRes = naviwordsOrRes;
    }

    public int getWordOrRes() {
        return wordOrRes;
    }

    public void setWordOrRes(int wordOrRes) {
        this.wordOrRes = wordOrRes;
    }

    public int getIsWaitOpen() {
        return isWaitOpen;
    }

    public void setIsWaitOpen(int isWaitOpen) {
        this.isWaitOpen = isWaitOpen;
    }

    public int getIsAliasOpen() {
        return isAliasOpen;
    }

    public void setIsAliasOpen(int isAliasOpen) {
        this.isAliasOpen = isAliasOpen;
    }


    @Override
    public String toString() {
        return "Points{" +
                "positionYaw=" + positionYaw +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", pointName='" + pointName + '\'' +
                ", pointId=" + pointId +
                ", resId=" + resId +
                ", pointWords='" + pointWords + '\'' +
                ", naviPointWords='" + naviPointWords + '\'' +
                ", navipointResid=" + navipointResid +
                ", isCircle=" + isCircle +
                ", alias='" + alias + '\'' +
                ", isGo=" + isGo +
                ", waitTime=" + waitTime +
                ", naviwordsOrRes=" + naviwordsOrRes +
                ", wordOrRes=" + wordOrRes +
                ", isWaitOpen=" + isWaitOpen +
                ", isAliasOpen=" + isAliasOpen +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(positionYaw);
        dest.writeDouble(positionX);
        dest.writeDouble(positionY);
        dest.writeString(pointName);
        dest.writeLong(pointId);
        dest.writeLong(resId);
        dest.writeString(pointWords);
        dest.writeString(naviPointWords);
        dest.writeLong(navipointResid);
        dest.writeInt(isCircle);
        dest.writeString(alias);
        dest.writeInt(isGo);
        dest.writeInt(waitTime);
        dest.writeInt(naviwordsOrRes);
        dest.writeInt(wordOrRes);
        dest.writeInt(isWaitOpen);
        dest.writeInt(isAliasOpen);
    }
}