package com.boat.rosbridge.message.msg.map_msgs;


import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "map_msgs/TargetGoal")
public class TargetGoal extends Message {

    public long floor_id;
    public long map_id;
    public long point_id;


    public long getFloorId() {
        return floor_id;
    }

    public void setFloorId(long floor_id) {
        this.floor_id = floor_id;
    }

    public long getMapId() {
        return map_id;
    }

    public void setMapId(long map_id) {
        this.map_id = map_id;
    }

    public long getPointId() {
        return point_id;
    }

    public void setPointId(long point_id) {
        this.point_id = point_id;
    }
}
