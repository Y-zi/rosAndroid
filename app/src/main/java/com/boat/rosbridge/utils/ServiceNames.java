package com.boat.rosbridge.utils;


public class ServiceNames {

    // 移动测试
    public static String MoveCalibration = "move_calibration";

    // 导航测试
    public static String NaviTest = "set_navi_test";
    
    // 获取机器底盘信息
    public static String NaviInfo = "/navi_info";

//设置可乐号
    public static String CocoNum = "/set_coconum";

//设置wifi
    public static String Wifi = "/set_wifi";

//    设置运动模式(目前只用到充电)
    public static String Mode = "/set_mode";

//    设置移动状态
    public static String Navicmd = "/set_navi_cmd";

//    获取当前位置
    public static String CurrentPosint = "/get_position";

//    获取地图服务
    public static String GetMaps = "get_maps";

//    切换地图
    public static String ChangeMap = "/publish_map";

//    创建空白地图
    public static String ClearMap = "clear_map";

//    扩展地图
    public static String RebuildMap = "rebuild_map";

//    保存地图
    public static String SaveMap = "save_map";

//    擦除后的保存地图
    public static String saveEraseMap = "saveerase_map";

//    设置擦除的模式大小
    public static String EraserMode = "set_erasermode";

//    删除地图
    public static String DeleteMap = "delete_map";

//    删除所有地图
    public static String DeleteAllMap = "delete_allmap";

//    修改地图
    public static String RenameMapName = "rename_map";

//    用于获取建图时候的导航点
    public static String NaviPoints = "list_navi_points";

//    添加导航点
    public static String AddPoint = "point_set";

//    删除导航点
    public static String DeleteTestPoint = "delete_test_point";

//    重命名导航点
    public static String RenamePoint = "point_rename";

//    去导航点
    public static String Goal = "set_goal";

//    增加虚\删除拟墙
    public static String ShapeService = "set_shape";

//    增加\删除 手动路线
    public static String DiyPath = "set_globalplan";
    //修改手动路线
    public static String RenamePath = "rename_globalplan"; //rename_globalplan
    //手动路线 添加导航点绑定
    public static String AddPointsGlobalplan = "addpoints_globalplan";
    //手动路线删除导航点绑定
    public static String DeletePointsGlobalPlan = "deletepoints_globalplan";
    //停止手动路线测试
    public static String ExecutePath = "move_base/execute_path";

//    获取底盘日志列表
    public static String GetLogs = "get_log";

//    删除所有底盘log
    public static String DeleteAlllogs = "delete_allbags";

//    获取底盘bag列表
    public static String GetBags = "bag_list";

//    删除所有底盘bag包
    public static String DeleteAllBags = "delete_allbags";

//    机器ssh命令
    public static String Ssh = "robot_ssh";

//    重定位
    public static String Relocation = "set_relocation";

//    添加导航点plus
    public static String AddManuPoint = "pointmanu_set";

//    导入配置文件 通知导航下载地图
    public static String slamDownMap = "import_configs";
//    增加\删除清洁区域
    public static String CleanAreaService = "set_cleanArea";

    public static String robotSonar = "robot_sonarlist";
    public static String robotSonarSet = "robot_sonarset";
    public static String robotSpeed = "robot_speedlist";
    public static String robotSpeedSet = "robot_speedset";
    public static String robotSafe = "navigation_safesetlist";
    public static String robotSafeSet = "navigation_safeset";
    public static String robotConfig = "get_configs";
    public static String robotConfigSet = "set_configs";
    public static String robotTestDriver = "test_driver_service";


}
