package com.通配符和正则.通配符;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {

    @Test
    public void test1(){
        Node<String> str = new Node<>("name");
        Node<Integer> inn = new Node<>(3);
//        inn = str
        Node.display(inn);
        Node.display(str);
    }

    @Test
    public void test2(){
        //定义一个交换位置的方法，使用于任何的数据类型数组
        Node<String>[] strList = new Node[]{new Node("1"),new Node("2"),new Node("3")};
        replace(strList,0,1);
        System.out.println(Arrays.toString(strList));
    }

    public void replace(Node<?>[] nodes,int i,int j){
        Node<?> temp = new Node<>();
        temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }

    @Test
    public void test3(){
        //嵌套
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"zhang");
        map.put(2,"wang");
        map.put(3,"jia");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry e: entries){
            System.out.println(e.getValue());
        }
    }

}

class Node<T> {

    private T data;
    public Node(){}

    public Node(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    //可以作用不同的对象
    public static void display(Node<?> a){
        System.out.println(a.toString());
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

