package com.mangmangbang.bst;

/**
 * created by zhangjingchuan on 2019/12/13
 *
 * 二分搜索树
 *
 * 二分搜索树的节点必须具有可比较性
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        private E e;
        private Node left;
        private Node right;

        private Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    /**
     * 记录整个二分搜索树储存了多少个元素
     */
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素
     * @param e
     */
    public void add(E e){
        if(root == null){
            root = new Node(e);
            size++;

        }else{
            add(root,e);
        }



    }

    /**
     * 向以node为根的二分搜索树中插入元素E
     *
     * 递归算法
     * @param node
     * @param e
     */
    private void add(Node node,E e){
        if(node.e.equals(e)){
            return ;
        }
        if(node.e.compareTo(e)<0&&node.left == null){
            node.left = new Node(e);
            size++;
            return ;
        }
        if(node.e.compareTo(e)>0&&node.right == null){
            node.right = new Node(e);
            size++;
            return ;
        }

        if(node.e.compareTo(e)>0){
            add(node.right,e);
        }else{
            add(node.left,e);
        }
    }
}


