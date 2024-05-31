package com.boat.rosbridge.message.msg.map_msgs;


import com.jilk.ros.message.Message;
import com.jilk.ros.message.MessageType;
@MessageType(string = "map_msgs/SetTargetGoal")
public class SetTargetGoal extends Message {


    public String goal_name;

    public String getGoalName() {
        return goal_name;
    }

    public void setGoalName(String goal_name) {
        this.goal_name = goal_name;
    }
}
