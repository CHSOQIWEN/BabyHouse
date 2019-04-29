package com.bittch.Sort;

import java.util.Arrays;

/**
 * 归并排序
 * 1、把要排序区间平均切分为两部分
 * 2、分治算法，对左右两个区间进行同样方式的排序
 *        直到    size==1  已经有序
 *               size==0   区间没有数了
 * 3、合并左右两个两个有序区间到一个有序区间（需要额外空间）
 * Auther:CHAOQIWEN
 */
public class Test4 {
    public static void merge(int[] array,int low,int mid,int high){
        int[] extra = new int[high-low];
        int i=low;//遍历array[low,mid)
        int j=mid;//遍历array[mid,high)
        int x=0;//遍历extra

        while(i<mid&&j<high){
            if(array[i]<array[j]){
                extra[x++]=array[i++];
            }else {
                extra[x++]=array[j++];
            }
        }

        while (i<mid){
            extra[x++]=array[i++];
        }
        while (j<high){
            extra[x++]=array[j++];
        }
        for(int k=low;k<high;k++){
            array[k]=extra[k-low];
        }
    }


    public static void mergeSortInner(int[] array,int low,int high){
        if(low>=high){
            return;
        }
        if(low==high-1){
            return;
        }
        //需要排序的区间array[low,high)

        //1、平均切分
        int mid=low+(high-low)/2;
        //2、分治两个小区间
        mergeSortInner(array,low,mid);
        mergeSortInner(array,mid,high);

        //左右两个小区间已经有序了
        merge(array,low,mid,high);

    }
    public static void mergeSort(int[] array){
        mergeSortInner(array,0,array.length);
    }
    public static void main(String[] args) {
        int[] array = {1,4,5,7,8,2,3,6,9,10};
        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }
}
