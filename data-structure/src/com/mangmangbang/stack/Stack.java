package com.mangmangbang.stack;

public interface Stack<E> {

    /**
     * 添加元素
     * @param e
     */
    void push(E e);

    /**
     * 取出元素
     * @return
     */
    E pop();

    /**
     * 取出顶部元素
     * @return
     */
    E peek();

    /**
     * 栈的大小
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
