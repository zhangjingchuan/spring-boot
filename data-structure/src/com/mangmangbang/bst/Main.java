package com.mangmangbang.bst;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String [] args){
        BST<Integer> bst = new BST<>();
//        int [] nums = {5,3,6,8,4,2};
//        for(int num: nums){
//            bst.add(num);
//        }
//
////        bst.preOrder(); 
////        System.out.println();
//
////        System.out.println(bst);
//
////        bst.preOrderNR();
////        bst.inOrder();
////
////        System.out.println();
//
////        bst.postOrder();
//
////        bst.inOrderNR();
//
//
////        bst.levelOrder();
//
//        System.out.println(bst.maximum());
//
//        System.out.println();
//
//        System.out.println(bst.maximumNR());


        Random random = new Random();

        int n = 1000;

        for(int i=0;i<n;i++){
            bst.add(random.nextInt(1000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMax());
        }

        System.out.println(nums);
    }

}
