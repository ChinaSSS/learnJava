package com.聊天;

import com.自定义异常与assert.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Vector<UserThread> vector = new Vector<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动.......");
            while (true){
                Socket accept = serverSocket.accept();
                UserThread userThread = new UserThread(accept,vector);
                service.execute(userThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class UserThread implements Runnable{

    private Socket socket;
    private String name;
    private Vector<UserThread> vector;
    private ObjectInputStream ois;
    private boolean flag = true;
    private ObjectOutputStream oos;

    public UserThread(Socket socket, Vector<UserThread> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this);
    }

    @Override
    public void run() {

        try {
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"已连接");
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());

            while (flag){
                Message msg = (Message) ois.readObject();
                int type = msg.getType();
                switch (type){
                    case MessageType.TYPE_LOGIN:
                        name = msg.getFrom();
                        msg.setInfo("欢饮你");
                        oos.writeObject(msg);
                        break;
                    case MessageType.TYPE_SEND:
                        String to = msg.getTo();
                        UserThread ut ;
                        int size = vector.size();
                        for(int i=0;i<size;i++){
                            ut =vector.get(i);
                            if(to.equals(ut.name)&&ut!=this){
                                ut.oos.writeObject(msg);
                                break;
                            }
                        }
                        break;
                        default:
                            break;
                }
            }
            oos.close();
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
