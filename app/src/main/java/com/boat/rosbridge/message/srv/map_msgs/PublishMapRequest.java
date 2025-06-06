//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.boat.rosbridge.message.srv.map_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "map_msgs/PublishMapRequest")
public class PublishMapRequest extends Message {
    public int type;// 0 切换楼层和地图 并且更新加载 1 设置指定楼层中的默认地图(只能用于修改其他楼层，当前楼层只能用 0)
    public long floor_id;
    public long map_id;

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

    public long getMapId() {
        return map_id;
    }

    public void setMapId(long map_id) {
        this.map_id = map_id;
    }
}
