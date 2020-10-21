package com.dell.yangzhou.MyselfStudy.IO;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTest {
    public static void main(String[] args) {
        try {
            new TcpTest().Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void Client() throws IOException {
        InetAddress address=InetAddress.getByName("10.69.1.44");
        Socket socket=new Socket(address,8889);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream inputStream=new FileInputStream(new File("hey.txt"));
        byte[] bytes=new byte[5];
        int len;
        while ((len = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        socket.shutdownOutput();
        inputStream.close();
        outputStream.close();
        socket.close();



    }

    @org.junit.Test
    public void Server() throws IOException {
        System.out.println(InetAddress.getLocalHost());
        ServerSocket serverSocket=new ServerSocket(7777);
        Socket socket = serverSocket.accept();
        //InputStream inputStream = socket.getInputStream();
        System.out.println(socket.getLocalAddress());


    }


}
