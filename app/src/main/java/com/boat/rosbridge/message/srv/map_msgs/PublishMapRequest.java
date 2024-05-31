//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.boat.rosbridge.message.srv.map_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "map_msgs/PublishMapRequest")
public class PublishMapRequest extends Message {
    public String map_id;

    public String getMapId() {
        return map_id;
    }

    public void setMapId(String map_id) {
        this.map_id = map_id;
    }
}
