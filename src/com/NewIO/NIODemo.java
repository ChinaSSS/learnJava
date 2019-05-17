package com.NewIO;

import java.nio.ByteBuffer;

public class NIODemo {

    //创建一个字节缓冲
    final public static ByteBuffer buffer = ByteBuffer.allocate(10);

    //往缓冲区里放入put和拿出get
    public static void main(String[] args) {
        show();
        insert();
        show();
        //缓冲区反转
        buffer.flip();
        show();
        if(buffer.hasRemaining()){
            for(int i=0;i<buffer.remaining();i++){
                System.out.println(buffer.get(i));
            }
        }

    }

    public static void show(){
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("----------------");
    }

    public static void insert(){
        buffer.put((byte) 10);
        buffer.put((byte) 11);
        buffer.put((byte) 12);
        buffer.put((byte) 13);
        buffer.put((byte) 14);
    }
}
