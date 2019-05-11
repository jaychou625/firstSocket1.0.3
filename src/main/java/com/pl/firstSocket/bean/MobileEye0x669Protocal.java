package com.pl.firstSocket.bean;

/**
 * MobileEye0x737协议实体类
 * 0x737 – 车道信息
 */
public class MobileEye0x669Protocal {
    //唯一标识，unix时间戳
    private String id;
    //到左边线的距离   Distance_To_Left_Lane
    private String distance_To_Left_Lane;
    //左边道路标线的可识别等级 Lane_Confidence_Left
    private String lane_Confidence_Left;
    //左边LDW（车道偏离预警） 可用要求  LDW_Availability_Left
    private String lDW_Availability_Left;
    //左边车道类型  Lane_Type_Left;
    private String lane_Type_Left;
    //到右边线的距离   Distance_To_Right_Lane
    private String Distance_To_Right_Lane;
    //右边道路标线的可识别等级 Lane_Confidence_Right
    private String Lane_Confidence_Right;
    //右边LDW（车道偏离预警） 可用要求  LDW_Availability_Right
    private String LDW_Availability_Right;
    //右边车道类型  Lane_Type_Right;
    private String Lane_Type_Right;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistance_To_Left_Lane() {
        return distance_To_Left_Lane;
    }

    public void setDistance_To_Left_Lane(String distance_To_Left_Lane) {
        this.distance_To_Left_Lane = distance_To_Left_Lane;
    }

    public String getLane_Confidence_Left() {
        return lane_Confidence_Left;
    }

    public void setLane_Confidence_Left(String lane_Confidence_Left) {
        this.lane_Confidence_Left = lane_Confidence_Left;
    }

    public String getlDW_Availability_Left() {
        return lDW_Availability_Left;
    }

    public void setlDW_Availability_Left(String lDW_Availability_Left) {
        this.lDW_Availability_Left = lDW_Availability_Left;
    }

    public String getLane_Type_Left() {
        return lane_Type_Left;
    }

    public void setLane_Type_Left(String lane_Type_Left) {
        this.lane_Type_Left = lane_Type_Left;
    }

    public String getDistance_To_Right_Lane() {
        return Distance_To_Right_Lane;
    }

    public void setDistance_To_Right_Lane(String distance_To_Right_Lane) {
        Distance_To_Right_Lane = distance_To_Right_Lane;
    }

    public String getLane_Confidence_Right() {
        return Lane_Confidence_Right;
    }

    public void setLane_Confidence_Right(String lane_Confidence_Right) {
        Lane_Confidence_Right = lane_Confidence_Right;
    }

    public String getLDW_Availability_Right() {
        return LDW_Availability_Right;
    }

    public void setLDW_Availability_Right(String LDW_Availability_Right) {
        this.LDW_Availability_Right = LDW_Availability_Right;
    }

    public String getLane_Type_Right() {
        return Lane_Type_Right;
    }

    public void setLane_Type_Right(String lane_Type_Right) {
        Lane_Type_Right = lane_Type_Right;
    }

    public MobileEye0x669Protocal() {
    }

    public MobileEye0x669Protocal(String id, String distance_To_Left_Lane, String lane_Confidence_Left, String lDW_Availability_Left, String lane_Type_Left, String distance_To_Right_Lane, String lane_Confidence_Right, String LDW_Availability_Right, String lane_Type_Right) {
        this.id = id;
        this.distance_To_Left_Lane = distance_To_Left_Lane;
        this.lane_Confidence_Left = lane_Confidence_Left;
        this.lDW_Availability_Left = lDW_Availability_Left;
        this.lane_Type_Left = lane_Type_Left;
        Distance_To_Right_Lane = distance_To_Right_Lane;
        Lane_Confidence_Right = lane_Confidence_Right;
        this.LDW_Availability_Right = LDW_Availability_Right;
        Lane_Type_Right = lane_Type_Right;
    }

    @Override
    public String toString() {
        return "MobileEye0x669Protocal{" +
                "id='" + id + '\'' +
                ", distance_To_Left_Lane='" + distance_To_Left_Lane + '\'' +
                ", lane_Confidence_Left='" + lane_Confidence_Left + '\'' +
                ", lDW_Availability_Left='" + lDW_Availability_Left + '\'' +
                ", lane_Type_Left='" + lane_Type_Left + '\'' +
                ", Distance_To_Right_Lane='" + Distance_To_Right_Lane + '\'' +
                ", Lane_Confidence_Right='" + Lane_Confidence_Right + '\'' +
                ", LDW_Availability_Right='" + LDW_Availability_Right + '\'' +
                ", Lane_Type_Right='" + Lane_Type_Right + '\'' +
                '}';
    }
}
