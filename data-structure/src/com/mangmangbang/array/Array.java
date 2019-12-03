package com.mangmangbang.array;

import java.security.SignatureException;

/**
 * created by zhangjingchuan on 2019/12/3
 */
public class Array {

    private int [] data;
    private int size;

    /**
     * 无参的构造函数，默认数组的容量capacity=10
     */
    private Array(){
        this(10);
    }

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    private Array(int capacity){
        this.data = new int[capacity];
        size = 0;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(int e){
        this.add(size,e);
    }

    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index,int e){
        if(size == data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }

        if(index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed. Require index >=0 and index <=size");
        }

        for(int i = size - 1;i >= size ; i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 在第一个位置插入一个新元素e
     * @param e
     */
    public void addFirst(int e){
        this.add(0,e);
    }

}
