package com.boat.rosbridge.message.msg.std_msgs;

import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;

import java.util.Arrays;
import java.util.List;

@MessageType(string = "std_msgs/MultiArrayLayout")
public class MultiArrayLayout extends Message {

    public MultiArrayDimension[] dim;
    public int data_offset;

    public List<MultiArrayDimension> getDim() {
        return Arrays.asList(dim);
    }

    public void setDim(List<MultiArrayDimension> dim) {
        this.dim = dim.toArray(new MultiArrayDimension[0]);
    }

    public int getDataOffset() {
        return data_offset;
    }

    public void setDataOffset(int data_offset) {
        this.data_offset = data_offset;
    }
}
