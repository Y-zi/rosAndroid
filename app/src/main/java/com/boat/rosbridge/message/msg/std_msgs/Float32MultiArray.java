package com.boat.rosbridge.message.msg.std_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "std_msgs/Float32MultiArray")
public class Float32MultiArray extends Message {

    public MultiArrayLayout layout;
    public float[] data;

    public MultiArrayLayout getLayout() {
        return layout;
    }

    public void setLayout(MultiArrayLayout layout) {
        this.layout = layout;
    }

    public float[] getData() {
        return data;
    }

    public void setData(float[] data) {
        this.data = data;
    }
}