package com.pl.firstSocket.service.impl;

import com.pl.firstSocket.bean.*;
import com.pl.firstSocket.service.MobileEyeProtocalService;
import com.pl.firstSocket.utils.TransitionUtil;

public class MobileEyeProtocalServiceImpl implements MobileEyeProtocalService {
    @Override
    public Object getMobileEyeInfo(TcpInfo tcpInfo) {
        Object obj = null;
        //获取协议消息号
        String protocalNo = tcpInfo.getInfoContent().substring(2,4) + tcpInfo.getInfoContent().substring(0,2);
        //根据协议消息号判断执行不同程序
        if(protocalNo.equals("0739")){
            obj = getMobileEye0x739ProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("073A")){
            obj = getMobileEye0x73AProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("073B")){
            obj = getMobileEye0x73BProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("0760")){
            obj = getMobileEye0x760ProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("076A")){
            obj = getMobileEye0x76AProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("0769")){
            obj = getMobileEye0x769ProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("0768")){
            obj = getMobileEye0x768ProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("0767")){
            obj = getMobileEye0x767ProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("0766")){
            obj = getMobileEye0x766ProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("0737")){
            obj = getMobileEye0x737ProtocalInfo(tcpInfo);
        }else if(protocalNo.equals("0669")){
            obj = getMobileEye0x669ProtocalInfo(tcpInfo);
        }
        return obj;
    }

    /**
     * 消息ID:0739执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x739Protocal getMobileEye0x739ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x739Protocal mobileEye0x739Protocal = new MobileEye0x739Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x739Protocal.setId(tcpInfo.getUnixTime());
        //障碍物编号 Obstacle_ID,16进制转换10进制即可
        String obstacleId = String.valueOf(Integer.parseInt(content.substring(0,2),16));
        mobileEye0x739Protocal.setObstacle_ID(obstacleId);
        //障碍物位置x  Obstacle_Pos_X,复合字节，调用第二字节和第三字节的低4位，无符号数
        String obstaclePosX = TransitionUtil.hexString2binaryString(content.substring(4,6)) + TransitionUtil.hexString2binaryString(content.substring(2,4));
        obstaclePosX = obstaclePosX.substring(4);
        obstaclePosX = Integer.valueOf(obstaclePosX,2).toString();
        double temp = Double.parseDouble(obstaclePosX) *  0.0625;
        obstaclePosX = String.valueOf(temp) + "米";
        mobileEye0x739Protocal.setObstacle_Pos_X(obstaclePosX);
        //障碍物位置 Y  Obstacle_Pos_Y,有符号数
        String obstaclePosY = TransitionUtil.hexString2binaryString(content.substring(8,10)) + TransitionUtil.hexString2binaryString(content.substring(6,8));
        obstaclePosY = obstaclePosY.substring(6);
        obstaclePosY = TransitionUtil.binaryString2hexString(obstaclePosY);
        obstaclePosY = TransitionUtil.hex2Dec(obstaclePosY);
        temp = Double.parseDouble(obstaclePosY) *  0.0625;
        obstaclePosY = String.valueOf(temp) + "米";
        mobileEye0x739Protocal.setOstacle_Pos_Y(obstaclePosY);
        //障碍物释放速度x Obstacle_Rel_Vel_X 有符号数
        String obstacleRelVelX = TransitionUtil.hexString2binaryString(content.substring(12,14)) + TransitionUtil.hexString2binaryString(content.substring(10,12));
        obstacleRelVelX = obstacleRelVelX.substring(4);
        obstacleRelVelX = TransitionUtil.binaryString2hexString(obstacleRelVelX);
        obstacleRelVelX = TransitionUtil.hex2Dec(obstacleRelVelX);
        temp = Double.parseDouble(obstacleRelVelX) *  0.0625;
        obstacleRelVelX = String.valueOf(temp) + "米/秒";
        mobileEye0x739Protocal.setObstacle_Rel_Vel_X(obstacleRelVelX);
        //障碍物类型  Obstacle_Type 无符号
        String obstacleType = TransitionUtil.hexString2binaryString(content.substring(12,14));
        obstacleType = obstacleType.substring(1,4);
        switch (obstacleType){
            case "000":
                obstacleType = "Vehicle";
                break;
            case "001":
                obstacleType = "Truck";
                break;
            case "010":
                obstacleType = "Bike";
                break;
            case "011":
                obstacleType = "Ped";
                break;
            case "100":
                obstacleType = "Bicycle";
                break;
            case "101":
                obstacleType = "unused";
                break;
            case "110":
                obstacleType = "unused";
                break;
            case "111":
                obstacleType = "unused";
                break;
                default:
                    obstacleType = "unused";
                    break;
        }
        mobileEye0x739Protocal.setObstacle_Type(obstacleType);
        //障碍物状态  Obstacle_Status 无符号
        String obstacleStatus = TransitionUtil.hexString2binaryString(content.substring(14,16));
        obstacleStatus = obstacleStatus.substring(5);
        obstacleStatus = String.valueOf(Integer.parseInt(obstacleStatus,2));
        switch (obstacleStatus){
            case "0":
                obstacleStatus = "Undefined";
                break;
            case "1":
                obstacleStatus = "Standing";
                break;
            case "2":
                obstacleStatus = "Stopped";
                break;
            case "3":
                obstacleStatus = "Moving";
                break;
            case "4":
                obstacleStatus = "Oncoming";
                break;
            case "5":
                obstacleStatus = "Parked";
                break;
            case "6":
                obstacleStatus = "Unused";
                break;
                default:
                    obstacleStatus = "Unused";
                    break;
        }
        mobileEye0x739Protocal.setStatus(obstacleStatus);
        //障碍物制动灯  Obstacle_Brake_Lights 0:关闭，1：开启
        String obstacleBrakeLights = TransitionUtil.hexString2binaryString(content.substring(14,16));
        obstacleBrakeLights = obstacleBrakeLights.substring(4,5);
        if(obstacleBrakeLights.equals("0")){
            obstacleBrakeLights = "障碍制动灯关闭";
        }else if(obstacleBrakeLights.equals("1")){
            obstacleBrakeLights = "障碍制动灯关闭";
        }else{
            obstacleBrakeLights = "未知状况";
        }
        mobileEye0x739Protocal.setObstacle_Brake_Lights(obstacleBrakeLights);
        //切入和切出  Cut in and out 无符号数
        String cutInAndOut = TransitionUtil.hexString2binaryString(content.substring(8,10));
        cutInAndOut = cutInAndOut.substring(0,3);
        cutInAndOut = String.valueOf(Integer.parseInt(cutInAndOut,2));
        switch (cutInAndOut){
            case "0":
                cutInAndOut = "undefined";
                break;
            case "1":
                cutInAndOut = "in_host_lane";
                break;
            case "2":
                cutInAndOut = "out_host_lane";
                break;
            case "3":
                cutInAndOut = "cut_in";
                break;
            case "4":
                cutInAndOut = "cut_out";
                break;
                default:
                    cutInAndOut = "undefined";
                    break;
        }
        mobileEye0x739Protocal.setCutInAndOut(cutInAndOut);
        //闪光灯信息  Blinker Info 无符号数
        String blinkerInfo = TransitionUtil.hexString2binaryString(content.substring(8,10));
        blinkerInfo = blinkerInfo.substring(3,6);
        blinkerInfo = String.valueOf(Integer.parseInt(blinkerInfo,2));
        switch (blinkerInfo){
            case "0":
                blinkerInfo = "unavailable";
                break;
            case "1":
                blinkerInfo = "off";
                break;
            case "2":
                blinkerInfo = "left";
                break;
            case "3":
                blinkerInfo = "right";
                break;
            case "4":
                blinkerInfo = "both";
                break;
                default:
                    blinkerInfo = "unavailable";
                    break;
        }
        mobileEye0x739Protocal.setBlinker_Info(blinkerInfo);
        //障碍物时效（新/旧)Obstacle_Valid
        String obstacleValid = TransitionUtil.hexString2binaryString(content.substring(14,16));
        obstacleValid = obstacleValid.substring(0,2);
        obstacleValid = String.valueOf(Integer.parseInt(obstacleValid,2));
        if(obstacleValid.equals("1")){
            obstacleValid = "New valid";
        }else if(obstacleValid.equals("2")){
            obstacleValid = "Older valid";
        }else{
            obstacleValid = "unavailable";
        }
        mobileEye0x739Protocal.setObstacle_Valid(obstacleValid);
        return mobileEye0x739Protocal;
    }

    /**
     * 消息ID:073A执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x73AProtocal getMobileEye0x73AProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x73AProtocal mobileEye0x73AProtocal = new MobileEye0x73AProtocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x73AProtocal.setId(tcpInfo.getUnixTime());
        //障碍物长度 Obstacle_Length 无符号数
        String obstacleLength = content.substring(0,2);
        double temp = Integer.parseInt(obstacleLength,16);
        obstacleLength = String.valueOf(temp * 0.5) + "米";
        mobileEye0x73AProtocal.setObstacle_Length(obstacleLength);
        //障碍物宽度 Obstacle_Width 无符号数
        String obstacleWidth = content.substring(2,4);
        temp = Integer.parseInt(obstacleWidth,16);
        obstacleWidth = String.valueOf(temp * 0.5) + "米";
        mobileEye0x73AProtocal.setObstacle_Width(obstacleWidth);
        //障碍物年龄  Obstacle_Age 无符号数
        String obstacleAge = content.substring(4,6);
        obstacleAge = String.valueOf(Integer.parseInt(obstacleAge,16));
        mobileEye0x73AProtocal.setObstacle_Age(obstacleAge);
        //障碍车道 Obstacle_Lane 无符号数
        String obstacleLane = content.substring(6,8);
        obstacleLane = TransitionUtil.hexString2binaryString(obstacleLane);
        obstacleLane = obstacleLane.substring(6);
        obstacleLane = String.valueOf(Integer.parseInt(obstacleLane,2));
        switch (obstacleLane){
            case "0":{
                obstacleLane = "Not assigned";
                break;
            }
            case "1":{
                obstacleLane = "Ego lane";
                break;
            }
            case "2":{
                obstacleLane = "Next lane";
                break;
            }
            case "3":{
                obstacleLane = "Invalid signa";
                break;
            }
        }
        mobileEye0x73AProtocal.setObstacle_Lane(obstacleLane);
        //CIPV标志  CIPV_Flag 无符号数
        String cipFlag = content.substring(6,8);
        cipFlag = TransitionUtil.hexString2binaryString(cipFlag);
        cipFlag = cipFlag.substring(5,6);
        if(cipFlag.equals("0")){
            cipFlag = "Not CIPV";
        }else if(cipFlag.equals("1")){
            cipFlag = "CIPV";
        }
        mobileEye0x73AProtocal.setcIPV_Flag(cipFlag);
        //雷达位置x  Radar_Pos_X 无符号数
        String radarPosX = TransitionUtil.hexString2binaryString(content.substring(8,10)) + TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(0,4);
        temp = Integer.parseInt(radarPosX,2) * 0.0625;
        radarPosX = String.valueOf(temp) + "米";
        mobileEye0x73AProtocal.setRadar_Pos_X(radarPosX);
        //雷达水平x   Radar_Vel_X 有符号数
        String radarVelX = TransitionUtil.hexString2binaryString(content.substring(12,14)).substring(4) + TransitionUtil.hexString2binaryString(content.substring(10,12));
        radarVelX = TransitionUtil.binaryString2hexString(radarVelX);
        temp = Double.parseDouble(TransitionUtil.hex2Dec(radarVelX)) * 0.0625;
        radarVelX = String.valueOf(temp) + "米/秒";
        mobileEye0x73AProtocal.setRadar_Vel_X(radarVelX);
        //雷达匹配置信度  Radar_Match_Confidence 无符号数
        String radarMatchConfidence = TransitionUtil.hexString2binaryString(content.substring(12,14)).substring(1,4);
        radarMatchConfidence = String.valueOf(Integer.parseInt(radarMatchConfidence,2));
        switch (radarMatchConfidence){
            case "0":
                radarMatchConfidence = "No match";
                break;
            case "1":
                radarMatchConfidence = "Multi match";
                break;
            case "2":
                radarMatchConfidence = "middle confidence match";
                break;
            case "3":
                radarMatchConfidence = "middle confidence match";
                break;
            case "4":
                radarMatchConfidence = "middle confidence match";
                break;
            case "5":
                radarMatchConfidence = "high confidence match";
                break;
                default:
                    radarMatchConfidence = "No match";
                    break;
        }
        mobileEye0x73AProtocal.setRadar_Match_Confidence(radarMatchConfidence);
        //匹配的雷达_ID  Matched_Radar_ID 无符号数
        String matchedRadarId = TransitionUtil.hexString2binaryString(content.substring(14,16)).substring(1);
        matchedRadarId = TransitionUtil.binaryString2hexString(matchedRadarId);
        matchedRadarId = String.valueOf(Integer.parseInt(matchedRadarId,16));
        mobileEye0x73AProtocal.setMatched_Radar_ID(matchedRadarId);

        return  mobileEye0x73AProtocal;
    }

    /**
     * 消息ID:073B执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x73BProtocal getMobileEye0x73BProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x73BProtocal mobileEye0x73BProtocal = new MobileEye0x73BProtocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x73BProtocal.setId(tcpInfo.getUnixTime());
        //障碍物角速率  Obstacle_Angle_Rate 有符号数
        String obstacleAngleRate = content.substring(2,4) + content.substring(0,2);
        obstacleAngleRate = String.valueOf(Double.parseDouble(TransitionUtil.hex2Dec(obstacleAngleRate)) * 0.01) + "度/秒";
        mobileEye0x73BProtocal.setObstacle_Angle_Rate(obstacleAngleRate);
        //障碍物比例变化 Obstacle_Scale_Change 有符号数
        String obstacle_Scale_Change = content.substring(6,8) + content.substring(4,6);
        obstacle_Scale_Change = String.valueOf(Double.parseDouble(TransitionUtil.hex2Dec(obstacle_Scale_Change)) * 0.0002) + "pix/秒";
        //对象加速度x    Object_Accel_X 有符号数
        String object_Accel_X = TransitionUtil.hexString2binaryString(content.substring(10,12)).substring(6) + TransitionUtil.hexString2binaryString(content.substring(8,10));
        object_Accel_X = TransitionUtil.binaryString2hexString(object_Accel_X);
        double temp = Double.parseDouble(TransitionUtil.hex2Dec(object_Accel_X));
        object_Accel_X = String.valueOf(temp * 0.03) + "米/秒";
        mobileEye0x73BProtocal.setObject_Accel_X(object_Accel_X);
        //障碍物更换（bool） Obstacle_Replaced
        String obstacle_Replaced = TransitionUtil.hexString2binaryString(content.substring(10,12)).substring(3,4);
        if(obstacle_Replaced.equals("0")){
            obstacle_Replaced = "Not replaced in this frame";
        }else if(obstacle_Replaced.equals("1")){
            obstacle_Replaced = "Replace in this frame";
        }
        mobileEye0x73BProtocal.setObstacle_Replaced(obstacle_Replaced);
        //障碍物角度（角度值） Obstacle_Angle 有符号数
        String obstacle_Angle = content.substring(14,16) + content.substring(12,14);
        obstacle_Angle = TransitionUtil.hex2Dec(obstacle_Angle);
        temp = Double.parseDouble(obstacle_Angle) * 0.01;
        obstacle_Angle = String.valueOf(temp) + "度";
        mobileEye0x73BProtocal.setObstacle_Angle(obstacle_Angle);

        return mobileEye0x73BProtocal;

    }

    /**
     * 消息ID:0760执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x760Protocal getMobileEye0x760ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x760Protocal mobileEye0x760Protocal = new MobileEye0x760Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x760Protocal.setId(tcpInfo.getUnixTime());
        //远光灯 High_Beam
        String highBeam = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(2,3);
        if(highBeam.equals("0")){
            highBeam = "远光灯关闭";
        }else if(highBeam.equals("1")){
            highBeam = "远光灯开启";
        }
        mobileEye0x760Protocal.setHigh_Beam(highBeam);
        //近光灯 Low_Beam
        String lowBeam = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(3,4);
        if(lowBeam.equals("0")){
            lowBeam = "近光灯关闭";
        }else if(lowBeam.equals("1")){
            lowBeam = "近光灯开启";
        }
        mobileEye0x760Protocal.setLow_Beam(lowBeam);
        //雨刷 Wipers
        String wipers = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(4,5);
        if(wipers.equals("0")){
            wipers = "雨刮器关闭";
        }else if(wipers.equals("1")){
            wipers = "雨刮器开启";
        }
        mobileEye0x760Protocal.setWipers(wipers);
        //右转灯 Right_Signal
        String rightSignal = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(5,6);
        if(rightSignal.equals("0")){
            rightSignal = "右转灯关闭";
        }else if(rightSignal.equals("1")){
            rightSignal = "右转灯开启";
        }
        mobileEye0x760Protocal.setRight_Signal(rightSignal);
        //左转灯 Left_Signal
        String leftSignal = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(6,7);
        if(leftSignal.equals("0")){
            leftSignal = "左转灯关闭";
        }else if(leftSignal.equals("1")){
            leftSignal = "左转灯开启";
        }
        mobileEye0x760Protocal.setLeft_Signal(leftSignal);
        //刹车信号 Brakes
        String brakes = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(7,8);
        if(brakes.equals("0")){
            brakes = "刹车灯关闭";
        }else if(brakes.equals("1")){
            brakes = "刹车灯开启";
        }
        mobileEye0x760Protocal.setBrakes(brakes);
        //雨刷有效位 Wipers_Available
        String wipersAvailable = TransitionUtil.hexString2binaryString(content.substring(2,4)).substring(4,5);
        //意义不明，直接存0，1
        mobileEye0x760Protocal.setWipers_Available(wipersAvailable);
        //近光灯有效位 Low_Beam_Available
        String lowBeamAvailable = TransitionUtil.hexString2binaryString(content.substring(2,4)).substring(3,4);
        //意义不明，直接存0，1
        mobileEye0x760Protocal.setLow_Beam_Available(lowBeamAvailable);
        //远光灯有效位  High_Beam_Available
        String highBeamAvailable = TransitionUtil.hexString2binaryString(content.substring(2,4)).substring(2,3);
        //意义不明，直接存0，1
        mobileEye0x760Protocal.setHigh_Beam_Available(highBeamAvailable);
        //右转灯有效位 Right_Blink_Available
        String rightBlinkAvailable = TransitionUtil.hexString2binaryString(content.substring(2,4)).substring(5,6);
        //意义不明，直接存0，1
        mobileEye0x760Protocal.setRight_Blink_Available(rightBlinkAvailable);
        //左转灯有效位 Left_Blink_Available
        String leftBlinkAvailable = TransitionUtil.hexString2binaryString(content.substring(2,4)).substring(6,7);
        //意义不明，直接存0，1
        mobileEye0x760Protocal.setLeft_Blink_Available(leftBlinkAvailable);
        //刹车信号有效位 Brake_available
        String brakeAvailable = TransitionUtil.hexString2binaryString(content.substring(2,4)).substring(7,8);
        //意义不明，直接存0，1
        mobileEye0x760Protocal.setBrake_Available(brakeAvailable);
        //速度有效位 Speed_Available
        String speedAvailable = TransitionUtil.hexString2binaryString(content.substring(2,4)).substring(0,1);
        //意义不明，直接存0，1
        mobileEye0x760Protocal.setSpeed_Available(speedAvailable);
        //速度 (Km/h) Speed 无符号数
        String speed = content.substring(4,6);
        speed = String.valueOf(Integer.parseInt(speed,16)) + "公里/小时";
        mobileEye0x760Protocal.setSpeed(speed);
        //屏蔽+设置 Shield_And_Settings
        String shieldAndSettings = TransitionUtil.hexString2binaryString(content.substring(14,16)).substring(2);
        //意义不明，直接存bit
        mobileEye0x760Protocal.setShield_And_Settings(shieldAndSettings);



        return mobileEye0x760Protocal;
    }

    /**
     * 消息ID:076A执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x76AProtocal getMobileEye0x76AProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x76AProtocal mobileEye0x76AProtocal = new MobileEye0x76AProtocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x76AProtocal.setId(tcpInfo.getUnixTime());
        //参考点1的位置 pointOnePosition 无符号数
        String pointOnePosition = content.substring(2,4) + content.substring(0,2);
        double temp = Integer.parseInt(pointOnePosition,16) - Integer.parseInt("07FFF",16);
        temp = temp / 256;
        pointOnePosition = String.valueOf(temp) + "米";
        mobileEye0x76AProtocal.setPointOnePosition(pointOnePosition);
        //参考点1的距离 pointOneDistance 无符号数
        String pointOneDistance = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(1) + TransitionUtil.hexString2binaryString(content.substring(4,6));
        temp = Integer.parseInt(pointOneDistance,2) /256;
        pointOneDistance = String.valueOf(temp) + "米";
        mobileEye0x76AProtocal.setPointOneDistance(pointOneDistance);
        //参考点1的有效位 pointOneAvailable;
        String pointOneAvailable = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(0,1);
        if(pointOneAvailable.equals("0")){
            pointOneAvailable = "无效";
        }else if(pointOneAvailable.equals("1")){
            pointOneAvailable = "有效";
        }
        mobileEye0x76AProtocal.setPointOneAvailable(pointOneAvailable);
        //参考点2的位置 pointTwoPosition 无符号数
        String pointTwoPosition = content.substring(10,12) + content.substring(8,10);
        temp = Integer.parseInt(pointTwoPosition,16) - Integer.parseInt("07FFF",16);
        temp = temp / 256;
        pointTwoPosition = String.valueOf(temp) + "米";
        mobileEye0x76AProtocal.setPointTwoPosition(pointTwoPosition);
        //参考点2的距离 pointTwoDistance 无符号数
        String pointTwoDistance = TransitionUtil.hexString2binaryString(content.substring(14,16)).substring(1) + TransitionUtil.hexString2binaryString(content.substring(12,14));
        temp = Integer.parseInt(pointTwoDistance,2) /256;
        pointTwoDistance = String.valueOf(temp) + "米";
        mobileEye0x76AProtocal.setPointTwoDistance(pointTwoDistance);
        //参考点2的有效位 pointTwoAvailable;
        String pointTwoAvailable = TransitionUtil.hexString2binaryString(content.substring(14,16)).substring(0,1);
        if(pointTwoAvailable.equals("0")){
            pointTwoAvailable = "无效";
        }else if(pointTwoAvailable.equals("1")){
            pointTwoAvailable = "有效";
        }
        mobileEye0x76AProtocal.setPointTwoAvailable(pointTwoAvailable);

        return mobileEye0x76AProtocal;
    }

    /**
     * 消息ID:0769执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x769Protocal getMobileEye0x769ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x769Protocal mobileEye0x769Protocal = new MobileEye0x769Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x769Protocal.setId(tcpInfo.getUnixTime());
        //偏航角 Heading_Angle_Parameter C1 无符号数
        String headingAngleParameter = content.substring(2,4) + content.substring(0,2);
        double temp = Integer.parseInt(headingAngleParameter,16) - Integer.parseInt("07FFF",16);
        temp = temp /1024;
        headingAngleParameter = String.valueOf(temp) + " radians";
        mobileEye0x769Protocal.setHeading_Angle_Parameter(headingAngleParameter);
        //可见范围 View_Range 无符号数
        String viewRange = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(1) + TransitionUtil.hexString2binaryString(content.substring(4,6));
        temp = Integer.parseInt(viewRange,2) /256;
        viewRange = String.valueOf(temp) + "米";
        mobileEye0x769Protocal.setView_Range(viewRange);
        //可见范围有效性 View_Range_Availability
        String viewRangeAvailability = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(0,1);
        if(viewRangeAvailability.equals("0")){
            viewRangeAvailability = "无效";
        }else if(viewRangeAvailability.equals("1")){
            viewRangeAvailability = "有效";
        }
        mobileEye0x769Protocal.setView_Range_Availability(viewRangeAvailability);

        return mobileEye0x769Protocal;
    }

    /**
     * 消息ID:0768执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x768Protocal getMobileEye0x768ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x768Protocal mobileEye0x768Protocal = new MobileEye0x768Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x768Protocal.setId(tcpInfo.getUnixTime());
        //车道类型 Lane_Type
        String laneType = String.valueOf(Integer.parseInt(content.substring(1,2),16));
        switch (laneType){
            case "0":
                laneType = "dashed";
                break;
            case "1":
                laneType = "solid";
                break;
            case "2":
                laneType = "undecided";
                break;
            case "3":
                laneType = " road edge";
                break;
            case "4":
                laneType = "double lane mark";
                break;
            case "5":
                laneType = "Botts' dots";
                break;
            case "6":
                laneType = "invalid";
                break;
                default:
                    laneType = "invalid";
                    break;
        }
        mobileEye0x768Protocal.setLane_Type(laneType);
        //道路质量 Quality
        String quality = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(2,4);
        quality = String.valueOf(Integer.parseInt(quality,2));
        switch (quality){
            case "0":
            case "1":
                quality = "low quality";
                break;
            case "2":
            case "3":
                quality = "high quality";
                break;
                default:
                    quality = "invalid";
        }
        mobileEye0x768Protocal.setQuality(quality);
        //Model_Degree
        String modelDegree = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(0,2);
        modelDegree = String.valueOf(Integer.parseInt(modelDegree,2));
        switch (modelDegree){
            case "1":
                modelDegree = "linear model";
                break;
            case "2":
                modelDegree = "Parabolic model";
                break;
            case "3":
                modelDegree = " 3-degree model";
                break;
                default:
                    modelDegree = "invalid";
                    break;
        }
        mobileEye0x768Protocal.setModel_Degree(modelDegree);
        //位置参数C0 Position_Parameter C0 有符号数
        String positionParameter = content.substring(4,6) + content.substring(2,4);
        positionParameter = TransitionUtil.hex2Dec(positionParameter);
        double temp = Double.parseDouble(positionParameter) / 256;
        positionParameter = String.valueOf(positionParameter) + "米";
        mobileEye0x768Protocal.setPosition_Parameter(positionParameter);
        //曲率参数C2 Curvature_Parameter C2 无符号数
        String curvatureParameter = content.substring(8,10) + content.substring(6,8);
        temp = Double.parseDouble(String.valueOf((Integer.parseInt(curvatureParameter,16) - Integer.parseInt("07FFF",16)))) / 1024 / 1000;
        curvatureParameter = String.valueOf(temp) + "n/a";
        mobileEye0x768Protocal.setCurvature_Parameter(curvatureParameter);
        //曲率导数参数C3 Curvature_Derivative_Parameter C3 无符号数
        String curvatureDerivativeParameter = content.substring(12,14) + content.substring(10,12);
        System.out.println((1<<28));
        temp = Double.parseDouble(String.valueOf((Integer.parseInt(curvatureDerivativeParameter,16) - Integer.parseInt("07FFF",16)))) / (1<<28);
        curvatureDerivativeParameter = String.valueOf(temp) + "n/a";
        mobileEye0x768Protocal.setCurvature_Derivative_Parameter(curvatureDerivativeParameter);
        //标记宽度 Width_Right_Marking
        String widthRightMarking = content.substring(14,16);
        temp = Integer.parseInt(widthRightMarking,16) * 0.01;
        widthRightMarking = String.valueOf(temp) + "米";
        mobileEye0x768Protocal.setWidth_Right_Marking(widthRightMarking);

        return mobileEye0x768Protocal;
    }

    /**
     * 消息ID:0767执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x767Protocal getMobileEye0x767ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x767Protocal mobileEye0x767Protocal = new MobileEye0x767Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x767Protocal.setId(tcpInfo.getUnixTime());
        //前进方向改变角 direction_Angle_Parameter  C1 无符号数
        String directionAngleParameter = content.substring(2,4) + content.substring(0,2);
        double temp = Double.parseDouble(String.valueOf(Integer.parseInt(directionAngleParameter,16) - Integer.parseInt("07FFF",16)))/ 1024;
        directionAngleParameter = String.valueOf(temp) + " radians";
        mobileEye0x767Protocal.setDirection_Angle_Parameter(directionAngleParameter);
        //视野范围 view_Range 无符号数
        String viewRange = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(1) + TransitionUtil.hexString2binaryString(content.substring(4,6));
        temp = Integer.parseInt(viewRange,2) /256;
        viewRange = String.valueOf(temp) + "米";
        mobileEye0x767Protocal.setView_Range(viewRange);
        //视野范围有效位 view_Range_Available
        String viewRangeAvailability = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(0,1);
        if(viewRangeAvailability.equals("0")){
            viewRangeAvailability = "无效";
        }else if(viewRangeAvailability.equals("1")){
            viewRangeAvailability = "有效";
        }
        System.out.println(viewRangeAvailability);
        mobileEye0x767Protocal.setView_Range_Available(viewRangeAvailability);
        return mobileEye0x767Protocal;
    }

    /**
     * 消息ID:0766执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x766Protocal getMobileEye0x766ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x766Protocal mobileEye0x766Protocal = new MobileEye0x766Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x766Protocal.setId(tcpInfo.getUnixTime());
        //车道类型 Lane_Type
        String laneType = String.valueOf(Integer.parseInt(content.substring(1,2),16));
        switch (laneType){
            case "0":
                laneType = "dashed";
                break;
            case "1":
                laneType = "solid";
                break;
            case "2":
                laneType = "undecided";
                break;
            case "3":
                laneType = " road edge";
                break;
            case "4":
                laneType = "double lane mark";
                break;
            case "5":
                laneType = "Botts' dots";
                break;
            case "6":
                laneType = "invalid";
                break;
            default:
                laneType = "invalid";
                break;
        }
        mobileEye0x766Protocal.setLane_Type(laneType);
        //道路质量 Quality
        String quality = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(2,4);
        quality = String.valueOf(Integer.parseInt(quality,2));
        switch (quality){
            case "0":
            case "1":
                quality = "low quality";
                break;
            case "2":
            case "3":
                quality = "high quality";
                break;
            default:
                quality = "invalid";
        }
        mobileEye0x766Protocal.setQuality(quality);
        //Model_Degree
        String modelDegree = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(0,2);
        modelDegree = String.valueOf(Integer.parseInt(modelDegree,2));
        switch (modelDegree){
            case "1":
                modelDegree = "linear model";
                break;
            case "2":
                modelDegree = "Parabolic model";
                break;
            case "3":
                modelDegree = " 3-degree model";
                break;
            default:
                modelDegree = "invalid";
                break;
        }
        mobileEye0x766Protocal.setModel_Degree(modelDegree);
        //位置参数C0 Position_Parameter C0 有符号数
        String positionParameter = content.substring(4,6) + content.substring(2,4);
        positionParameter = TransitionUtil.hex2Dec(positionParameter);
        double temp = Double.parseDouble(positionParameter) / 256;
        positionParameter = String.valueOf(positionParameter) + "米";
        mobileEye0x766Protocal.setPosition_Parameter(positionParameter);
        //曲率参数C2 Curvature_Parameter C2 无符号数
        String curvatureParameter = content.substring(8,10) + content.substring(6,8);
        temp = Double.parseDouble(String.valueOf((Integer.parseInt(curvatureParameter,16) - Integer.parseInt("07FFF",16)))) / 1024 / 1000;
        curvatureParameter = String.valueOf(temp) + "n/a";
        mobileEye0x766Protocal.setCurvature_Parameter(curvatureParameter);
        //曲率导数参数C3 Curvature_Derivative_Parameter C3 无符号数
        String curvatureDerivativeParameter = content.substring(12,14) + content.substring(10,12);
        System.out.println((1<<28));
        temp = Double.parseDouble(String.valueOf((Integer.parseInt(curvatureDerivativeParameter,16) - Integer.parseInt("07FFF",16)))) / (1<<28);
        curvatureDerivativeParameter = String.valueOf(temp) + "n/a";
        mobileEye0x766Protocal.setCurvature_Derivative_Parameter(curvatureDerivativeParameter);
        //标记宽度 Width_Left_Marking
        String widthLeftMarking = content.substring(14,16);
        temp = Integer.parseInt(widthLeftMarking,16) * 0.01;
        widthLeftMarking = String.valueOf(temp) + "米";
        mobileEye0x766Protocal.setWidth_Left_Marking(widthLeftMarking);

        return mobileEye0x766Protocal;
    }

    /**
     * 消息ID:0737执行程序
     * @param tcpInfo
     * @return
     */
    private static MobileEye0x737Protocal getMobileEye0x737ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x737Protocal mobileEye0x737Protocal = new MobileEye0x737Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x737Protocal.setId(tcpInfo.getUnixTime());
        //车道曲率 Lane_Curvature 有符号数
        String laneCurvature = content.substring(2,4) + content.substring(0,2);
        double temp = Double.parseDouble(TransitionUtil.hex2Dec(laneCurvature));
        temp = temp * 3.81 * (1.0 / (10 * 10 * 10 * 10 * 10 * 10));
        laneCurvature = String.valueOf(temp);
        mobileEye0x737Protocal.setLane_Curvature(laneCurvature);
        //车道航向 Lane_Heading 有符号数
        String laneHeading = content.substring(7,8) + content.substring(4,6);
        temp = Double.parseDouble(TransitionUtil.hex2Dec(laneHeading)) * 0.0005;
        laneHeading = String.valueOf(temp);
        mobileEye0x737Protocal.setLane_Heading(laneHeading);
        //CA–施工区域  CA_Construction_Area
        String cAConstructionArea = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(3,4);
        System.out.println(cAConstructionArea);
        mobileEye0x737Protocal.setcA_Construction_Area(cAConstructionArea);
        //俯仰角  Pitch_Angle 无符号数
        String pitchAngle = content.substring(14,16) + content.substring(12,14);
        temp = ((double)(Integer.parseInt(pitchAngle,16) - Integer.parseInt("07FFF",16))) / 1024 / 512;
        pitchAngle = String.valueOf(temp);
        mobileEye0x737Protocal.setPitch_Angle(pitchAngle);
        //偏航角 Yaw_Angle
        String yaw_Angle = content.substring(10,12) + content.substring(8,10);
        temp = ((double)(Integer.parseInt(yaw_Angle,16) - Integer.parseInt("07FFF",16))) / 1024;
        yaw_Angle = String.valueOf(temp);
        mobileEye0x737Protocal.setYaw_Angle(yaw_Angle);
        //右LDW可用性 Right_LDW_Availability
        String rightLDWAvailability = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(2,3);
        mobileEye0x737Protocal.setRight_LDW_Availability(rightLDWAvailability);
        //左LDW可用性 Left_LDW_Availability
        String leftLDWAvailability = TransitionUtil.hexString2binaryString(content.substring(6,8)).substring(1,2);
        mobileEye0x737Protocal.setLeft_LDW_Availability(leftLDWAvailability);
        return mobileEye0x737Protocal;
    }

    private static MobileEye0x669Protocal getMobileEye0x669ProtocalInfo(TcpInfo tcpInfo){
        MobileEye0x669Protocal mobileEye0x669Protocal = new MobileEye0x669Protocal();
        String content = tcpInfo.getInfoContent().substring(4);
        //设置ID unix时间戳
        mobileEye0x669Protocal.setId(tcpInfo.getUnixTime());
        //到左边线的距离   Distance_To_Left_Lane 有符号数
        String distanceToLeftLane = content.substring(4,6) + content.substring(2,3);
        distanceToLeftLane = TransitionUtil.hex2Dec(distanceToLeftLane);
        double temp = Double.parseDouble(distanceToLeftLane) * 0.02;
        distanceToLeftLane = String.valueOf(temp) + "米";
        mobileEye0x669Protocal.setDistance_To_Left_Lane(distanceToLeftLane);
        //左边道路标线的可识别等级 Lane_Confidence_Left
        String laneConfidenceLeft = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(6,8);
        laneConfidenceLeft = String.valueOf(Integer.parseInt(laneConfidenceLeft,2));
        mobileEye0x669Protocal.setLane_Confidence_Left(laneConfidenceLeft);
        //左边LDW（车道偏离预警） 可用要求  LDW_Availability_Left
        String lDWAvailabilityLeft = TransitionUtil.hexString2binaryString(content.substring(0,2)).substring(5,6);
        mobileEye0x669Protocal.setlDW_Availability_Left(lDWAvailabilityLeft);
        //左边车道类型  Lane_Type_Left;
        String laneTypeLeft = String.valueOf(Integer.parseInt(content.substring(0,1),16));
        switch (laneTypeLeft){
            case "0":
                laneTypeLeft = "Dashed";
                break;
            case "1":
                laneTypeLeft = "Solid";
                break;
            case "2":
                laneTypeLeft = "None";
                break;
            case "3":
                laneTypeLeft = "Road Edge";
                break;
            case "4":
                laneTypeLeft = "Double Lane Mark";
                break;
            case "5":
                laneTypeLeft = "Bott’s Dots";
                break;
            case "6":
                laneTypeLeft = "Invalid";
                break;
                default:
                    laneTypeLeft = "Invalid";
                    break;
        }
        mobileEye0x669Protocal.setLane_Type_Left(laneTypeLeft);
        //到右边线的距离   Distance_To_Right_Lane 右符号数
        String distanceToRightLane = content.substring(12,14) + content.substring(10,11);
        distanceToRightLane = TransitionUtil.hex2Dec(distanceToRightLane);
        temp = Double.parseDouble(distanceToRightLane) * 0.02;
        distanceToRightLane = String.valueOf(temp) + "米";
        mobileEye0x669Protocal.setDistance_To_Right_Lane(distanceToRightLane);
        //右边道路标线的可识别等级 Lane_Confidence_Right
        String laneConfidenceRight = TransitionUtil.hexString2binaryString(content.substring(8,10)).substring(6,8);
        laneConfidenceRight = String.valueOf(Integer.parseInt(laneConfidenceRight,2));
        mobileEye0x669Protocal.setLane_Confidence_Right(laneConfidenceRight);
        //右边LDW（车道偏离预警） 可用要求  LDW_Availability_Right
        String lDWAvailabilityRight = TransitionUtil.hexString2binaryString(content.substring(8,10)).substring(5,6);
        mobileEye0x669Protocal.setLDW_Availability_Right(lDWAvailabilityRight);
        //右边车道类型  Lane_Type_Right;
        String laneTypeRight = String.valueOf(Integer.parseInt(content.substring(8,9),16));
        switch (laneTypeRight){
            case "0":
                laneTypeRight = "Dashed";
                break;
            case "1":
                laneTypeRight = "Solid";
                break;
            case "2":
                laneTypeRight = "None";
                break;
            case "3":
                laneTypeRight = "Road Edge";
                break;
            case "4":
                laneTypeRight = "Double Lane Mark";
                break;
            case "5":
                laneTypeRight = "Bott’s Dots";
                break;
            case "6":
                laneTypeRight = "Invalid";
                break;
            default:
                laneTypeRight = "Invalid";
                break;
        }
        mobileEye0x669Protocal.setLane_Type_Right(laneTypeRight);

        return mobileEye0x669Protocal;
    }
}
