package com.bittch.Exception;

/**
 * Auther:CHAOQIWEN
 */
public class MyLinkedListD {

    /**双向+保存最后一个结点
     * Auther:CHAOQIWEN
     */

        public class Node{
            int value;
            Node next;
            Node prev;
        }

        public static class Solution {
            public Node head;
            public Node last;

            //头插
            public void addFirst(Node node) {
                node.next = this.head;
                this.head = node;
                if (this.last == null) {
                    this.last = node;
                }

            }

            //头删
            public void removeFirst() {
                this.head = this.head.next;
                if (this.head == null) {
                    this.last = null;
                }
            }

            //尾插
            public void addLast(Node node) {
                node.next = null;
                if (this.head == null) {
                    this.head = this.last = null;
                } else {
                    node.prev = this.last;
                    this.last.next = node;
                    this.last = node;
                }
            }

            //尾删
            public void removeLast() {
                if (this.head.next == null) {
                    this.head = this.last = null;
                } else {
                    this.last.prev.next = null;
                }
            }
        }


    }



