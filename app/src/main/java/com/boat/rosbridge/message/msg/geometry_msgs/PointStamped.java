package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;
import com.jilk.ros.message.Header;

@MessageType(string = "geometry_msgs/PointStamped")
public class PointStamped extends Message {

    public Header header;
    public Point point;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}