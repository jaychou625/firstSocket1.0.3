package com.pl.firstSocket.nettyWork;

import com.alibaba.fastjson.JSON;
import com.pl.firstSocket.bean.TcpInfo;
import com.pl.firstSocket.bean.UltrasonicRadarProtocal;
import com.pl.firstSocket.service.MobileEyeProtocalService;
import com.pl.firstSocket.service.RadarProtocalService;
import com.pl.firstSocket.service.TcpService;
import com.pl.firstSocket.service.impl.MobileEyeProtocalServiceImpl;
import com.pl.firstSocket.service.impl.RadarProtocalServiceImpl;
import com.pl.firstSocket.service.impl.TcpServiceImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TcpServerHandler extends ChannelInboundHandlerAdapter {
    private static long oldTime = new Date().getTime();
    private  static  boolean flag = false;
    TcpService tcpService = new TcpServiceImpl();
    Map<String, String> map = new HashMap<String,String>();
    UltrasonicRadarProtocal ultrasonicRadarProtocal = null;
    Object obj = null;
    String messageId = "";
    //收到数据时调用
    @Override
    public  void channelRead(ChannelHandlerContext ctx, Object  msg) throws Exception {
        try {
            ByteBuf in = (ByteBuf)msg;
            int readableBytes = in.readableBytes();
            byte[] bytes =new byte[readableBytes];
            in.readBytes(bytes);
            System.out.println(new String(bytes));
            //System.out.print(in.toString(CharsetUtil.UTF_8));
            System.out.println("服务端接受的消息 : " + new String(bytes));
            todoConnection(new String(bytes));
        }finally {
            // 抛弃收到的数据
            ReferenceCountUtil.release(msg);
        }
    }
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
    /*
     * 建立连接时，返回消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        System.out.println("连接的客户端ID:" + ctx.channel().id());
        ctx.writeAndFlush("client"+ InetAddress.getLocalHost().getHostName() + "success connected！ \n");
        System.out.println("connection");
        //StaticVar.ctxList.add(ctx);
        //StaticVar.chc = ctx;
        super.channelActive(ctx);
    }

    public void todoConnection(String entireInfo){
        //根据有效信息生成tcp数据对象，后续解析要用
        String infometion = entireInfo;
        TcpInfo tcpInfo = tcpService.getTcpInfo(infometion);
//            System.out.println(tcpInfo.toString());
        //判断消息类型，做不同处理，雷达协议，以及mobileEye协议，通过对象的infoType来判断，00：mobileEye，01：雷达
        if(tcpInfo.getInfoType().equals("00")){
            //处理mobileEye协议
            MobileEyeProtocalService mobileEyeProtocalService = new MobileEyeProtocalServiceImpl();
            obj = mobileEyeProtocalService.getMobileEyeInfo(tcpInfo);
            messageId = tcpInfo.getInfoContent().substring(2,4) + tcpInfo.getInfoContent().substring(0,2);
        }else if(tcpInfo.getInfoType().equals("01")){
            //处理雷达协议
            RadarProtocalService radarProtocalService = new RadarProtocalServiceImpl();
            ultrasonicRadarProtocal = radarProtocalService.getRadarInfo(tcpInfo);

        }else{
            //协议有误处理
        }

        //存储数据库操作
        //时间控制，1秒存储一次
        long nowTime = new Date().getTime();
        if(nowTime - oldTime >= 1000 || flag == false){
            oldTime = nowTime;
            flag = true;
            if(ultrasonicRadarProtocal != null){
                map.put(tcpInfo.getUnixTime(), JSON.toJSONString(ultrasonicRadarProtocal));
                Jedis jedis = new Jedis("127.0.0.1",6379);
                jedis.hmset("Radar-" + tcpInfo.getEquipmentNo(),map);
                jedis.close();
                ultrasonicRadarProtocal = null;
                map = null;
            }
            if(obj != null){
                map.put(tcpInfo.getUnixTime(),JSON.toJSONString(obj));
                Jedis jedis = new Jedis("127.0.0.1",6379);
                jedis.hmset("MobileEye-" + messageId + "-" + tcpInfo.getEquipmentNo(),map);
                jedis.close();
                obj = null;
            }
        }else{
            System.out.println("时间没到1秒");
        }


    }
}