package com.mangmangbang.array;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * created by zhangjingchuan on 2019/12/3
 */
public class ArrayMain {

    public static void main(String [] args){

        //Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);





        Array<Integer> arr = new Array(10);

        for(int i = 0;i<10;i++){
            arr.addLast(i);
        }

//        for(int i = 0;i<10;i++){
//            arr.addLast(i);
//        }

        System.out.println(arr.toString());

//        arr.add(1,100);
//        System.out.println(arr.toString());
//
//        arr.addFirst(-1);
//        System.out.println(arr.toString());

        boolean contains = arr.contains(15);
        System.out.println(contains);

//        System.out.println(arr.findFirst(2));
//        System.out.println(arr.findLast(2));
//        System.out.println(arr.findAll(2).length);

//        arr.removeFirstElement(2);
//        System.out.println(arr.toString());

//        arr.removeLastElement(2);
//        System.out.println(arr.toString());

        arr.removeAllElement(2);
        System.out.println(arr.toString());
//        arr.remove(2);
//        System.out.println(arr.toString());
//        arr.addLast(14);
//        System.out.println(arr.toString());

    }
}
