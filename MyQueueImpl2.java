package com.bittch.Exception;

/**
 * 链式队列
 * @author CHAOQIWEN
 * @data 2019/7/17 8:49
 */
public class MyQueueImpl implements IQueue {
    class Node{
        private int data;
        private  Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private Node front;
    private Node rear;
    private int usedSize;

    public MyQueueImpl(){
        this.front=null;
        this.rear=null;
        this.usedSize=0;
    }



    @Override
    public boolean empty() {
        return this.usedSize==0;
    }

    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }

    @Override
    public int poll() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int a=this.front.data;
        this.front=this.front.next;
        this.usedSize--;
        return a;
    }

    @Override
    public void add(int item) {
        Node node=new Node(item);
        if(this.front==null){
            this.front=node;
            this.rear=node;
        }else {
            this.rear.next=node;
            this.rear=node;
        }
        this.usedSize++;

    }

    @Override
    public int size() {
        return this.usedSize;
    }

    public static void main(String[] args) {
        MyQueueImpl myQueue=new MyQueueImpl();
        myQueue.add(10);
        myQueue.add(120);
        myQueue.add(30);
        myQueue.add(40);
        myQueue.add(50);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.size());
    }
}
