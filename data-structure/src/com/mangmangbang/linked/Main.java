package com.mangmangbang.linked;

/**
 * created by zhangjingchuan on 2019/12/10
 */
public class Main {

    public static void main(String [] args){
        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i=0;i<5;i++){

            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }

        linkedList.add(2,666);
        System.out.println(linkedList.toString());

        linkedList.remove(2);
        System.out.println(linkedList.toString());

        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        linkedList.removeLast();
        System.out.println(linkedList.toString());
    }
}
