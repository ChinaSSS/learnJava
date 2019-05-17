package com.BasicLearn;

public class BinaryTreeDemo {

    private Node root;

    public void add(int data){
        if(root == null){
            root = new Node(data);
        }else{
            root.addNode(data);
        }
    }

    public void print_hou(){
        //按照后序输出
        if(root != null){
            root.printnode_hou();
        }
    }

    public void print_zhong(){
        if(root != null){
            root.printnode_zhong();
        }
    }

    public void print_qian(){
        if(root != null){
            root.printnode_qian();
        }
    }

    private class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public void addNode(int data){
            //制定规则，大叔左边，小数右边
            if(data > this.data){
                if(left == null){
                    left = new Node(data);
                }else {
                    left.addNode(data);
                }
            }else if(data < this.data){
                if(right == null){
                    right = new Node(data);
                }else {
                    right.addNode(data);
                }
            }
        }

        //后序输出
        public void printnode_hou(){
            if(left != null){
                left.printnode_hou();
            }
            if(right != null){
                right.printnode_hou();
            }
            System.out.print(this.data+"-->");
        }

        //中序输出
        public void printnode_zhong(){
            if(left != null){
                left.printnode_zhong();
            }
            System.out.print(this.data+"-->");
            if(right != null){
                right.printnode_zhong();
            }
        }

        //前序输出
        public void printnode_qian(){
            System.out.print(this.data+"-->");
            if(left != null){
                left.printnode_qian();
            }
            if(right !=null){
                right.printnode_qian();
            }
        }

    }

    public static void main(String[] args) {
        BinaryTreeDemo binaryTreeDemo = new BinaryTreeDemo();
        binaryTreeDemo.add(5);
        binaryTreeDemo.add(8);
        binaryTreeDemo.add(3);
        binaryTreeDemo.add(15);
        binaryTreeDemo.add(7);
        binaryTreeDemo.add(4);
        binaryTreeDemo.add(1);
        System.out.println("后序-------------\n");
        binaryTreeDemo.print_hou();
        System.out.println("\n中序-------------\n");
        binaryTreeDemo.print_zhong();
        System.out.println("\n前序--------------\n");
        binaryTreeDemo.print_qian();
    }

}
