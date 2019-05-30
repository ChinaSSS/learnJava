package com.网络编程.即时聊天服务器;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cilent {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Socket socket = new Socket("localhost",12345);
            System.out.println("successful conection to server");
            //get the stream
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //login
            System.out.println("input username : ");
            String username = input.nextLine();
            Message msg = new Message(MessageType.TYPE_LOGIN,username,null,null);
            oos.writeObject(msg);
            //get the return message
            msg = (Message) ois.readObject();
            System.out.println("\t\t"+msg.getInfo());
            //open thead
            service.execute(new ReadThread(ois));
            //send message
            while(true){
                Message message = new Message();
                System.out.println("desti:");
                message.setTo(input.nextLine());
                System.out.println("info : ");
                message.setInfo(input.nextLine());
                message.setFrom(username);
                message.setType(MessageType.TYPE_SEND);
                oos.writeObject(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class ReadThread implements Runnable{

    private ObjectInputStream in;

    public ReadThread(ObjectInputStream in){
        this.in = in;
    }

    @Override
    public void run() {

        while(true){

            try {
                Message msg = (Message) in.readObject();
                System.out.println("["+msg.getFrom()+"]"+"say"+msg.getInfo());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
}
