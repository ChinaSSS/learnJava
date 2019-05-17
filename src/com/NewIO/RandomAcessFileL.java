package com.NewIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAcessFileL {

    public static void main(String[] args) {
        try {

            RandomAccessFile Reader = new RandomAccessFile("D:\\test\\test\\zhang.txt","r");
            RandomAccessFile Writer = new RandomAccessFile("D:\\test\\test\\zhang3.txt","rw");

            //获取文件通道
            FileChannel Fin = Reader.getChannel();
            FileChannel Fout = Writer.getChannel();

            //获取缓冲区
            long size = Fin.size();//输入流的字节大小
            //输入流的缓冲区
            MappedByteBuffer inbuffer = Fin.map(FileChannel.MapMode.READ_ONLY,0,size);
            //输出流的缓冲区
            MappedByteBuffer outbuffer = Fout.map(FileChannel.MapMode.READ_WRITE,0,size);
            //通过文件通道来将缓冲区映射到内存，直接往缓冲区放东西就map到了内存

            for(int i=0;i<size;i++){
                outbuffer.put(inbuffer.get(i));
            }
            //关闭时会写入数据块
            Fin.close();
            Fout.close();
            System.out.println("复制成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
