package com.boat.support.slam.entity.floors;

import android.os.Parcel;
import android.os.Parcelable;

public class CleanCallBack implements Parcelable{

    public int pressureLevel;//#清洁压力
    public int strengthLevel;//#清洁强度
    public int speedLevel;//#清洁速度
    public int waterpumpSpeed;//#水量反馈
    public int blowerSpeed;//#吸力反馈
    public int rbLiftStatus;//#滚扫模块位置
    public int rdLiftStatus;//#滚拖模块位置
    public int liftWipeWaterStatus;//     #刮水模块位置
    public int dustBoxStatus;//  #尘箱在位
    public int waterTankStatus;//  #水箱在位
    public int brushPlateStatus;//  #边刷在位
    public int rollerBrushStatus;// #滚扫在位
    public int rollerDragStatus;//  #滚拖在位
    public int waterLevelStatus;//  #清水箱水量
    public int sewageLevelStatus;// #污水箱水量
    public int waterPumpStatus;//  #水流量检测
    public int isCarpetStatus;//  #地毯检测
    public int teeValveStatus;//  #三通球阀状态
    public int leftDoorStatus;//  #左侧底部尘盒盖板开关状态
    public int rightDoorStatus;//  #右侧底部滚刷盖板开关状态
    public int coverDoorStatus;//  #顶盖开关状态
    public int solenoidStatus;//  #电磁阀状态
    public int brushPlateSpeed;//  #边刷速度反馈

    protected CleanCallBack(Parcel in) {
        pressureLevel = in.readInt();
        strengthLevel = in.readInt();
        speedLevel = in.readInt();
        waterpumpSpeed = in.readInt();
        blowerSpeed = in.readInt();
        rbLiftStatus = in.readInt();
        rdLiftStatus = in.readInt();
        liftWipeWaterStatus = in.readInt();
        dustBoxStatus = in.readInt();
        waterTankStatus = in.readInt();
        brushPlateStatus = in.readInt();
        rollerBrushStatus = in.readInt();
        rollerDragStatus = in.readInt();
        waterLevelStatus = in.readInt();
        sewageLevelStatus = in.readInt();
        waterPumpStatus = in.readInt();
        isCarpetStatus = in.readInt();
        teeValveStatus = in.readInt();
        leftDoorStatus = in.readInt();
        rightDoorStatus = in.readInt();
        coverDoorStatus = in.readInt();
        solenoidStatus = in.readInt();
        brushPlateSpeed = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pressureLevel);
        dest.writeInt(strengthLevel);
        dest.writeInt(speedLevel);
        dest.writeInt(waterpumpSpeed);
        dest.writeInt(blowerSpeed);
        dest.writeInt(rbLiftStatus);
        dest.writeInt(rdLiftStatus);
        dest.writeInt(liftWipeWaterStatus);
        dest.writeInt(dustBoxStatus);
        dest.writeInt(waterTankStatus);
        dest.writeInt(brushPlateStatus);
        dest.writeInt(rollerBrushStatus);
        dest.writeInt(rollerDragStatus);
        dest.writeInt(waterLevelStatus);
        dest.writeInt(sewageLevelStatus);
        dest.writeInt(waterPumpStatus);
        dest.writeInt(isCarpetStatus);
        dest.writeInt(teeValveStatus);
        dest.writeInt(leftDoorStatus);
        dest.writeInt(rightDoorStatus);
        dest.writeInt(coverDoorStatus);
        dest.writeInt(solenoidStatus);
        dest.writeInt(brushPlateSpeed);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CleanCallBack> CREATOR = new Creator<CleanCallBack>() {
        @Override
        public CleanCallBack createFromParcel(Parcel in) {
            return new CleanCallBack(in);
        }

        @Override
        public CleanCallBack[] newArray(int size) {
            return new CleanCallBack[size];
        }
    };

    public int getPressureLevel() {
        return pressureLevel;
    }

    public void setPressureLevel(int pressureLevel) {
        this.pressureLevel = pressureLevel;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        this.speedLevel = speedLevel;
    }

    public int getWaterpumpSpeed() {
        return waterpumpSpeed;
    }

    public void setWaterpumpSpeed(int waterpumpSpeed) {
        this.waterpumpSpeed = waterpumpSpeed;
    }

    public int getBlowerSpeed() {
        return blowerSpeed;
    }

    public void setBlowerSpeed(int blowerSpeed) {
        this.blowerSpeed = blowerSpeed;
    }

    public int getRbLiftStatus() {
        return rbLiftStatus;
    }

    public void setRbLiftStatus(int rbLiftStatus) {
        this.rbLiftStatus = rbLiftStatus;
    }

    public int getRdLiftStatus() {
        return rdLiftStatus;
    }

    public void setRdLiftStatus(int rdLiftStatus) {
        this.rdLiftStatus = rdLiftStatus;
    }

    public int getLiftWipeWaterStatus() {
        return liftWipeWaterStatus;
    }

    public void setLiftWipeWaterStatus(int liftWipeWaterStatus) {
        this.liftWipeWaterStatus = liftWipeWaterStatus;
    }

    public int getDustBoxStatus() {
        return dustBoxStatus;
    }

    public void setDustBoxStatus(int dustBoxStatus) {
        this.dustBoxStatus = dustBoxStatus;
    }

    public int getWaterTankStatus() {
        return waterTankStatus;
    }

    public void setWaterTankStatus(int waterTankStatus) {
        this.waterTankStatus = waterTankStatus;
    }

    public int getBrushPlateStatus() {
        return brushPlateStatus;
    }

    public void setBrushPlateStatus(int brushPlateStatus) {
        this.brushPlateStatus = brushPlateStatus;
    }

    public int getRollerBrushStatus() {
        return rollerBrushStatus;
    }

    public void setRollerBrushStatus(int rollerBrushStatus) {
        this.rollerBrushStatus = rollerBrushStatus;
    }

    public int getRollerDragStatus() {
        return rollerDragStatus;
    }

    public void setRollerDragStatus(int rollerDragStatus) {
        this.rollerDragStatus = rollerDragStatus;
    }

    public int getWaterLevelStatus() {
        return waterLevelStatus;
    }

    public void setWaterLevelStatus(int waterLevelStatus) {
        this.waterLevelStatus = waterLevelStatus;
    }

    public int getSewageLevelStatus() {
        return sewageLevelStatus;
    }

    public void setSewageLevelStatus(int sewageLevelStatus) {
        this.sewageLevelStatus = sewageLevelStatus;
    }

    public int getWaterPumpStatus() {
        return waterPumpStatus;
    }

    public void setWaterPumpStatus(int waterPumpStatus) {
        this.waterPumpStatus = waterPumpStatus;
    }

    public int getIsCarpetStatus() {
        return isCarpetStatus;
    }

    public void setIsCarpetStatus(int isCarpetStatus) {
        this.isCarpetStatus = isCarpetStatus;
    }

    public int getTeeValveStatus() {
        return teeValveStatus;
    }

    public void setTeeValveStatus(int teeValveStatus) {
        this.teeValveStatus = teeValveStatus;
    }

    public int getLeftDoorStatus() {
        return leftDoorStatus;
    }

    public void setLeftDoorStatus(int leftDoorStatus) {
        this.leftDoorStatus = leftDoorStatus;
    }

    public int getRightDoorStatus() {
        return rightDoorStatus;
    }

    public void setRightDoorStatus(int rightDoorStatus) {
        this.rightDoorStatus = rightDoorStatus;
    }

    public int getCoverDoorStatus() {
        return coverDoorStatus;
    }

    public void setCoverDoorStatus(int coverDoorStatus) {
        this.coverDoorStatus = coverDoorStatus;
    }

    public int getSolenoidStatus() {
        return solenoidStatus;
    }

    public void setSolenoidStatus(int solenoidStatus) {
        this.solenoidStatus = solenoidStatus;
    }

    public int getBrushPlateSpeed() {
        return brushPlateSpeed;
    }

    public void setBrushPlateSpeed(int brushPlateSpeed) {
        this.brushPlateSpeed = brushPlateSpeed;
    }

    @Override
    public String toString() {
        return "CleanCallBack{" +
                "pressureLevel=" + pressureLevel +
                ", strengthLevel=" + strengthLevel +
                ", speedLevel=" + speedLevel +
                ", waterpumpSpeed=" + waterpumpSpeed +
                ", blowerSpeed=" + blowerSpeed +
                ", rbLiftStatus=" + rbLiftStatus +
                ", rdLiftStatus=" + rdLiftStatus +
                ", liftWipeWaterStatus=" + liftWipeWaterStatus +
                ", dustBoxStatus=" + dustBoxStatus +
                ", waterTankStatus=" + waterTankStatus +
                ", brushPlateStatus=" + brushPlateStatus +
                ", rollerBrushStatus=" + rollerBrushStatus +
                ", rollerDragStatus=" + rollerDragStatus +
                ", waterLevelStatus=" + waterLevelStatus +
                ", sewageLevelStatus=" + sewageLevelStatus +
                ", waterPumpStatus=" + waterPumpStatus +
                ", isCarpetStatus=" + isCarpetStatus +
                ", teeValveStatus=" + teeValveStatus +
                ", leftDoorStatus=" + leftDoorStatus +
                ", rightDoorStatus=" + rightDoorStatus +
                ", coverDoorStatus=" + coverDoorStatus +
                ", solenoidStatus=" + solenoidStatus +
                ", brushPlateSpeed=" + brushPlateSpeed +
                '}';
    }
}
