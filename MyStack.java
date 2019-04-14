package com.bittch.Exception;

/**
 * Auther:CHAOQIWEN
 */
public class MyStack {
    private int[] array;
    int top;
    MyStack(){
        this.array=new int[100];
        this.top=0;
    }
    public  void  push(int v){
        this.array[this.top++]=v;

    }
    public int pop(){
        return this.array[--this.top];
    }
    public int peek(){
        return this.top;
    }
    public int size(){
        return this.top;
    }
    public boolean isEmpty(){
        return this.top==0;
    }
}
