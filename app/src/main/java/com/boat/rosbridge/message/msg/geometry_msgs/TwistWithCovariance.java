package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "geometry_msgs/TwistWithCovariance")
public class TwistWithCovariance extends Message {


    public Twist twist;

    public double[] covariance;

    public Twist getTwist() {
        return twist;
    }

    public void setTwist(Twist twist) {
        this.twist = twist;
    }

    public double[] getCovariance() {
        return covariance;
    }

    public void setCovariance(double[] covariance) {
        this.covariance = covariance;
    }
}