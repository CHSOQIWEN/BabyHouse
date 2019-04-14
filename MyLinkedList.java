package com.bittch.Exception;

/**
 * 、无头单向非循环链表实现
 * Auther:CHAOQIWEN
 */
public class MyLinkedList {
    public static class Node{
        public int value;
        public Node next;
        Node(int v){
            this.value=v;
        }

    }

    public static class Solution {
        public  Node head;

        //toucha
        public void addFirst(int v) {
            Node node = new Node(v);
            node.next = this.head;
            this.head = node;
        }

        //weicha
        public void addLast(int v) {
            Node node = new Node(v);
            Node last = this.head;
            node.next = null;
            if (this.head == null) {
                this.head = node;
            } else {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = node;

            }
        }

        //任意位置插入
        public boolean addindex(int index, int v) {
            Node cur = this.head;
            Node node = new Node(v);
            if(index==0){
                addFirst(v);
            }else {
                for (int i = 0; cur!=null&&i < index - 1; i++) {
                    cur = cur.next;
                }
                if(cur==null){
                    return false;
                }
                node.next=cur.next;
                cur.next=node;
            }
            return true;

        }
        ////查找是否包含关键字key是否在单链表当中
        public boolean contains(int v) {
            Node node = new Node(v);
            Node cur=this.head;
            while(cur!=null){
                if(cur.value==node.value){
                    return true;
                }
                cur=cur.next;
            }
            return false;

        }

        //删除第一次出现关键字为key的节点
        public void remove(int v){
            if(this.head==null){

            }else if(this.head.value==v){
              this.head=this.head.next;
           }else {
              Node cur = this.head;
               while (cur.next != null) {
                   if (cur.value == v) {
                       cur.next = cur.next.next;
                   }

               }
           }


        }
        public void display(){
            Node node=this.head;
            while(node!=null){
                System.out.println(node.value);
                node=node.next;
            }

        }
    }

    public static void main(String[] args) {

        Solution solution=new Solution();
        solution.addFirst(1);
        solution.addFirst(2);
        solution.addFirst(3);
        solution.addFirst(3);

       solution.remove(3);
       solution.display();







    }
}
