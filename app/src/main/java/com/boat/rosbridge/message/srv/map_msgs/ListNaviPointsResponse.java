package com.boat.rosbridge.message.srv.map_msgs;


import com.boat.rosbridge.message.msg.map_msgs.PointListEntry;
import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

import java.util.Arrays;
import java.util.List;

@MessageType(string = "map_msgs/ListNaviPointsResponse")
public class ListNaviPointsResponse extends Message {

    public PointListEntry[] list_navi_points;
    public PointListEntry[] list_system_points;

    public List<PointListEntry> getListNaviPoints() {
        return Arrays.asList(list_navi_points);
    }

    public void setListNaviPoints(PointListEntry[] list_navi_points) {
        this.list_navi_points = list_navi_points;
    }

    public List<PointListEntry> getListSystemPoints() {
        return Arrays.asList(list_system_points);
    }

    public void setListSystemPoints(PointListEntry[] list_system_points) {
        this.list_system_points = list_system_points;
    }
}