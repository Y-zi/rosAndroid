//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.boat.rosbridge.message.srv.map_msgs;


import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "map_msgs/SaveMapRequest")
public class SaveMapRequest extends Message {

    public int type;// # 0 保存当前楼层下 1 保存其他指定楼层下 2 保存新楼层
    public long floor_id;
    public String floor_name;
    public String map_name;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getFloorId() {
        return floor_id;
    }

    public void setFloorId(long floor_id) {
        this.floor_id = floor_id;
    }

    public String getFloorName() {
        return floor_name;
    }

    public void setFloorName(String floor_name) {
        this.floor_name = floor_name;
    }

    public String getMapName() {
        return map_name;
    }

    public void setMapName(String map_name) {
        this.map_name = map_name;
    }
}
