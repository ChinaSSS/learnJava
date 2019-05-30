package com.泛型;

public class Demo {

    Node<String> str = new Node<>("zhang");

}


//自定义泛型
class Node<T> {

    private T node;

    public Node(){}

    public Node(T node){
        this.node = node;
    }

    public void addNode(T node){
        this.node = node;
    }

    public T getNode(){
        return node;
    }

    //泛型只存在于编译期

}
