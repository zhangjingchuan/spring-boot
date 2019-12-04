package com.mangmangbang.array;


/**
 * created by zhangjingchuan on 2019/12/3
 */
public class ArrayMain {

    public static void main(String [] args){

        Array arr = new Array(20);

        for(int i = 0;i<10;i++){
            arr.addLast(i);
        }


        System.out.println(arr.toString());

        arr.add(1,100);
        System.out.println(arr.toString());

        arr.addFirst(-1);
        System.out.println(arr.toString());
    }
}
