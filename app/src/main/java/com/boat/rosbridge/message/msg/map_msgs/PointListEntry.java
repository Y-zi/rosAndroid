
package com.boat.rosbridge.message.msg.map_msgs;


import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;
@MessageType(string = "map_msgs/PointListEntry")
public class PointListEntry extends Message {

    public String point_name;

    public String point_id;

    public String session_id;

    public float x;

    public float y;

    public float z;

    public String getPointName() {
        return point_name;
    }

    public void setPointName(String point_name) {
        this.point_name = point_name;
    }

    public String getPointId() {
        return point_id;
    }

    public void setPointId(String point_id) {
        this.point_id = point_id;
    }

    public String getSessionId() {
        return session_id;
    }

    public void setSessionId(String session_id) {
        this.session_id = session_id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
