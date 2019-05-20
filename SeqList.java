package com.bittch.Exception;


//泛型实现顺序表

import java.lang.reflect.Array;
import java.util.*;

public class SeqList<E> implements List<E>{
    class SeqListIterator implements Iterator<E>{

        int index;
        SeqListIterator(){
            index=0;
        }

        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public E next() {
            return array[index++];
        }

        @Override
        public void remove() {
            //SeqList.this表示的是和这个迭代器对象
            //绑定的顺序表的对象
            //调用顺序表SeqList的remove（int index）方法
           SeqList.this.remove(--index);
        }
    }



    E[] array;//存储真正数据的位置
    int size; //顺序表中实际存储的数据个数
    final static int DEFAULT_SIZE=10;

    public SeqList() {
        array=(E[])new Object[DEFAULT_SIZE];
        size=0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<size;i++){
            if(array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new SeqListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array,size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        checkCapacity();
        array[size++]=e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index=indexOf(o);
        if(index==-1){
            return false;
        }
        remove(index);

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        array=(E[]) new Object[DEFAULT_SIZE];
        size=0;

    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue=array[index];
        array[index]=element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        checkCapacity();
        for(int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=element;
        size++;

    }

    @Override
    public E remove(int index) {
        E oldValue=array[index];
        //i代表含义
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
        array[--size]= null;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size;i++){
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i=size-1;i>0;i--){
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        SeqList<E> subList=new SeqList<>();
        subList.array= Arrays.copyOfRange(array,fromIndex,toIndex);
        subList.size=toIndex-fromIndex;

        return subList;
    }

    //如果容量够，什么都不做，否则进行容量的扩容

    private void checkCapacity(){
        if(size<array.length){
            return;
        }
        int oldCapacity=array.length;
        int newCapacity=2*oldCapacity;
        Object[] newArray=new Object[newCapacity];
        for(int i=0;i<oldCapacity;i++){
            newArray[i]=array[i];
        }
        array=(E[])newArray;

    }


    public static void main(String[] args) {

    }
}

