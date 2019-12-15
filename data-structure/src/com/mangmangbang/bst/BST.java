package com.mangmangbang.bst;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Stack;

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
        root = add(root,e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素E
     * 递归算法
     * @param node
     * @param e
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node,E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(node.e.compareTo(e)<0){
            node.right = add(node.right,e);
        }else if(node.e.compareTo(e)>0){
            node.left = add(node.left,e);
        }

        return node;
    }

    /**
     * 查看二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return this.contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }

        if(node.e.compareTo(e)>0){
            return contains(root.right,e);
        }

        if(node.e.compareTo(e)<0){
            return contains(root.left,e);
        }

        if(node.e.equals(e)){
            return true;
        }
        return false;
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void preOrder(Node node){
        if(node == null){
            return ;
        }

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null) {
                stack.push(cur.right);
            }
            if(cur.left!=null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void inOrder(Node node){
        if(node == null){
            return ;
        }

        inOrder(node.left);
        //访问该节点
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node!=null){
            if (node.right!= null){
                stack.push(node.right);
                node = node.right;
            }else {
                stack.push(node);

                if(node.left!=null){
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop().e);
        }
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder(){
        this.postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        generateBSTString(root,0,res);

        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null){
            res.append(generateDepthString(depth)+"null\n");
            return ;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left , depth+1 ,res);
        generateBSTString(node.right , depth+1 ,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res =  new StringBuilder();
        for(int i=0;i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }
}


