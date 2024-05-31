package com.boat.rosbridge.message.msg.std_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

@MessageType(string = "std_msgs/Int64MultiArray")
public class Int64MultiArray extends Message {

    public MultiArrayLayout layout;
    public long[] data;

    public MultiArrayLayout getLayout() {
        return layout;
    }

    public void setLayout(MultiArrayLayout layout) {
        this.layout = layout;
    }

    public long[] getData() {
        return data;
    }

    public void setData(long[] data) {
        this.data = data;
    }
}