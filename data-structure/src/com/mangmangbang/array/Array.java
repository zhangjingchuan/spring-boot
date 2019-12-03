package com.mangmangbang.array;

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



}
