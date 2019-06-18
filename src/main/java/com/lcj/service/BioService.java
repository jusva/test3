package com.lcj.service;

import io.netty.handler.codec.base64.Base64;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * BIO 单线程阻塞
 *
 */


public class BioService {

    public static void main(String[] args) {
       // byte[] encodeBase64 = Base64.encodeBase64(str.getBytes("UTF-8"));
        Base64 b ;
        try (ServerSocket serverSocket = new ServerSocket(8081)) {//监听8081端口
            System.out.println("BIOServer has started,listening on port:"+serverSocket.getLocalSocketAddress());
            while(true){
                Socket clientSocket  = serverSocket.accept();
                System.out.println("Connection form "+clientSocket.getRemoteSocketAddress());//获得客户端地址
                try(Scanner input = new Scanner(clientSocket.getInputStream())){//扫描客户端的输入流
                    while (true){
                        String request = input.nextLine();//返回当前行
                        if("quit".equals(request)){
                            break;
                        }
                        System.out.println(String.format("From %s : %s",clientSocket.getRemoteSocketAddress(),request));
                        String responsn =  ".\n"+"From BIOServer Hello" + request + ".\n";
                        clientSocket.getOutputStream().write(responsn.getBytes());//把byte数组输出到客户端
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
