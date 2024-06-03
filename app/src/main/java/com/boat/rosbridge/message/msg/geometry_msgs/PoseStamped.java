package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;
import com.jilk.ros.message.Header;

@MessageType(string = "geometry_msgs/PoseStamped")
public class PoseStamped extends Message {

    public Header header;
    public Pose pose;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Pose getPose() {
        return pose;
    }

    public void setPose(Pose pose) {
        this.pose = pose;
    }
}