package com.dell.yangzhou.MyselfStudy.IO;



import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UdpTest {
  @Test
    public void sender() throws IOException {
        DatagramSocket socket=new DatagramSocket();
        String s="我是udp发送";
        byte[] data=s.getBytes();
        InetAddress address=InetAddress.getLocalHost();
        DatagramPacket packet=new DatagramPacket(data,0,data.length,address,8888);
        socket.send(packet);

        socket.close();

    }

@Test
    public void service() throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] bytes=new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();

    }
}
