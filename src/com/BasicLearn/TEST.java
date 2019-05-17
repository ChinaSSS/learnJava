package com.BasicLearn;
/*
链表实现
功能： 增删改查，插入
 */
public class TEST {
    public static void main(String[] args) {
        NodeMannager mannager = new NodeMannager();
        mannager.add(3);
        mannager.add(5);
        mannager.insert(3,7);
        mannager.print();
    }
}


class NodeMannager{
    //根节点
    private Node root;

    public void add(int data){
        if(root == null){
            root = new Node(data);
        }else{
                root.addNote(data);
            }
        }
    public void remove(int data){
        if (root != null) {
            if(data == root.getData()){
                root = root.next;
            }else {
                root.removeNode(data);
            }
        }
    }
    public void update(int olddata , int newdata){
        if(root != null){
            if(root.getData() == olddata){
                root.setData(newdata);
            }else {
                root.updateNode(olddata,newdata);
            }
        }
    }
    public boolean search(int data){
        if (root != null) {
            if (root.getData() == data) {
                return true;
            }else {
                return root.searchNode(data);
            }
        }else return false;
    }
    public void print(){
        if(!(root==null)){
            System.out.println(root.getData()+"-->");
            root.print();
        }
    }
    public void insert(int head_data,int data){
        if(root != null){
            if(root.getData() == head_data){
                Node node = new Node(data);
                node.next = root.next;
                root.next = node;
            }else {
                root.insertNode(head_data,data);
            }
        }
    }

    private class Node{
        //数据
        private int data;

        public Node(int data){
            this.data = data;
        }
        //下一个节点
        private Node next;

        private void addNote(int data){
            if(this.next == null){
                this.next = new Node(data);
            }else{
                this.next.addNote(data);
            }
        }
        private void removeNode(int data){
            if(this.next != null){
                if(this.next.data == data){
                    this.next = this.next.next;
                }else {
                    this.next.removeNode(data);
                }
            }
        }
        private void updateNode(int olddata,int newdata){
            if(root.next != null){
                if(root.next.data == olddata){
                    root.next.data = newdata;
                }else {
                    root.next.updateNode(olddata,newdata);
                }
            }
        }
        //查找是否存在
        private boolean searchNode(int data){
            if(this.next != null){
                if(this.next.data == data){
                    return true;
                }else {
                    return this.next.searchNode(data);
                }
            }else {
                return false;
            }
        }
        private void print(){
            if(!(this.next==null)){
                System.out.println(this.next.data+"-->");
                this.next.print();
            }
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void insertNode(int head_data,int data){
            if(this.next != null){
                if(this.next.getData() == head_data){
                    Node node = new Node(data);
                    node.next = this.next.next;
                    this.next.next = node;
                }else {
                    this.next.insertNode(head_data,data);
                }
            }
        }
    }

}
