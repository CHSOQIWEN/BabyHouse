package com.bittch.Sort;

import java.util.Arrays;

/**
 * 快速排序
 * Auther:CHAOQIWEN
 */
public class Test3 {


    public static void swap(int[] array,int begin,int end){
        int t=array[begin];
        array[begin]=array[end];
        array[end]=t;
    }
    //1、hover法
    //一个下标从左边开始（begin），一个下标从右边开始（end）
    //  过程中保证begin的左边都比基准值 <=
    //             end的右边都比基准值  >=
    //            如果同时遇到不符合的情况，进行交换后继续
    //     直到，begin遇到end
    //     把基准值交换到中间来


    public static int parition(int[] array,int left,int right){
        int begin=left;
        int end=right;

        int p=array[right];
        while(begin<end){
            while(begin<end&&array[begin]<=p){
                begin++;
            }
            while(begin<end&&array[end]>=p){
                end--;
            }
            swap(array,begin,end);

           /* int e=array[begin];
            array[begin]=array[end];
            array[end]=e;*/
        }
        swap(array,begin,right);
        /*int r=array[begin];
        array[begin]=array[right];
        array[right]=r;*/
        return begin;
    }
    //2、挖坑法
    public static int parition2(int[] array,int left,int right){
        int begin=left;
        int end = right;
        int p=array[right];

        while (begin<end){
            while (begin<end&&array[begin]<p){
                begin++;
            }
            array[end]=array[begin];
            while (begin<end&&array[end]>p){
                end--;
            }
            array[begin]=array[end];
        }
        array[begin]=p;
        return begin;
    }
    //前后下标法
    public static int parition3(int[] array,int left,int right){
        int d=left;
        for(int i=left;i<right;i++){
            if(array[i]<array[right]){
                swap(array,d,i);
                d++;
            }
        }
        swap(array,d,right);
        return d;
    }

    //三数取中法选出基准值
    public static int sanshuquzhong(int[] array,int left,int right){
        int mid = left+(right-left)/2;
        if(array[left]>array[right]){
            if(array[left]<array[mid]){
                return left;
            }else if(array[mid]>array[right]){
                return mid;
            }else {
                return right;
            }
        }else {
            if(array[right]<array[mid]){
                return right;

            }else if(array[mid]>array[left]){
                return mid;
            }else {
                return left;
            }
        }

    }

    public static void quickSortInner(int[] array ,int left,int right){
        if(left>=right){
            return ;
        }

        //找基准值再把基准值放到最边上
        int originIndex = sanshuquzhong(array,left,right);
        swap(array,originIndex,right);

        int p=parition3(array,left,right);

        quickSortInner(array,left,p-1);
        quickSortInner(array,p+1,right);
    }


    public static void quickSort(int[] array){
        quickSortInner(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] array={2,5,6,3,8,1,9,4,7};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


}
