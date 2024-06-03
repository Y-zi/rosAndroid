package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "geometry_msgs/PoseWithCovariance")
public class PoseWithCovariance extends Message {

    public Pose pose= new Pose();

    public double[] covariance;

    public Pose getPose() {
        return pose;
    }

    public void setPose(Pose pose) {
        this.pose = pose;
    }

    public double[] getCovariance() {
        return covariance;
    }

    public void setCovariance(double[] covariance) {
        this.covariance = covariance;
    }
}