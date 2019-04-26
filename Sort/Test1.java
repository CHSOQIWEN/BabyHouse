package com.bittch.Sort;

/**
 * Auther:CHAOQIWEN
 */
public class Test1 {
    //直接选择排序
    public static void selctSort(int[] array){
        for(int i=0;i<array.length;i++){
            //无序[0，array.length-i]
            //有序[array.length-i,array.length]
            int max=0;
            for(int j=0;j<array.length-i;j++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            int t=array[max];
            array[max]=array[array.length-1-i];
            array[array.length-i-1]=t;
        }
    }

    public static void adjustdown(int[] array,int index){
        int left=2*index+1;
        if(left>array.length){
            return;
        }
        int right=2*index+2;
        int max=left;
        if(right<array.length&&array[left]<array[right]){
            max=right;
        }
        if(array[index]>array[right]){
            return;
        }
        int t=array[index];
        array[index]=array[right];
        array[right]=t;
        adjustdown(array,max);
    }
    //堆排序
    public static void heapSort(int[] array){
        for(int i =(array.length-1-1)/2;i>=0;i--){
            adjustdown(array,i);
        }
        for(int j=0;j<array.length;j++){
            //无序[0，array.length-j]
            //有序[array.length-j,array.length]
            //减缓最大的数到无需部分的最后位置
            int t=array[0];
            array[0]=array[array.length-j-1];
            array[array.length-j-1]=t;
        }
        //无序部分，除了[0],都满足堆得性质
        adjustdown(array,0);
    }

    public static void main(String[] args) {
        int[] array={3,4,2,6,9,0,1,2,3,5};
        selctSort(array);
        for(int t:array){
            System.out.print(t+" ");
        }
    }
}
