package com.mangmangbang.linked;

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

    private Node head;
    private int size;

    public LinkedList(){
        this.head = null;
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
     * 在链表头添加心的元素e
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e,head);
        size++;
    }

    /**
     * 在链表的index（0-baseed）位置添加心的元素e
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if(index == 0){
            this.addFirst(e);
        }else{
            Node prev = head;

            for(int i = 0; i<index-1;i++){
                prev = prev.next;
            }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e,prev.next);
        }

        size ++;

    }

    /**
     * 在链表的末尾添加新的元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }
}
