//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.boat.rosbridge.message.srv.map_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "map_msgs/PointSetResponse")
public class PointSetResponse extends Message {

    public long result;

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }
}
