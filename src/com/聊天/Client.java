package com.聊天;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Socket socket = new Socket("localhost",8888);
            System.out.println("服务器连接成功");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //
            System.out.println("username: ");
            String name = scanner.nextLine();
            Message msg = new Message(name,null,MessageType.TYPE_LOGIN,null);
            oos.writeObject(msg);
            msg = (Message) ois.readObject();
            System.out.println(msg.getInfo()+msg.getFrom());
            //
            service.execute(new ReadInfoThread(ois));
            //
            while (true){
                msg = new Message();
                System.out.println("to :");
                msg.setTo(scanner.nextLine());
                msg.setFrom(name);
                msg.setType(MessageType.TYPE_SEND);
                System.out.println("info");
                msg.setInfo(scanner.nextLine());
                oos.writeObject(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class ReadInfoThread implements  Runnable{

    private ObjectInputStream in;
    private boolean flag = true;

    public ReadInfoThread(ObjectInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {

            try {
        while (flag){
                Message msg = (Message) in.readObject();
                System.out.println(msg.getFrom()+" 说 "+msg.getInfo());
            }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
    }
}

