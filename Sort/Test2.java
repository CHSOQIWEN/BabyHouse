package com.bittch.Sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Auther:CHAOQIWEN
 */
public class Test2 {
    //插入排序
    public static void insertSort(int[] array){
        for(int i=0;i<array.length;i++){
            int j=i-1;
            for( j=i-1;j>=0&&array[i]<array[j];j--){

            }
            int pos=j+1;
            int key=array[i];
            for(int k=i;k>pos;k--){
                array[k]=array[k-1];
            }
            array[pos]=key;
        }
    }
    public static void insertSort2(int[] array){
        for(int i=0;i<array.length;i++){
            int key=array[i];

            int j=i-1;

            for(;j>=0&&key<array[j];j--){
                array[j+1]=array[j];
            }

            array[j+1]=key;
        }
    }

    //希尔排序
    public static void insertSortWithGap(int[] array,int gap){
        for(int i=0;i<array.length;i++){
            int key=array[i];
            int j=i-gap;
            for(;j>0&&key<array[j];j=j-gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }
    public static void shellSort(int[] array){
        int gap=array.length;
        while(true){
            gap=gap/2;
            insertSortWithGap(array,gap);

            if(gap==1){
                break;
            }
        }
    }


    //选择排序
    public static void selectSort(int[] array){
        for(int i =0;i<array.length;i++){
            //无序[0，array.length-i)
            //有序[array.length-i,array.length)
            int max=0;
            for(int j=0;j<array.length-i;j++){
                if(array[j]>array[max]){
                        max=j;
                }
                int t=array[max];
                array[max]=array[array.length-1-i];
                array[array.length-i-1]=t;
            }
        }
    }
    //堆排序
    public static void adjustdown(int[] array,int size,int index){

        int max = 2 * index + 1;
        while (max < size) {
            if (max + 1 < size && array[max+1] > array[max]) {
                max += 1;
            }

            if (array[index] >= array[max]) {
                break;
            }

            int t = array[max];
            array[max] = array[index];
            array[index] = t;

            index = max;
            max = 2 * index + 1;
        }

    }
    public static void heapSort(int[] array){
        for(int i=(array.length-1-1)/2;i>=0;i--){
            adjustdown(array,array.length,i);
        }
        for(int j=0;j<array.length;j++){
            int t=array[0];
            array[0]=array[array.length-1-j];
            array[array.length-1-j]=t;
            adjustdown(array,array.length-j-1,0);
        }

    }
    //冒泡排序
    public static void bubleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }
    //快速排序
    public static int parition(int[] array,int left,int right){
        int begin=left;
        int end = right;
        int p=array[right];

        while (begin<end){
            while (begin<end&&array[begin]<=p){
                begin++;
            }
            while(begin<end&&array[end]>=p){
                end--;
            }
            int t=array[begin];
            array[begin]=array[end];
            array[end]=t;
        }
        int r=array[begin];
        array[begin]=array[right];
        array[right]=r;


        return begin;//返回基准值所在位置的下标
    }

    public  static void quickSortInner(int[] array,int left,int right){

        if(left==right){
            //size==1
            return;
        }
        if(left>right){
           // size==0
            return;
        }
        //要排序的区间是array[left,right]
        //1、找基准值，array[right]
        //2、遍历整个区间，把区间分成三部分
        int privotIndex=parition(array,left,right);//privotIndex是基准值所在位置的下标
        //比基准值小的[left,privotIndex-1]
        //比基准值大的[privotUndex+1,right]
        //3、分治算法
        //处理比基准值小的
        quickSortInner(array,left,privotIndex-1);
        //处理比基准值大的
        quickSortInner(array,privotIndex+1,right);
    }

    public static void quickSort(int[] array){
        quickSortInner(array,0,array.length-1);
    }


    public static void main(String[] args) {
        int[] array={1,2,9,5,7,8,3,4};


        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
