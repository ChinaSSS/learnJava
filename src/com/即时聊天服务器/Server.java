package com.即时聊天服务器;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        boolean server_flag = true;
        Vector<UserThread> vector = new Vector<>();
        //create thread pools
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            //create a server
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server Start Successful ...");
            while(server_flag){
                Socket socket = server.accept();
                service.execute(new UserThread(vector,socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class UserThread implements Runnable{


    private Socket socket;
    private String name;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean flag = true;
    private Vector<UserThread> vector;
    public UserThread(Vector<UserThread> vector,Socket socket){
        this.socket =socket;
        this.vector = vector;
        vector.add(this);
    }

    @Override
    public void run() {
        try {
            //get the stream
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            //print welcome infomation
            System.out.println("用户"+socket.getInetAddress().getHostAddress()+"已连接");
            //get the message
            while(flag) {
                Message msg = (Message) in.readObject();
                int type = msg.getType();
                switch (type) {
                    case MessageType.TYPE_SEND:
                        String to = msg.getTo();
                        int size = vector.size();
                        System.out.println("vector size : "+size);
                        int num = 0;
                        for(UserThread u : vector){
                            if(to.equals(u.name)&&u!=this){
                                u.out.writeObject(msg);
                                num ++;
                                break;
                            }
                        }
                        if(num == 0 ){
                            msg.setInfo("没有这个用户");
                            out.writeObject(msg);
                        }
                        break;
                    case MessageType.TYPE_LOGIN:
                        name = msg.getFrom();
                        msg.setInfo("欢迎登陆");
                        out.writeObject(msg);
                        break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
