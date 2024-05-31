package com.boat.rosbridge.utils;

public class TopicNames {

    /**
     * 发布类
     * */

    public static String ErasePose= "erase_pose";
    public static String CMD_VEL= "cmd_vel";
    public static String CurrentposeLocationmiss= "/currentpose_locationmiss";

    //
    public static String CleanArea = "/start_cleanarea";

    public static String NpathAddorDel = "/npath_addorDel";

    /**
     * 接收类
     * */

    public static String LocationStatus = "/location_status";

    // 获取移动测试状态数据
    public static String MoveTestMsg = "/testodom";

    // 获取测试状态数据
    public static String TestMsg = "/navitest_result";

    // 心跳数据
    public static String HeartMsg = "heart_beat";

    //底盘初始化状态
    public static String InitMsg = "androidmsg_initstatus";

    //急停状态androidmsg_emergencystatus
    public static String EMEMsg = "androidmsg_emergencystatus";

    //充电状态
    public static String ChageMsg = "androidmsg_chargestatus";

    //电量状态
    public static String Battry = "power_report";

    //定位状态
    public static String LocationMsg = "androidmsg_locationstatus";

    //地图需要更新
    public static String WallUpdateMsg = "wall_update";

    //导航状态
    public static String NavigationMsg = "androidmsg_navigationstatus";

    //获取导航点去向的指令回调
    public static String NaviToPointName = "/set_targetgoal";

    //导航停止消息
    public static String NaviStop= "/navi_stop";

    //手动路线测试
    public static String GlobalPlansTest= "/globalplans_update";

    //开始自动充电消息
    public static String GoCharge= "autocharge";

    //虚拟墙状态   62 63 虚拟墙加载
    public static String VirtualMsg = "androidmsg_virtualmapstatus";

    //地图状态      0导航状态 1建图状态 2扩展地图状态---用于app上
    public static String MapStatus = "map_status";


    //地图加载状态      60	机器人地图和导航点加载成功。 61	机器人地图加载失败。
    public static String MapStatusMsg = "androidmsg_mapstatus";

    //地图创建状态 64建图状态 65加载地图状态       //未实现 69	机器人地图修改成功。  70机器人地图修改失败！
    public static String MapBuildStatusMsg = "androidmsg_mapbuildstatus";

    //机器人出桩    49 50
    public static String OutChargeMsg = "androidmsg_outofchargepoint";


    //激光状态        13 14               // 111 112
    public static String LidarMsg = "androidmsg_lidarstatus";


    //stm32主板状态    17 18
    public static String Stm32Msg = "androidmsg_stm32status";


    //里程计状态  19 20 里程计
    public static String OdomMsg = "androidmsg_odomstatus";


    //获取底盘网络连接状态
    public static String NaviNetworkMsg = "androidmsg_navinetworkstatus";


    //imu状态     15 16           //115 116
    public static String ImuMsg = "androidmsg_imustatus";


    //超声波板状态  105 106
    public static String SonarMsg = "androidmsg_sonarstatus";


    //轮子状态(无指令异常转动)1    101 102
    public static String Motor1Msg = "androidmsg_motor1status";


    //轮子状态(有指令不转动)2 119 120
    public static String Motor2Msg = "androidmsg_motor2status";


    //左轮是否故障  107 108
    public static String LeftMotorMsg = "androidmsg_leftmotorstatus";


    //右轮是否故障    109 110
    public static String RightMotorMsg = "androidmsg_rightmotorstatus";


    //摄像头状态 117	118
    public static String CameraMsg = "androidmsg_camerastatus";


    //电池状态      123 124
    public static String BatteryMsg = "androidmsg_batterystatus";

    // 导航下载地图文件状态     123 124
    public static String DownMapStateMsg = "androidmsg_importfilesstatus";
}
