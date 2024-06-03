package com.boat.rosbridge.message.msg.geometry_msgs;

import com.jilk.ros.message.Header;
import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;


@MessageType(string = "geometry_msgs/TransformStamped")
public class TransformStamped extends Message {

    public Header header;

    public String child_frame_id;

    public Transform transform;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getChildFrameId() {
        return child_frame_id;
    }

    public void setChildFrameId(String child_frame_id) {
        this.child_frame_id = child_frame_id;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }
}