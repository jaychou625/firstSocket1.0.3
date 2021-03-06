package com.pl.firstSocket.bean;

/**
 * MobileEye0x766协议实体类
 * 0x766 – left lane A 左车道A
 */
public class MobileEye0x766Protocal {
    //唯一标识，unix时间戳
    private String id;
    //车道类型 Lane_Type
    private String lane_Type;
    //道路质量 Quality
    private String quality;
    //Model_Degree
    private String model_Degree;
    //位置参数C0 Position_Parameter C0
    private String position_Parameter;
    //曲率参数C2 Curvature_Parameter C2
    private String curvature_Parameter;
    //曲率导数参数C3 Curvature_Derivative_Parameter C3
    private String curvature_Derivative_Parameter;
    //标记宽度 Width_Left_Marking
    private String Width_Left_Marking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLane_Type() {
        return lane_Type;
    }

    public void setLane_Type(String lane_Type) {
        this.lane_Type = lane_Type;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getModel_Degree() {
        return model_Degree;
    }

    public void setModel_Degree(String model_Degree) {
        this.model_Degree = model_Degree;
    }

    public String getPosition_Parameter() {
        return position_Parameter;
    }

    public void setPosition_Parameter(String position_Parameter) {
        this.position_Parameter = position_Parameter;
    }

    public String getCurvature_Parameter() {
        return curvature_Parameter;
    }

    public void setCurvature_Parameter(String curvature_Parameter) {
        this.curvature_Parameter = curvature_Parameter;
    }

    public String getCurvature_Derivative_Parameter() {
        return curvature_Derivative_Parameter;
    }

    public void setCurvature_Derivative_Parameter(String curvature_Derivative_Parameter) {
        this.curvature_Derivative_Parameter = curvature_Derivative_Parameter;
    }

    public String getWidth_Left_Marking() {
        return Width_Left_Marking;
    }

    public void setWidth_Left_Marking(String width_Left_Marking) {
        Width_Left_Marking = width_Left_Marking;
    }

    public MobileEye0x766Protocal() {
    }

    public MobileEye0x766Protocal(String id, String lane_Type, String quality, String model_Degree, String position_Parameter, String curvature_Parameter, String curvature_Derivative_Parameter, String width_Left_Marking) {
        this.id = id;
        this.lane_Type = lane_Type;
        this.quality = quality;
        this.model_Degree = model_Degree;
        this.position_Parameter = position_Parameter;
        this.curvature_Parameter = curvature_Parameter;
        this.curvature_Derivative_Parameter = curvature_Derivative_Parameter;
        Width_Left_Marking = width_Left_Marking;
    }

    @Override
    public String toString() {
        return "MobileEye0x766Protocal{" +
                "id='" + id + '\'' +
                ", lane_Type='" + lane_Type + '\'' +
                ", quality='" + quality + '\'' +
                ", model_Degree='" + model_Degree + '\'' +
                ", position_Parameter='" + position_Parameter + '\'' +
                ", curvature_Parameter='" + curvature_Parameter + '\'' +
                ", curvature_Derivative_Parameter='" + curvature_Derivative_Parameter + '\'' +
                ", Width_Left_Marking='" + Width_Left_Marking + '\'' +
                '}';
    }
}
