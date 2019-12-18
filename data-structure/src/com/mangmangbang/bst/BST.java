package com.mangmangbang.bst;

import com.sun.org.apache.bcel.internal.generic.NOP;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.LinkedList;
import java.util.Queue;
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
        Node nod = root;
        while (!stack.isEmpty() || nod != null) {
            while (nod != null) {
                stack.push(nod);
                nod = nod.left;
            }
            Node sNode = stack.pop();
            System.out.println(sNode.e + " ");
            nod = sNode.right;
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

    public void postOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node nod = root;
        Node pre = null;
        while (!stack.isEmpty() || nod != null) {
            while (nod != null) {
                stack.push(nod);
                nod = nod.left;
            }
            Node sNode = stack.peek();
            if (sNode.right == null || pre == sNode.right) {
                stack.pop();
                pre = sNode;
                System.out.print(sNode.e + " ");
            } else {
                nod = sNode.right;
            }
        }
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder(){

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left!=null) {
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if(size==0){
            throw new  IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    public Node minimum(Node node){
        if(node.left==null){
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最小元素（非递归）
     * @return
     */
    public E minimumNR(){
        if(size==0){
            throw new  IllegalArgumentException("BST is empty");
        }

        Node node = root;
        while (node.left!=null){
            node = node.left;
        }

        return node.e;
    }

    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E maximum(){
        if(size==0){
            throw new  IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node
     * @return
     */
    public Node maximum(Node node){
        if(node.right==null){
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 寻找二分搜索树的最大元素（非递归）
     * @return
     */
    public E maximumNR(){
        if(size==0){
            throw new  IllegalArgumentException("BST is empty");
        }

        Node node = root;
        while (node.right!=null){
            node = node.right;
        }

        return node.e;
    }

    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后的新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left==null){
            //获取当前节点的右子树
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 二分搜索树中删除最大值所在节点
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = node;
            size --;

            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node,E e){
        if(node == null){
            return null;
        }

        //如果当前元素小于指定元素
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else{
            //待删除的元素等于当前元素
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点替换待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;

            return successor;
        }
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


