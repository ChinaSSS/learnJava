package com.GUI学习;

import javax.swing.*;

public class TestGUI_01 {

    public static void main(String[] args) {
        //创建窗体
        JFrame jFrame = new JFrame("java");
        //设置不可变大小
        jFrame.setResizable(false);
        //创建一个面板
        JPanel jPanel = new JPanel();

        //设置tittle jFrame.setTittle()
        //设置窗体的坐标，与宽高
        jFrame.setBounds(300,200,300,500);

        //创建一个标签
        JLabel jLabel = new JLabel("账号");
        JLabel jLabel1 = new JLabel("密码");
        //创建一个文本框
        JTextField jTextField = new JTextField(20);

        //创建一个密码框
        JPasswordField jPasswordField = new JPasswordField(20);

        //添加一个button
        JButton jButton = new JButton("click me");

        //添加复选框
        JCheckBox jCheckBox = new JCheckBox("抽烟");
        JCheckBox jCheckBox1 = new JCheckBox("喝酒");
        JCheckBox jCheckBox2 = new JCheckBox("烫头");

        //单选框
        //添加组
        JRadioButton radioButton = new JRadioButton("男");
        JRadioButton radioButton1 = new JRadioButton("nv");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);
        group.add(radioButton1);

        //创建一个文本域
        JTextArea jTextArea = new JTextArea(5,20);
        //滚动条
        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        //菜单条
        JMenuBar bar = new JMenuBar();
        JMenu jMenu = new JMenu("语言");
        JMenuItem jMenuItem = new JMenuItem("java");
        JMenuItem jMenuItem1 = new JMenuItem("c");
        JMenuItem jMenuItem2 = new JMenuItem("ruby");
        bar.add(jMenu);

        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);

        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jLabel1);
        jPanel.add(jPasswordField);
        jPanel.add(jButton);
        jPanel.add(jCheckBox);
        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);
        jPanel.add(radioButton);
        jPanel.add(radioButton1);
        jPanel.add(jScrollPane);

        jFrame.setJMenuBar(bar);
        jFrame.add(jPanel);


        //设置窗体的显示状态 --> visible
        jFrame.setVisible(true);
        //设置点击关闭按钮
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
