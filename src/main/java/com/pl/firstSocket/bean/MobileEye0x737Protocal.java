package com.pl.firstSocket.bean;

/**
 * MobileEye0x737协议实体类
 * 0x737 – 车道信息
 */
public class MobileEye0x737Protocal {
    //唯一标识，unix时间戳
    private String id;
    //车道曲率 Lane_Curvature
    private String lane_Curvature;
    //车道航向 Lane_Heading
    private String lane_Heading;
    //CA–施工区域  CA_Construction_Area
    private String cA_Construction_Area;
    //俯仰角  Pitch_Angle
    private String pitch_Angle;
    //偏航角 Yaw_Angle
    private String yaw_Angle;
    //右LDW可用性 Right_LDW_Availability
    private String right_LDW_Availability;
    //左LDW可用性 Left_LDW_Availability
    private String left_LDW_Availability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLane_Curvature() {
        return lane_Curvature;
    }

    public void setLane_Curvature(String lane_Curvature) {
        this.lane_Curvature = lane_Curvature;
    }

    public String getLane_Heading() {
        return lane_Heading;
    }

    public void setLane_Heading(String lane_Heading) {
        this.lane_Heading = lane_Heading;
    }

    public String getcA_Construction_Area() {
        return cA_Construction_Area;
    }

    public void setcA_Construction_Area(String cA_Construction_Area) {
        this.cA_Construction_Area = cA_Construction_Area;
    }

    public String getPitch_Angle() {
        return pitch_Angle;
    }

    public void setPitch_Angle(String pitch_Angle) {
        this.pitch_Angle = pitch_Angle;
    }

    public String getYaw_Angle() {
        return yaw_Angle;
    }

    public void setYaw_Angle(String yaw_Angle) {
        this.yaw_Angle = yaw_Angle;
    }

    public String getRight_LDW_Availability() {
        return right_LDW_Availability;
    }

    public void setRight_LDW_Availability(String right_LDW_Availability) {
        this.right_LDW_Availability = right_LDW_Availability;
    }

    public String getLeft_LDW_Availability() {
        return left_LDW_Availability;
    }

    public void setLeft_LDW_Availability(String left_LDW_Availability) {
        this.left_LDW_Availability = left_LDW_Availability;
    }

    public MobileEye0x737Protocal() {
    }

    public MobileEye0x737Protocal(String id, String lane_Curvature, String lane_Heading, String cA_Construction_Area, String pitch_Angle, String yaw_Angle, String right_LDW_Availability, String left_LDW_Availability) {
        this.id = id;
        this.lane_Curvature = lane_Curvature;
        this.lane_Heading = lane_Heading;
        this.cA_Construction_Area = cA_Construction_Area;
        this.pitch_Angle = pitch_Angle;
        this.yaw_Angle = yaw_Angle;
        this.right_LDW_Availability = right_LDW_Availability;
        this.left_LDW_Availability = left_LDW_Availability;
    }

    @Override
    public String toString() {
        return "MobileEye0x737Protocal{" +
                "id='" + id + '\'' +
                ", lane_Curvature='" + lane_Curvature + '\'' +
                ", lane_Heading='" + lane_Heading + '\'' +
                ", cA_Construction_Area='" + cA_Construction_Area + '\'' +
                ", pitch_Angle='" + pitch_Angle + '\'' +
                ", yaw_Angle='" + yaw_Angle + '\'' +
                ", right_LDW_Availability='" + right_LDW_Availability + '\'' +
                ", left_LDW_Availability='" + left_LDW_Availability + '\'' +
                '}';
    }
}
