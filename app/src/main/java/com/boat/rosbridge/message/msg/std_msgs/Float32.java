package com.boat.rosbridge.message.msg.std_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "std_msgs/Float32")
public class Float32 extends Message {

    public float data;

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }
}