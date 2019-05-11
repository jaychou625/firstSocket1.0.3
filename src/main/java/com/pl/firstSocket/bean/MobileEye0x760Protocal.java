package com.pl.firstSocket.bean;

/**
 * MobileEye0x760协议实体类
 * 0x760 车辆相关信息
 */
public class MobileEye0x760Protocal {
    //唯一标识，unix时间戳
    private String id;
    //远光灯 High_Beam
    private String high_Beam;
    //近光灯 Low_Beam
    private String low_Beam;
    //雨刷 Wipers
    private String wipers;
    //右转灯 Right_Signal
    private String right_Signal;
    //左转灯 Left_Signal
    private String left_Signal;
    //刹车信号 Brakes
    private String brakes;
    //雨刷有效位 Wipers_Available
    private String wipers_Available;
    //近光灯有效位 Low_Beam_Available
    private String low_Beam_Available;
    //远光灯有效位  High_Beam_Available
    private String high_Beam_Available;
    //右转灯有效位 Right_Blink_Available
    private String right_Blink_Available;
    //左转灯有效位 Left_Blink_Available
    private String left_Blink_Available;
    //刹车信号有效位 Brake_available
    private String brake_Available;
    //速度有效位 Speed_Available
    private String speed_Available;
    //速度 (Km/h) Speed
    private String speed;
    //屏蔽+设置 Shield_And_Settings
    private String shield_And_Settings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHigh_Beam() {
        return high_Beam;
    }

    public void setHigh_Beam(String high_Beam) {
        this.high_Beam = high_Beam;
    }

    public String getLow_Beam() {
        return low_Beam;
    }

    public void setLow_Beam(String low_Beam) {
        this.low_Beam = low_Beam;
    }

    public String getWipers() {
        return wipers;
    }

    public void setWipers(String wipers) {
        this.wipers = wipers;
    }

    public String getRight_Signal() {
        return right_Signal;
    }

    public void setRight_Signal(String right_Signal) {
        this.right_Signal = right_Signal;
    }

    public String getLeft_Signal() {
        return left_Signal;
    }

    public void setLeft_Signal(String left_Signal) {
        this.left_Signal = left_Signal;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getWipers_Available() {
        return wipers_Available;
    }

    public void setWipers_Available(String wipers_Available) {
        this.wipers_Available = wipers_Available;
    }

    public String getLow_Beam_Available() {
        return low_Beam_Available;
    }

    public void setLow_Beam_Available(String low_Beam_Available) {
        this.low_Beam_Available = low_Beam_Available;
    }

    public String getHigh_Beam_Available() {
        return high_Beam_Available;
    }

    public void setHigh_Beam_Available(String high_Beam_Available) {
        this.high_Beam_Available = high_Beam_Available;
    }

    public String getRight_Blink_Available() {
        return right_Blink_Available;
    }

    public void setRight_Blink_Available(String right_Blink_Available) {
        this.right_Blink_Available = right_Blink_Available;
    }

    public String getLeft_Blink_Available() {
        return left_Blink_Available;
    }

    public void setLeft_Blink_Available(String left_Blink_Available) {
        this.left_Blink_Available = left_Blink_Available;
    }

    public String getBrake_Available() {
        return brake_Available;
    }

    public void setBrake_Available(String brake_Available) {
        this.brake_Available = brake_Available;
    }

    public String getSpeed_Available() {
        return speed_Available;
    }

    public void setSpeed_Available(String speed_Available) {
        this.speed_Available = speed_Available;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getShield_And_Settings() {
        return shield_And_Settings;
    }

    public void setShield_And_Settings(String shield_And_Settings) {
        this.shield_And_Settings = shield_And_Settings;
    }

    public MobileEye0x760Protocal() {
    }

    public MobileEye0x760Protocal(String id, String high_Beam, String low_Beam, String wipers, String right_Signal, String left_Signal, String brakes, String wipers_Available, String low_Beam_Available, String high_Beam_Available, String right_Blink_Available, String left_Blink_Available, String brake_Available, String speed_Available, String speed, String shield_And_Settings) {
        this.id = id;
        this.high_Beam = high_Beam;
        this.low_Beam = low_Beam;
        this.wipers = wipers;
        this.right_Signal = right_Signal;
        this.left_Signal = left_Signal;
        this.brakes = brakes;
        this.wipers_Available = wipers_Available;
        this.low_Beam_Available = low_Beam_Available;
        this.high_Beam_Available = high_Beam_Available;
        this.right_Blink_Available = right_Blink_Available;
        this.left_Blink_Available = left_Blink_Available;
        this.brake_Available = brake_Available;
        this.speed_Available = speed_Available;
        this.speed = speed;
        this.shield_And_Settings = shield_And_Settings;
    }

    @Override
    public String toString() {
        return "MobileEye0x760Protocal{" +
                "id='" + id + '\'' +
                ", high_Beam='" + high_Beam + '\'' +
                ", low_Beam='" + low_Beam + '\'' +
                ", wipers='" + wipers + '\'' +
                ", right_Signa='" + right_Signal + '\'' +
                ", left_Signal='" + left_Signal + '\'' +
                ", brakes='" + brakes + '\'' +
                ", wipers_Available='" + wipers_Available + '\'' +
                ", low_Beam_Available='" + low_Beam_Available + '\'' +
                ", high_Beam_Available='" + high_Beam_Available + '\'' +
                ", right_Blink_Available='" + right_Blink_Available + '\'' +
                ", left_Blink_Available='" + left_Blink_Available + '\'' +
                ", brake_Available='" + brake_Available + '\'' +
                ", speed_Available='" + speed_Available + '\'' +
                ", speed='" + speed + '\'' +
                ", shield_And_Settings='" + shield_And_Settings + '\'' +
                '}';
    }
}
