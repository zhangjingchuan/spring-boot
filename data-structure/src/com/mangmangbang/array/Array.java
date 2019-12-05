package com.mangmangbang.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * created by zhangjingchuan on 2019/12/3
 */
public class Array<E>  {

    private E [] data;
    private int size;

    /**
     * 无参的构造函数，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        this.data = (E[])new Object[capacity];
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
    public void addLast(E e){
        this.add(size,e);
    }

    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed. Require index >=0 and index <=size");
        }

        if(size == data.length){
            //扩容
            resize(2 * data.length);
        }

        for(int i = size - 1;i >= index ; i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        //创建一个新数组
        E [] newData = (E[])new Object[newCapacity];
        //将原数组中的值复制给新数组
//        Stream.iterate(0,i->i+1).limit(size).forEach(i -> {
//            newData[i]=data[i];
//        });
//        简单循环时for循环比lambda性能更好

        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        //重定向data的指向
        data = newData;

    }

    /**
     * 在第一个位置插入一个新元素e
     * @param e
     */
    public void addFirst(E e){
        this.add(0,e);
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index){

        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e){

        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return Arrays.stream(data).anyMatch(x -> e.equals(x));
    }

    /**
     * 查找数组中最后一个元素e所在的索引
     * 如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int findLast(E e){
//        AtomicInteger index = new AtomicInteger(-1);
//        Stream.iterate(0, i -> i + 1).limit(size).forEach(i -> {
//            if(data[i].equals(e)){
//                index.set(i);
//            }
//        });
//        return index.get();

        int index = -1;
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                index = i;
            }
        }

        return index;
    }

    /**
     * 查找数组中第一个元素e所在的索引
     * 如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int findFirst(E e){
        int index = -1;
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }

        return index;
    }

    /**
     * 返回集合中所有的e元素集合
     * @param e
     * @return
     */
    public Integer[] findAll(E e){
        List<Integer> list = new LinkedList<>();
//        Stream.iterate(0, i -> i + 1).limit(size).forEach(i -> {
//            if(data[i].equals(e)){
//                list.add(i);
//            }
//        });

        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                list.add(i);
            }
        }
        Integer[] indexs = list.toArray(new Integer[list.size()]);
        return indexs;
    }

    /**
     * 从数组中删除index位置的元素
     * 返回删除的元素结果
     * @param index
     * @return
     */
    public E remove(int index){

        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        E result = data[index];

        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }

//        Stream.iterate(index+1,i->i+1).limit(size-1-index).forEach(i->{
//            data[i-1]=data[i];
//        });

        size --;
        //将数组中的引用制空
        data[size] = null;

        //修改数组容积，释放空间
        if(size < data.length/2){
            resize(data.length/2);
        }

        return result;
    }

    /**
     * 删除数组中的第一个元素，
     * 返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * 返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除第一个e元素
     * @param e
     * @return
     */
    public void removeFirstElement(E e){
        int index = this.findFirst(e);
        this.remove(index);
    }

    /**
     * 从数组中删除最后一个e元素
     * @param e
     */
    public void removeLastElement(E e){
        int last = this.findLast(e);
        this.remove(last);
    }

    /**
     * 从数组中删除所有的e元素
     * @param e
     */
    public void removeAllElement(E e){
        if(!this.contains(e)){
            return ;
        }

        //获取第一个e元素所在的索引
        int index = this.findFirst(e);
        //删除索引位置的数据
        this.remove(index);
        //回掉继续判断
        this.removeAllElement(e);
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array : size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

}
