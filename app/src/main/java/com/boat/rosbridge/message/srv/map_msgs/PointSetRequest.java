package com.boat.rosbridge.message.srv.map_msgs;


import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "map_msgs/PointSetRequest")
public class PointSetRequest extends Message {


    public String point_name;
    public long point_mode;

    public String getPointName() {
        return point_name;
    }

    public void setPointName(String point_name) {
        this.point_name = point_name;
    }

    public long getPointMode() {
        return point_mode;
    }

    public void setPointMode(long point_mode) {
        this.point_mode = point_mode;
    }
}