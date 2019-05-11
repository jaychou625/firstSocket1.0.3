package com.pl.firstSocket.bean;
/**
 * MobileEye0x73B协议实体类
 * 0x73B + i*3 Details – 障碍物数据C
 */
public class MobileEye0x73BProtocal {
    //唯一标识，unix时间戳
    private String id;
    //障碍物角速率  Obstacle_Angle_Rate
    private String obstacle_Angle_Rate;
    //障碍物比例变化 Obstacle_Scale_Change
    private String obstacle_Scale_Change;
    //对象加速度x    Object_Accel_X
    private String object_Accel_X;
    //障碍物更换（bool） Obstacle_Replaced
    private String obstacle_Replaced;
    //障碍物角度（角度值） Obstacle_Angle
    private String obstacle_Angle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObstacle_Angle_Rate() {
        return obstacle_Angle_Rate;
    }

    public void setObstacle_Angle_Rate(String obstacle_Angle_Rate) {
        this.obstacle_Angle_Rate = obstacle_Angle_Rate;
    }

    public String getObstacle_Scale_Change() {
        return obstacle_Scale_Change;
    }

    public void setObstacle_Scale_Change(String obstacle_Scale_Change) {
        this.obstacle_Scale_Change = obstacle_Scale_Change;
    }

    public String getObject_Accel_X() {
        return object_Accel_X;
    }

    public void setObject_Accel_X(String object_Accel_X) {
        this.object_Accel_X = object_Accel_X;
    }

    public String getObstacle_Replaced() {
        return obstacle_Replaced;
    }

    public void setObstacle_Replaced(String obstacle_Replaced) {
        this.obstacle_Replaced = obstacle_Replaced;
    }

    public String getObstacle_Angle() {
        return obstacle_Angle;
    }

    public void setObstacle_Angle(String obstacle_Angle) {
        this.obstacle_Angle = obstacle_Angle;
    }

    public MobileEye0x73BProtocal() {
    }

    public MobileEye0x73BProtocal(String id, String obstacle_Angle_Rate, String obstacle_Scale_Change, String object_Accel_X, String obstacle_Replaced, String obstacle_Angle) {
        this.id = id;
        this.obstacle_Angle_Rate = obstacle_Angle_Rate;
        this.obstacle_Scale_Change = obstacle_Scale_Change;
        this.object_Accel_X = object_Accel_X;
        this.obstacle_Replaced = obstacle_Replaced;
        this.obstacle_Angle = obstacle_Angle;
    }
}
