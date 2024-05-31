/**
 * Copyright 2022 json.cn
 */
package com.boat.support.slam.entity.floors;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Auto-generated: 2022-04-25 16:48:29
 *
 * @author json.cn (i@json.cn)
 *
 */
public class Maps implements Parcelable {

    private String mapMd5;
    private String mapFile;
    private long initialId;
    private long chargeId;
    private long workPointId;
    private long mapId;
    private List<ShapeAreas> shapeAreas;
    private List<CleanArea> cleanAreas;
    private String mapName;
    private List<Points> points;
    private List<CustomPath> customPathList;
    private List<SystemPoints> systemPoints;
    private List<GlobalPlans> globalPlans;
    private NglobalPlans nglobalPlans;


    protected Maps(Parcel in) {
        mapMd5 = in.readString();
        mapFile = in.readString();
        initialId = in.readLong();
        chargeId = in.readLong();
        workPointId = in.readLong();
        mapId = in.readLong();
        shapeAreas = in.createTypedArrayList(ShapeAreas.CREATOR);
        cleanAreas = in.createTypedArrayList(CleanArea.CREATOR);
        mapName = in.readString();
        points = in.createTypedArrayList(Points.CREATOR);
        customPathList = in.createTypedArrayList(CustomPath.CREATOR);
        systemPoints = in.createTypedArrayList(SystemPoints.CREATOR);
        globalPlans = in.createTypedArrayList(GlobalPlans.CREATOR);
        nglobalPlans = in.readParcelable(NglobalPlans.class.getClassLoader());
    }

    public static final Creator<Maps> CREATOR = new Creator<Maps>() {
        @Override
        public Maps createFromParcel(Parcel in) {
            return new Maps(in);
        }

        @Override
        public Maps[] newArray(int size) {
            return new Maps[size];
        }
    };

    public String getMapMd5() {
        return mapMd5;
    }

    public void setMapMd5(String mapMd5) {
        this.mapMd5 = mapMd5;
    }

    public void setMapFile(String mapFile) {
        this.mapFile = mapFile;
    }
    public String getMapFile() {
        return mapFile;
    }

    public void setInitialId(long initialId) {
        this.initialId = initialId;
    }
    public long getInitialId() {
        return initialId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }
    public long getMapId() {
        return mapId;
    }

    public void setShapeAreas(List<ShapeAreas> shapeAreas) {
        this.shapeAreas = shapeAreas;
    }
    public List<ShapeAreas> getShapeAreas() {
        return shapeAreas;
    }

    public List<CleanArea> getCleanAreas() {
        return cleanAreas;
    }

    public void setCleanAreas(List<CleanArea> cleanAreas) {
        this.cleanAreas = cleanAreas;
    }

    public void setChargeId(long chargeId) {
        this.chargeId = chargeId;
    }
    public long getChargeId() {
        return chargeId;
    }

    public long getWorkPointId() {
        return workPointId;
    }

    public void setWorkPointId(long workPointId) {
        this.workPointId = workPointId;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
    public String getMapName() {
        return mapName;
    }


    public void setPoints(List<Points> points) {
        this.points = points;
    }
    public List<Points> getPoints() {
        return points;
    }

    public List<CustomPath> getCustomPathList() {
        return customPathList;
    }

    public void setCustomPathList(List<CustomPath> customPathList) {
        this.customPathList = customPathList;
    }

    public List<SystemPoints> getSystemPoints() {
        return systemPoints;
    }

    public void setSystemPoints(List<SystemPoints> systemPoints) {
        this.systemPoints = systemPoints;
    }

    public List<GlobalPlans> getGlobalPlans() {
        return globalPlans;
    }

    public void setGlobalPlans(List<GlobalPlans> globalPlans) {
        this.globalPlans = globalPlans;
    }

    public NglobalPlans getNglobalPlans() {
        return nglobalPlans;
    }

    public void setNglobalPlans(NglobalPlans nglobalPlans) {
        this.nglobalPlans = nglobalPlans;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mapMd5);
        parcel.writeString(mapFile);
        parcel.writeLong(initialId);
        parcel.writeLong(chargeId);
        parcel.writeLong(workPointId);
        parcel.writeLong(mapId);
        parcel.writeTypedList(shapeAreas);
        parcel.writeTypedList(cleanAreas);
        parcel.writeString(mapName);
        parcel.writeTypedList(points);
        parcel.writeTypedList(customPathList);
        parcel.writeTypedList(systemPoints);
        parcel.writeTypedList(globalPlans);
        parcel.writeParcelable(nglobalPlans, i);
    }
}