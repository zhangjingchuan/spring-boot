package com.mangmangbang.stack;

import com.mangmangbang.linked.LinkedList;

import java.util.List;

/**
 * created by zhangjingchuan on 2019/12/10
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append("Stack : top ");

        res.append(linkedList);

        return res.toString();
    }
}
