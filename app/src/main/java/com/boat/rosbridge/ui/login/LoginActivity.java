/*
 * Create by :Y-zi
 * QQ: 992063180
 * Github: https://github.com/Y-zi
 * */
package com.boat.rosbridge.ui.login;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boat.rosbridge.adapter.MapListAdapter;
import com.boat.rosbridge.application.MyApplication;
import com.boat.rosbridge.message.msg.map_msgs.PointListEntry;
import com.boat.rosbridge.message.msg.map_msgs.SetTargetGoal;
import com.boat.rosbridge.message.msg.map_msgs.TargetGoal;
import com.boat.rosbridge.message.msg.std_msgs.Int16;
import com.boat.rosbridge.message.msg.std_msgs.Int32;
import com.boat.rosbridge.R;
import com.boat.rosbridge.adapter.PointListAdapater;
import com.boat.rosbridge.message.srv.map_msgs.DeleteTestPointRequest;
import com.boat.rosbridge.message.srv.map_msgs.DeleteTestPointResponse;
import com.boat.rosbridge.message.srv.map_msgs.PointSetRequest;
import com.boat.rosbridge.message.srv.map_msgs.PointSetResponse;
import com.boat.rosbridge.message.srv.map_msgs.PublishMapRequest;
import com.boat.rosbridge.message.srv.map_msgs.SaveMapRequest;
import com.boat.rosbridge.message.srv.map_msgs.SaveMapResponse;
import com.boat.rosbridge.message.srv.std_srvs.Empty;
import com.boat.rosbridge.message.srv.std_srvs.TriggerResponse;
import com.boat.rosbridge.message.srv.map_msgs.ListNaviPointsResponse;
import com.boat.rosbridge.utils.ServiceNames;
import com.boat.rosbridge.utils.TopicNames;
import com.boat.support.slam.entity.floors.Floors;
import com.boat.support.slam.entity.floors.MapList;
import com.boat.support.slam.entity.floors.Maps;
import com.boat.support.slam.entity.floors.Points;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jilk.ros.MessageHandler;
import com.jilk.ros.ROSClient;
import com.jilk.ros.Service;
import com.jilk.ros.Topic;
import com.jilk.ros.rosbridge.ROSBridgeClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    String[] permissions = new String[]{
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private LinearLayout root_ll;
    private Button connectButton;
    //    private LinearLayout connectionLayout;
    private static final int LOCATION_PERM = 101;
    public Context mContext;
    private static final String TAG = "LoginActivity";
    boolean isConnecting, isConnected;

    private long firstTime = 0;
    public ROSBridgeClient client = new ROSBridgeClient("ws://10.7.5.88:9090");
    public static String route_ip = "10.7.5";

    private final int DISCONNECT2 = -1;
    private final int DISCONNECT = 0;
    private final int CONNECT = 1;

    private final int handlerShowMapListDialog = 11;
    private final int handlerShowPosintListDialog = 12;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DISCONNECT2:
                    toast("正在初始化，请稍后再试");
                    break;
                case DISCONNECT:
                    toast("连接断开，请重新连接");

                    break;
                case CONNECT:

                    connectButton.setText("断开");
                    initData();
                    break;

                case handlerShowMapListDialog:

                    //找到下标
                    int mapindex = 0;
                    if (currentMapList != null && currentMapList.size() > 0) {
                        for (Maps maps : currentMapList) {
                            if (maps.getMapId() == currentMapId) {
                                break;
                            }
                            mapindex++;
                        }
                        currentMapList.add(0, currentMapList.remove(mapindex));
                    }

                    mapListAdapter.setListData(currentMapList, currentMapId);
                    break;
                case handlerShowPosintListDialog:
                    pointListAdapater.setData(buildMapLocalNaviPoints);
//                    或者
//                    pointListAdapater.setData(currentMapPosintList);
                    break;
            }
        }
    };

    private RecyclerView map_list_ry, points_rv;
    private Button stop_bt, change_bt;
    private TextView power_status_tv, power_value_tv,eme_status_tv,navi_status_tv;


    private PointListAdapater pointListAdapater;
    private MapListAdapter mapListAdapter;
    private int mapStatus;

    private long currentFloorId = 0;
    private List<Maps> currentMapList = new ArrayList<Maps>();
    private long currentMapId = 0;
    private List<Points> currentMapPosintList = new ArrayList<Points>();


    private List<Points> buildMapLocalAllPoint = new LinkedList<>();
    private List<Points> buildMapLocalNaviPoints = new LinkedList<>();
    private List<Points> buildMapLocalSystemPoint = new LinkedList<>();

    private List<Points> robotPointConfigList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_master);
//        setW4FS();
        mContext = this;

        root_ll = (LinearLayout) findViewById(R.id.root_ll);
        root_ll.setPadding(10, getStatusBarHeight(mContext), 10, 0);

        connectButton = (Button) findViewById(R.id.master_chooser_ok);
        connectButton.setOnClickListener(this);


        stop_bt = (Button) findViewById(R.id.stop_bt);
        stop_bt.setOnClickListener(this);
        change_bt = (Button) findViewById(R.id.change_bt);
        change_bt.setOnClickListener(this);

        power_status_tv = findViewById(R.id.power_status_tv);
        power_value_tv = findViewById(R.id.power_value_tv);
        eme_status_tv = findViewById(R.id.eme_status_tv);
        navi_status_tv = findViewById(R.id.navi_status_tv);

        map_list_ry = (RecyclerView) findViewById(R.id.map_list_ry);
        points_rv = findViewById(R.id.points_rv);

        pointListAdapater = new PointListAdapater(this);
        mapListAdapter = new MapListAdapter(this);
        mapListAdapter.setOnclickItem(new MapListAdapter.OnClick() {
            @Override
            public void longlick(View v) {

            }

            @Override
            public void click(View v) {
                if (currentMapList.get((Integer) v.getTag()).getMapId() == currentMapId) {
                    toast("当前地图已经加载");
                    return;
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                dialog.setTitle("是否切换地图：" + currentMapList.get((Integer) v.getTag()).getMapName());
                dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        loadMap(0, currentFloorId,currentMapList.get((Integer) v.getTag()).getMapId());
                    }
                });
                dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
            }
        });


        pointListAdapater.setOnItemClick(new PointListAdapater.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d(TAG, "onItemClick: position " + position);
                long pointId = buildMapLocalNaviPoints.get(position).getPointId();


                goNavito(pointId);

            }

            @Override
            public void onItemLongClick(View view, int position) {

                deleteNavi(currentFloorId, currentMapId, buildMapLocalNaviPoints.get(position).getPointId());
            }
        });

        map_list_ry.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        map_list_ry.setAdapter(mapListAdapter);
        points_rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        points_rv.setAdapter(pointListAdapater);

    }

    private void initData() {

        //当前初始化状态订阅（地图是否加载成功）
        Topic<Int16> initStatusTopic = new Topic<>(TopicNames.InitMsg, Int16.class, client);
        initStatusTopic.subscribe(new MessageHandler<Int16>() {
            @Override
            public void onMessage(Int16 message) {
                if (message.data == 11) {
                    Log.d(TAG, "onMessage: 初始化失败");
                } else if (message.data == 12) {
                    Log.d(TAG, "onMessage: 初始化成功");
                }
            }
        });
        //initStatusTopic.unsubscribe();//解除订阅


        // 电池电量订阅
        Topic<Int16> powerTopic = new Topic<>(TopicNames.Battry, Int16.class, client);
        powerTopic.subscribe(new MessageHandler<Int16>() {
            @Override
            public void onMessage(Int16 message) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        power_value_tv.setText(message.data + "");
                    }
                });
            }
        });

        // 充电状态订阅
        Topic<Int16> chageMsgTopic = new Topic<>(TopicNames.ChageMsg, Int16.class, client);
        chageMsgTopic.subscribe(new MessageHandler<Int16>() {
            @Override
            public void onMessage(Int16 message) {
//                41 没有充电           // 42 充电中(弃用)43 充电完成(弃用)
//                44 充电失败
//                45 自动充电中 46 手动充电中
//                47 自动充电完成 48 手动充电完成


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (message.data == 45 || message.data == 46 ||
                                message.data == 47 || message.data == 48) {
                            power_status_tv.setText("True");
                        }else {
                            power_status_tv.setText("False");
                        }
                    }
                });


            }
        });

        // 急停状态订阅
        Topic<Int16> emeStatusTopic = new Topic<>(TopicNames.EMEMsg, Int16.class, client);
        emeStatusTopic.subscribe(new MessageHandler<Int16>() {
            @Override
            public void onMessage(Int16 message) {
//                31 机器人处于急停状态！机器人电机锁住不动
//                32 机器人急停状态取消
                int data = message.data;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (data == 31) {
                            eme_status_tv.setText("True");
                        }
                        if (data == 32) {
                            eme_status_tv.setText("False");
                        }
                    }
                });

            }

        });


        //当前地图模式订阅
        Topic<Int16> mapStatusTopic = new Topic<>(TopicNames.MapStatus, Int16.class, client);
        mapStatusTopic.subscribe(new MessageHandler<Int16>() {
            @Override
            public void onMessage(Int16 int16) {
                //0导航模式 1建图模式 2扩展地图模式
                int data = int16.getData();
                Log.d(TAG, "topic getMapBuildStatusMsg: " + data);
                mapStatus = data;
            }
        });

        //当地图数据是否发生变化订阅
        Topic<Int32> mapUpdateTopic = new Topic<>(TopicNames.WallUpdateMsg, Int32.class, client);
        mapUpdateTopic.subscribe(new MessageHandler<Int32>() {
            @Override
            public void onMessage(Int32 message) {
                //当地图数据发生变化就会触发这里


                //读取地图列表
                Service<Empty, TriggerResponse> mapsService = new Service<Empty, TriggerResponse>
                        (ServiceNames.GetMaps, Empty.class, TriggerResponse.class, client);
                mapsService.callWithHandler(new Empty(), new MessageHandler<TriggerResponse>() {
                    @Override
                    public void onMessage(TriggerResponse message) {
                        if (message.getSuccess()) {
                            if (message.getMessage().isEmpty()) return;
                            MapList localMapList = new MapList();
                            try {
                                JSONObject jsonObject = new JSONObject(message.getMessage());
                                localMapList = new Gson().fromJson(jsonObject.toString(), new TypeToken<MapList>() {
                                }.getType());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            for (Floors floors : localMapList.getFloors()) {
                                if (floors.getFloorId() == localMapList.getDefaultFloor()) {
                                    currentFloorId = floors.getFloorId();
                                    for (Maps maps : floors.getMaps()) {
                                        if (floors.getDefaultmap() == maps.getMapId()) {
                                            if (mapStatus == 0) {

                                            }

                                            //通知刷新ui
                                            currentMapList = floors.getMaps();
                                            currentMapId = floors.getDefaultmap();
                                            currentMapPosintList.clear();
                                            for (Points pointListEntry : maps.getPoints()) {
                                                if (pointListEntry.getPointName().equals(MyApplication.CANCLEPOINTNAME))
                                                    continue;
                                                currentMapPosintList.add(pointListEntry);
                                            }
                                            mHandler.sendEmptyMessage(handlerShowMapListDialog);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                });


                //获取建图时候的临时地图信息,当机器处于建图状态时候，可以从这里获取导航点数据
                Service<Empty, ListNaviPointsResponse> buildPoints = new Service<Empty, ListNaviPointsResponse>
                        (ServiceNames.NaviPoints, Empty.class, ListNaviPointsResponse.class, client);
                buildPoints.callWithHandler(new Empty(), new MessageHandler<ListNaviPointsResponse>() {
                    @Override
                    public void onMessage(ListNaviPointsResponse response) {

                        buildMapLocalAllPoint.clear();
                        buildMapLocalNaviPoints.clear();
                        buildMapLocalSystemPoint.clear();

                        List<PointListEntry> naviPoints = response.getListNaviPoints();
                        List<PointListEntry> systemPoints = response.getListSystemPoints();
                        if (naviPoints != null)
                            for (PointListEntry entry : naviPoints) {
                                if (entry.getPointName().equals(MyApplication.CANCLEPOINTNAME))
                                    continue;
                                Points points = new Points();
                                points.setPointId(Long.parseLong(entry.getPointId()));
                                points.setPointName(entry.getPointName());
                                points.setPositionX(entry.getX());
                                points.setPositionY(entry.getY());
                                points.setPositionYaw(entry.getZ());
                                buildMapLocalAllPoint.add(points);
                                buildMapLocalNaviPoints.add(points);
                            }
                        if (systemPoints != null)
                            for (PointListEntry entry : systemPoints) {
                                if (entry.getPointName().equals(MyApplication.CANCLEPOINTNAME))
                                    continue;
                                Points points = new Points();
                                points.setPointId(Long.parseLong(entry.getPointId()));
                                points.setPointName(entry.getPointName());
                                points.setPositionX(entry.getX());
                                points.setPositionY(entry.getY());
                                points.setPositionYaw(entry.getZ());
                                buildMapLocalAllPoint.add(points);
                                buildMapLocalSystemPoint.add(points);
                            }


                        mHandler.sendEmptyMessage(handlerShowPosintListDialog);
                    }

                });

            }
        });

        //导航结果回调
        Topic<Int16> navStatusTpic = new Topic<>(TopicNames.NavigationMsg, Int16.class,client);
        navStatusTpic.subscribe(new MessageHandler<Int16>() {
            @Override
            public void onMessage(Int16 message) {
                int s = message.getData();
                Log.d(TAG, "topic 导航状态: status = " + s );
//                  1,       // 开始导航
//                  2,       // 导航到目的点成功
//                  3,       // 导航到导航点进行各种尝试后失败，导航停止
//                  4,       // 局部路径规划规划失败，并且超时，进入恢复模式
//                  5,       // 导航进入地图CLEANING模式，原先值为12
//                  6,       // 找不到导航点
//                  7,       // 停止导航 下发stop命令后上报
//                  8,       // 全局路径规划失败，并且进入超时,碰到障碍物，提醒请让一让
//                  51:      // 机器人充电过程中，导航到充电桩过程中导航失败，导致充电失败！!";
//                  52:      // 机器人没有设置充电桩！!";
//                  81:      // 机器人导航验证成功！
//                  82:      // 机器人导航验证失败！
//                  83:      // 机器人导航取消！
//                  84:      // 机器人位置已丢失，请重新定位才能导航！

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        navi_status_tv.setText(s+"");
                    }
                });
            }
        });
//        addPosintServices(0L, "aaa");
    }

    //切换地图(可跨楼层)
    private void loadMap(final int type, long floorId, long mapId) {

        toast("加载中...");
        client.setDebug(true);

        Service<PublishMapRequest, Empty> changeMap = new Service<PublishMapRequest, Empty>
                (ServiceNames.ChangeMap, PublishMapRequest.class, Empty.class, client);
        PublishMapRequest request = new PublishMapRequest();
        request.setType(type);
        request.setFloorId(floorId);
        request.setMapId(mapId);
        changeMap.callWithHandler(request, new MessageHandler<Empty>() {
            @Override
            public void onMessage(Empty message) {

                Log.i(TAG, "loadMap() Success");
            }

        });
    }

    // 保存地图 (只能在建图模式调用)
    public void saveMapService(int type, long floorId, String floorName,
                               String mapName) {
        Service<SaveMapRequest, SaveMapResponse> saveMap = new Service<SaveMapRequest, SaveMapResponse>
                (ServiceNames.SaveMap, SaveMapRequest.class, SaveMapResponse.class, client);
        SaveMapRequest request = new SaveMapRequest();
        request.setType(type);
        request.setFloorId(floorId);
        request.setFloorName(floorName);
        request.setMapName(mapName);
        saveMap.callWithHandler(request, new MessageHandler<SaveMapResponse>() {
            @Override
            public void onMessage(SaveMapResponse message) {
                if (message.getStatus() != 0) {

                    toast(message.getMessage());
                }
            }
        });
    }


    // 添加导航点
    public void addPosintServices(long posinMode, String posinName) {
        Service<PointSetRequest, PointSetResponse> addPoint = new Service<PointSetRequest, PointSetResponse>
                (ServiceNames.AddPoint, PointSetRequest.class, PointSetResponse.class, client);
        PointSetRequest request = new PointSetRequest();
        request.setPointName(posinName);
        request.setPointMode(posinMode);
        addPoint.callWithHandler(request, new MessageHandler<PointSetResponse>() {
            @Override
            public void onMessage(PointSetResponse message) {
                Log.d(TAG, "addPosintServices: message.getResult = "+message.getResult());
            }
        });
    }

    // 删除导航点(楼层版)
    private void deleteNavi(long floor_id, long map_id, long id) {

        Service<DeleteTestPointRequest, DeleteTestPointResponse> deleteNavi = new Service<DeleteTestPointRequest, DeleteTestPointResponse>
                (ServiceNames.DeleteTestPoint, DeleteTestPointRequest.class, DeleteTestPointResponse.class, client);
        DeleteTestPointRequest request = new DeleteTestPointRequest();
        request.setFloorId(floor_id);
        request.setMapId(map_id);
        request.setPointId(id);
        deleteNavi.callWithHandler(request,new MessageHandler<DeleteTestPointResponse>() {
//            @Override
//            public void onFailure(RemoteException e) {
//                safeDismissWaitingDialog();
//                toast(R.string.toas_main_fail);
//                e.printStackTrace();
//            }

            @Override
            public void onMessage(DeleteTestPointResponse arg0) {
//                    toast("onSuccess: getResult()" + arg0.getResult());

                if (arg0.getResult() == 0) {
                    toast("成功");
                } else if (arg0.getResult() == 4) {
                    toast("被引用路线，不可删除");
                } else {
                    toast("失败");
                }
            }
        });
    }

    //开启导航
    private void goNavito(int position) {
        String name = buildMapLocalNaviPoints.get(position).getPointName();
        toast("导航任务: " + name);
        Topic<SetTargetGoal> setTargetGoalPublish = new Topic<SetTargetGoal>(TopicNames.NaviToPointName, SetTargetGoal.class, client);
        //注册发布消息类型
        setTargetGoalPublish.advertise();

        SetTargetGoal setTargetGoal = new SetTargetGoal();
        setTargetGoal.setGoalName(name);

        setTargetGoalPublish.publish(setTargetGoal);

        //解除注册发布类型
        setTargetGoalPublish.unadvertise();
    }

    //开启导航 楼层版
    private void goNavito(long pointId) {
        toast("导航任务: " + pointId);

        Topic<TargetGoal> naviTargetGoalPublish = new Topic<TargetGoal>(TopicNames.naviTargetgoal, TargetGoal.class, client);
        naviTargetGoalPublish.advertise();

        TargetGoal setTargetGoal = new TargetGoal();
        setTargetGoal.setFloorId(currentFloorId);
        setTargetGoal.setMapId(currentMapId);
        setTargetGoal.setPointId(pointId);

        naviTargetGoalPublish.publish(setTargetGoal);

        naviTargetGoalPublish.unadvertise();
    }


    @Override
    protected void onResume() {
        super.onResume();
        setNetWorkManager1(false);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.master_chooser_ok) {
            if (isConnected) {
                connectButton.setText("连接");

                client.disconnect();
                return;
            }

            long secondTime = System.currentTimeMillis();//以毫秒为单位
            if (secondTime - firstTime > 2000) {
                firstTime = secondTime;
            } else {
                toast("太频繁了，请稍后再试");
                return;
            }
            if (isConnecting) {

                toast("正在连接，请稍后");
                return;
            }
            boolean isAllGranted = checkPermissionAllGranted(
                    permissions
            );
//         如果这2个权限有一个没授予
            if (!isAllGranted) {
                //调用父类方法，请求权限
                requestPermissions_(permissions);
            } else {
                checkLogin();//已有权限
            }
        }

        if (view.getId() == R.id.stop_bt) {

            Topic<Int16> stopNaviPublish = new Topic<Int16>(TopicNames.NaviStop, Int16.class, client);
            stopNaviPublish.advertise();
            Int16 int16 = new Int16();
            int16.setData((short) 5);
            stopNaviPublish.publish(int16);
            stopNaviPublish.unadvertise();
        }
        if (view.getId() == R.id.change_bt) {
            Topic<Int16> goChargePublish = new Topic<Int16>(TopicNames.GoCharge, Int16.class, client);
            goChargePublish.advertise();
            Int16 changeint16 = new Int16();
            changeint16.setData((short) 1);
            goChargePublish.publish(changeint16);
            goChargePublish.unadvertise();
        }

    }

    private void checkLogin() {
        //检查网卡
        boolean isRosWifi = hasRosWifi();
        Log.d(TAG, "checkLogin: 是否检查到ros网络 " + isRosWifi);
        if (isRosWifi) {
            //设置wifi
            setNetWorkManager1(true);
        } else {
//            connectButton.setVisibility(View.VISIBLE);
            toast("连接wifi不正确，请连接spirit机器人的wifi");

            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
        }
    }

    private void login() {
        client.connect(new ROSClient.ConnectionStatusListener() {
            @Override
            public void onConnect() {
                isConnecting = false;
                isConnected = true;
                Log.d(TAG, "ROSBridgeClient onConnect: ws 成功");
                mHandler.sendEmptyMessage(CONNECT);
            }

            @Override
            public void onDisconnect(boolean normal, String reason, int code) {
                Log.d(TAG, "ROSBridgeClient onDisconnect: code " + code);

                // -1 连接不上， 1000 手机主动dis断开  1006 服务端或手机意外网络断开
                isConnecting = false;
                isConnected = false;

                if (code < 0) {
                    mHandler.sendEmptyMessage(DISCONNECT2);
                } else if (code == 1000) {

                } else if (code > 1000) {
                    mHandler.sendEmptyMessage(DISCONNECT);
                }

            }

            @Override
            public void onError(Exception ex) {
                isConnecting = false;
                isConnected = false;
                Log.d(TAG, "ROSBridgeClient onError: ");
                ex.printStackTrace();
            }
        });

    }


    //屏幕适配
    private void setW4FS() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (Build.VERSION.SDK_INT >= 28) {
            // Android P利用官方提供的API适配
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            // 始终允许窗口延伸到屏幕短边上的缺口区域
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(lp);
        }
        int flags = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        int visibility = getWindow().getDecorView().getSystemUiVisibility();
        visibility |= flags; //追加沉浸式设置
        getWindow().getDecorView().setSystemUiVisibility(visibility);
    }


    //获取状态栏高度
    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static boolean hasRosWifi() {
        try {
            Enumeration<NetworkInterface> enNetworkInterface = NetworkInterface.getNetworkInterfaces(); //获取本机所有的网络接口
            if (null == enNetworkInterface)
                return false;
            while (enNetworkInterface.hasMoreElements()) {  //判断 Enumeration 对象中是否还有数据
                NetworkInterface networkInterface = enNetworkInterface.nextElement();   //获取 Enumeration 对象中的下一个数据
                if (!networkInterface.isUp()) { // 判断网口是否在使用
                    continue;
                }
                Enumeration<InetAddress> enInetAddress = networkInterface.getInetAddresses();   //getInetAddresses 方法返回绑定到该网卡的所有的 IP 地址。
                while (enInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enInetAddress.nextElement();
//                    判断未lo时
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
//                        Log.d("getAllNetInterface",
//                                "getAllNetInterface: name: "+networkInterface.getDisplayName()
//                                        +", HostAddress: "+inetAddress.getHostAddress());
                        if (inetAddress.getHostAddress().contains(route_ip)) {

                            return true;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 设置设备网络传输类型
     * <p>
     * 蜂窝网络.
     */
    public void setNetWorkManager1(final boolean isIntent) {
        isConnecting = true;

        final ConnectivityManager connectivityManager = (ConnectivityManager) this.getApplication().getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        //强制使用蜂窝数据网络-移动数据
        builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR);
        NetworkRequest request = builder.build();
        ConnectivityManager.NetworkCallback callback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                super.onAvailable(network);
                ConnectivityManager.setProcessDefaultNetwork(network);
                connectivityManager.unregisterNetworkCallback(this);
                Log.d(TAG, "onAvailable:  设置流量");
//                setNetWorkManager2();
            }

            @Override
            public void onLost(Network network) {
                super.onLost(network);

            }

        };
        try {
            connectivityManager.requestNetwork(request, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setNetWorkManager2(isIntent);
            }
        }).start();

    }

    /**
     * 设置设备网络传输类型
     * <p>
     * wifi.
     */
    public void setNetWorkManager2(final boolean isIntent) {
        final ConnectivityManager connectivityManager = (ConnectivityManager) this.getApplication().getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);
        NetworkRequest request = builder.build();
        ConnectivityManager.NetworkCallback callback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                super.onAvailable(network);
                ConnectivityManager.setProcessDefaultNetwork(network);
                connectivityManager.unregisterNetworkCallback(this);
                Log.d(TAG, "onAvailable:  设置wifi");

                if (isIntent)
                    login();
            }
        };
        try {
            connectivityManager.requestNetwork(request, callback);
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (!isIntent) {
            isConnecting = false;
        }
    }

    public void toast(int aa) {
        String eart = String.valueOf(aa);
        if (eart.length() > 5) {
            eart = getResources().getString(aa);
        }
        toast(eart);
    }

    public void toast(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 第 1 步  检查是否拥有指定的所有权限
     */
    public boolean checkPermissionAllGranted(String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                // 只要有一个权限没有被授予, 则直接返回 false
                return false;
            }
        }
        return true;
    }


    /**
     * 第 2 步: 请求权限
     */
    // 一次请求多个权限, 如果其他有权限是已经授予的将会自动忽略掉
    public void requestPermissions_(String[] permissions) {
//        this.Msg=Msg_;
        ActivityCompat.requestPermissions(
                this, permissions, LOCATION_PERM);
    }

    /**
     * 第 3 步: 申请权限结果返回处理,重写
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERM) {
            boolean isAllGranted = true;

            // 判断是否所有的权限都已经授予了
            for (int grant : grantResults) {
                if (grant != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false;
                    break;
                }
            }
            if (!isAllGranted) {
                //调用子类方法
                openAppDetails("null");
                // 弹出对话框告诉用户需要权限的原因, 并引导用户去应用权限管理中手动打开权限按钮
            } else {
                Log.e(TAG, "onRequestPermissionsResult: 自动登录");
                //已经授予权限
                checkLogin();//权限已经获取到
            }
        }
    }

    /**
     * 打开 APP 的详情设置
     *
     * @param Mag
     */
    public void openAppDetails(String Mag) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("申请失败: 您已拒绝权限, 需要定位权限，请到 “应用信息 -> 权限” 中授予！");
//        builder.setMessage(Mag);
        builder.setPositiveButton("去手动授权", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(Uri.parse("package:" + getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();
    }


}