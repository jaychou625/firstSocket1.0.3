package com.pl.firstSocket.bean;

/**
 * MobileEye0x767协议实体类
 * 0x767 – left lane B 左车道B
 */
public class MobileEye0x767Protocal {
    //唯一标识，unix时间戳
    private String id;
    //前进方向改变角 direction_Angle_Parameter  C1
    private String direction_Angle_Parameter;
    //视野范围 view_Range
    private String view_Range;
    //视野范围有效位 view_Range_Available
    private String view_Range_Available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirection_Angle_Parameter() {
        return direction_Angle_Parameter;
    }

    public void setDirection_Angle_Parameter(String direction_Angle_Parameter) {
        this.direction_Angle_Parameter = direction_Angle_Parameter;
    }

    public String getView_Range() {
        return view_Range;
    }

    public void setView_Range(String view_Range) {
        this.view_Range = view_Range;
    }

    public String getView_Range_Available() {
        return view_Range_Available;
    }

    public void setView_Range_Available(String view_Range_Available) {
        this.view_Range_Available = view_Range_Available;
    }

    public MobileEye0x767Protocal() {
    }

    public MobileEye0x767Protocal(String id, String direction_Angle_Parameter, String view_Range, String view_Range_Available) {
        this.id = id;
        this.direction_Angle_Parameter = direction_Angle_Parameter;
        this.view_Range = view_Range;
        this.view_Range_Available = view_Range_Available;
    }

    @Override
    public String toString() {
        return "MobileEye0x767Protocal{" +
                "id='" + id + '\'' +
                ", direction_Angle_Parameter='" + direction_Angle_Parameter + '\'' +
                ", view_Range='" + view_Range + '\'' +
                ", view_Range_Available='" + view_Range_Available + '\'' +
                '}';
    }
}
