package com.NewIO;

import javax.sound.midi.SoundbankResource;
import java.nio.ByteBuffer;

public class NIODemo {

    public static void main(String[] args) {
        //创建一个字节缓冲区，大小1024byte
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // position limit capacity
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.put((byte) 10);
        buffer.put((byte) 20);

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //缓冲区反转
        buffer.flip();

        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //操作缓冲区数据
        while (buffer.hasRemaining()) {
            for (int i = 0; i < buffer.remaining(); i++) {
                System.out.println(buffer.get(i));
            }
        }
    }
}
