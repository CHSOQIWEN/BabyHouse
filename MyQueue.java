package com.bittch.Exception;

/**
 * Auther:CHAOQIWEN
 */
public class MyQueue {
    private class Node{
        int value;
        Node next;
    }
    Node head;
    Node last;
    MyQueue(){
        this.head=this.last=null;
    }
    //入队列
    public void push(int v){
        //尾插
        Node node=new Node();
        node.value=v;
        node.next=null;
        if(this.head==null){
            this.head=this.last=null;
        }else {
            this.last.next=this.last=node;
        }


    }
    //出队列
    public int pop(){
        //头删
        int v=this.head.value;
        this.head=this.head.next;
        if(this.head==null){
            this.last=null;
        }
        return v;

    }
    //返回队首元素
    public int front(){
        return this.head.value;

    }
    //
    public int size(){
        return 0;

    }
    public Node isEmpty(){
        return this.head=null;

    }
}
