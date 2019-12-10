package com.mangmangbang.linked;

import com.sun.deploy.net.protocol.chrome.ChromeURLConnection;

import java.util.zip.CRC32;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        this.dummyHead = new Node(null,null);
        this.size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }



    /**
     * 在链表的index（0-baseed）位置添加心的元素e
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;

        for(int i = 0; i<index;i++){
            prev = prev.next;
        }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e,prev.next);


        size ++;

    }

    /**
     * 在链表头添加心的元素e
     */
    public void addFirst(E e){
        this.add(0,e);
    }

    /**
     * 在链表的末尾添加新的元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取连标的第index(0-baseed)个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        //由于有虚拟头节点的加入，获取当前节点为dummyHead.next为起点，
        Node currnetNode = dummyHead.next;

        for(int i=0;i<index;i++){
            currnetNode = currnetNode.next;
        }

        return currnetNode.e;
    }

    /**
     * 获得链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得链接的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size -1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for(int i =0;i<index;i++){
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){

        Node cur = dummyHead.next;

        while (cur != null){
            if(cur.equals(e)){
                return true;
            }
            cur = cur.next;
        }

        return false;
    }


    /**
     * 从链表中删除指定的元素
     * @param index
     * @return
     */
    public E remove(int index){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        //获取待删除元素的前一个元素
        Node prev = dummyHead;

        for(int i=0;i<index;i++){
            prev = prev.next;
        }

        //获取待删除的元素
        Node delNode = prev.next;

        //修改元素的指向
        prev.next = delNode.next;

        //将待删除元素的下一个元素的指向置空
        delNode.next = null;
        size --;

        return delNode.e;

    }

    /**
     * 从链表中删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }


    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;

        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL");

        return res.toString();
    }
}
