package com.PlayGameBefore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFram extends JFrame {

    Image images = GameUtil.getImage("Image/one.jpg");

    //绘图，函数自动被调用
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color c= g.getColor();
        g.setColor(Color.BLUE);
        g.drawLine(100,100,300,300);
        g.drawRect(100,100,300,300);
        g.drawOval(100,100,300,300);
        g.fillRect(100,100,50,50);
        g.setFont(new Font("宋体",Font.BOLD,12));
        g.drawString("ironman",200,200);
        g.setColor(c);
        g.drawImage(images,250,250,null);
    }

    //初始化窗口界面
    public void launchFrame(){
        this.setTitle("小测试");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(500,100);

        //监听事件关闭的时候退出程序
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        MyGameFram myGameFram = new MyGameFram();
        myGameFram.launchFrame();
    }

}
