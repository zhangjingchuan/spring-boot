package com.mangmangbang.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * created by zhangjingchuan on 2019/10/30
 */
public class App {

    public static void main(String [] args){
        List<String> list = new ArrayList<>();

//        list.add("123123123");
//        list.add("asdfasdf");
//        list.add("123");
//        list.add("dfgsdfgsdfg");
//
//        Collections.sort(list,(a,b)->a.length()-b.length());
//
//        System.out.println(list.toString());


        //Supplier 代表一个输出
//        Consumer 代表一个输入
//        BiConsumer 代表两个输入
//        Function 代表一个输入，一个输出（一般输入和输出是不同类型的）

//        UnaryOperator 代表一个输入，一个输出 （输入和输出是相同类型的）

//        BiFunction 代表两个输入，一个输出（一般输入和输出是不同类型的）

//        BinaryOperator 代表两个输入，一个输出（输入和输出是相同类型的）

        //lambda表达式是对象，是一个函数式接口的实例


//        Runnable run = () -> System.out.println("");
//        BiFunction<String,String,Integer> bi = (a,b)-> {
//            return b.length() + a.length();
//        };
//
//        System.out.println(bi.apply("abc","cccc"));


//        Supplier<String> su1 = ()->"";
//
//        Supplier<String> su2 = App::hello;
//
//        String s = su2.get();
//
//        System.out.println(s);

        gen1();

    }

    public static String hello(){
        return "hello";
    }

    public static void gen1(){
        String [] arr = {"a","b","1","2"};

        Stream<String> stream = Stream.of(arr);


        Stream.of(arr).forEach(System.out::println);
    }
}
