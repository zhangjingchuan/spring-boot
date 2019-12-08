package com.mangmangbang.queue;

public interface Queue<E> {

    /**
     * 向队列中添加一个元素
     */
    void enqueue(E e);

    /**
     * 取出一个元素
     * @return
     */
    E deQueue();

    /**
     * 查看队首元素
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}
