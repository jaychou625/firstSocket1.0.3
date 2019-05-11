package com.pl.firstSocket.bean;
/**
 * MobileEye0x76A协议实体类
 * 0x76A 参考点相关信息
 */
public class MobileEye0x76AProtocal {
    //唯一标识，unix时间戳
    private String id;
    //参考点1的位置 pointOnePosition
    private String pointOnePosition;
    //参考点1的距离 pointOneDistance
    private String pointOneDistance;
    //参考点1的有效位 pointOneAvailable;
    private String pointOneAvailable;
    //参考点2的位置 pointTwoPosition
    private String pointTwoPosition;
    //参考点2的距离 pointTwoDistance
    private String pointTwoDistance;
    //参考点2的有效位 pointTwoAvailable;
    private String pointTwoAvailable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPointOnePosition() {
        return pointOnePosition;
    }

    public void setPointOnePosition(String pointOnePosition) {
        this.pointOnePosition = pointOnePosition;
    }

    public String getPointOneDistance() {
        return pointOneDistance;
    }

    public void setPointOneDistance(String pointOneDistance) {
        this.pointOneDistance = pointOneDistance;
    }

    public String getPointOneAvailable() {
        return pointOneAvailable;
    }

    public void setPointOneAvailable(String pointOneAvailable) {
        this.pointOneAvailable = pointOneAvailable;
    }

    public String getPointTwoPosition() {
        return pointTwoPosition;
    }

    public void setPointTwoPosition(String pointTwoPosition) {
        this.pointTwoPosition = pointTwoPosition;
    }

    public String getPointTwoDistance() {
        return pointTwoDistance;
    }

    public void setPointTwoDistance(String pointTwoDistance) {
        this.pointTwoDistance = pointTwoDistance;
    }

    public String getPointTwoAvailable() {
        return pointTwoAvailable;
    }

    public void setPointTwoAvailable(String pointTwoAvailable) {
        this.pointTwoAvailable = pointTwoAvailable;
    }

    public MobileEye0x76AProtocal() {
    }

    public MobileEye0x76AProtocal(String id, String pointOnePosition, String pointOneDistance, String pointOneAvailable, String pointTwoPosition, String pointTwoDistance, String pointTwoAvailable) {
        this.id = id;
        this.pointOnePosition = pointOnePosition;
        this.pointOneDistance = pointOneDistance;
        this.pointOneAvailable = pointOneAvailable;
        this.pointTwoPosition = pointTwoPosition;
        this.pointTwoDistance = pointTwoDistance;
        this.pointTwoAvailable = pointTwoAvailable;
    }

    @Override
    public String toString() {
        return "MobileEye0x76AProtocal{" +
                "id='" + id + '\'' +
                ", pointOnePosition='" + pointOnePosition + '\'' +
                ", pointOneDistance='" + pointOneDistance + '\'' +
                ", pointOneAvailable='" + pointOneAvailable + '\'' +
                ", pointTwoPosition='" + pointTwoPosition + '\'' +
                ", pointTwoDistance='" + pointTwoDistance + '\'' +
                ", pointTwoAvailable='" + pointTwoAvailable + '\'' +
                '}';
    }
}
