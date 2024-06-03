package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;
@MessageType(string = "geometry_msgs/Pose")
public class Pose extends Message {

    public Point position;
    public Quaternion orientation;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Quaternion getOrientation() {
        return orientation;
    }

    public void setOrientation(Quaternion orientation) {
        this.orientation = orientation;
    }
}