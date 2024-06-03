package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;
import com.jilk.ros.message.Header;

@MessageType(string = "geometry_msgs/PoseWithCovarianceStamped")
public class PoseWithCovarianceStamped extends Message {

    public Header header;


    public PoseWithCovariance pose;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public PoseWithCovariance getPose() {
        return pose;
    }

    public void setPose(PoseWithCovariance pose) {
        this.pose = pose;
    }
}