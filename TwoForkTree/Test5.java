package com.bittch.TwoForkTree;



/**
 * 二叉堆
 * Auther:CHAOQIWEN
 */
public class Test5 {

    //数组中找最值，重新建个类

    //  数据结构大堆：插入、删除（只会删除最大一个数）、查看当前最大数

    public static class Heap{
        private int[] array;
        int size;
        Heap() {
            this(new int[0]);
        }

        Heap(int[] array){
            this.array=new int[10000];
            for(int i =0;i<array.length;i++){
                this.array[i]=array[i];
            }
            this.size=array.length;
            BuildTree(this.array,this.size);
        }
        //返回堆里最值
        int top(){
            return array[0];
        }
        //返回堆里最值，并把这个值从堆里删掉
        int pop(){
            int v=array[0];
            array[0]=array[size-1];
            size--;
            adjustTree(array,0);

            return v;
        }
        public int  getsize(){

            return size;
        }

        //插入
        public void push(int v){
            array[size++]=v;
            adjustup(array,size,size-1);

        }


    }
    //向下调整
    public static void adjustTree(int[] array, int index){
        //1、判断是不是叶子，如果是叶子，返回
        int left = 2*index+1;
        if(left>=array.length){
            return;
        }
        //2、找最大值的下标
        int right = 2*index+2;
        int max=left;
        if(right<array.length&&array[left]<array[right]){
            max=right;
        }
        //3、如果最大值大于根节点，交换
        if(array[index]>=array[max]){
            return;
        }

            int t=array[index];
            array[index]=array[max];
            array[max]=t;

            //继续向下调整
            adjustTree(array,max);


    }
    //2)
    public  static void  adjustTree2(int[] array,int index){
        int max=2*index+1;
        while(max<array.length){
            if (max+1<array.length&&array[max+1]>array[max]){
                max=max+1;
            }
            if(array[index]>array[max]){
                break;
            }
            int t=array[index];
            array[index]=array[max];
            array[max]=t;

            index=max;
            max=2*max+1;
        }
    }
    //向下调整，建小堆
    public static void adjustsmallTree(int[] array,int index){
        int left=2*index+1;
        if(left>array.length){
            return;
        }
        int right=2*index+2;
        int min=left;
        if(right<array.length&&array[left]>array[right]){
            min=right;
        }
        if(array[index]<=array[min]){
            return;
        }
        int t=array[index];
        array[index] = array[min];
        array[min]=t;
        adjustsmallTree(array,min);
    }
    //向上调整
    public static  void adjustup(int[] array,int size,int index){

        while (index>0){
            int p=(index-1)/2;
            if(array[p]>=array[index]){
                break;
            }

            int t=array[p];
            array[p]=array[index];
            array[index]=t;

            index=p;
        }
    }
    //建堆
    public static void BuildTree(int[] array,int size){
        for(int i=(size-1-1)/2;i>0;i--){
            adjustTree(array,i);
        }
    }
    //数组中找最值
    //  数据结构大堆：插入、删除（只会删除最大一个数）、查看当前最大数






    public static void main(String[] args) {
        Heap heap= new Heap();
        heap.push(3);
        heap.push(2);
        heap.push(5);
        heap.push(7);
        heap.push(9);
        heap.push(8);
        heap.push(1);
        while (heap.getsize()>0){
            System.out.println(heap.pop());
        }



        /*int[] array={ 27,25,18,24,20,12,13,22,28 };
        adjustup(array,9,8);


        for(int i:array){
            System.out.print(i);
            System.out.print(" ");
        }*/
    }
}
