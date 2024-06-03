package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "geometry_msgs/Twist")
public class Twist extends Message {

    public Vector3 linear;

    public Vector3 angular;

    public Vector3 getLinear() {
        return linear;
    }

    public void setLinear(Vector3 linear) {
        this.linear = linear;
    }

    public Vector3 getAngular() {
        return angular;
    }

    public void setAngular(Vector3 angular) {
        this.angular = angular;
    }
}