package com.pl.firstSocket.bean;

/**
 * MobileEye0x769协议实体类
 * 0x769 – right lane B 右车道B
 */
public class MobileEye0x769Protocal {
    //唯一标识，unix时间戳
    private String id;
    //偏航角 Heading_Angle_Parameter C1
    private String heading_Angle_Parameter;
    //可见范围 View_Range
    private String view_Range;
    //可见范围有效性 View_Range_Availability
    private String view_Range_Availability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeading_Angle_Parameter() {
        return heading_Angle_Parameter;
    }

    public void setHeading_Angle_Parameter(String heading_Angle_Parameter) {
        this.heading_Angle_Parameter = heading_Angle_Parameter;
    }

    public String getView_Range() {
        return view_Range;
    }

    public void setView_Range(String view_Range) {
        this.view_Range = view_Range;
    }

    public String getView_Range_Availability() {
        return view_Range_Availability;
    }

    public void setView_Range_Availability(String view_Range_Availability) {
        this.view_Range_Availability = view_Range_Availability;
    }

    public MobileEye0x769Protocal() {
    }

    public MobileEye0x769Protocal(String id, String heading_Angle_Parameter, String view_Range, String view_Range_Availability) {
        this.id = id;
        this.heading_Angle_Parameter = heading_Angle_Parameter;
        this.view_Range = view_Range;
        this.view_Range_Availability = view_Range_Availability;
    }

    @Override
    public String toString() {
        return "MobileEye0x769Protocal{" +
                "id='" + id + '\'' +
                ", heading_Angle_Parameter='" + heading_Angle_Parameter + '\'' +
                ", view_Range='" + view_Range + '\'' +
                ", view_Range_Availability='" + view_Range_Availability + '\'' +
                '}';
    }
}
