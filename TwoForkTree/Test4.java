package com.bittch.TwoForkTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Test4 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;


        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * //非递归二叉树前序遍历
     * Auther:CHAOQIWEN
     */
    public static List<Integer> preOrderNoR(TreeNode root){
        List<Integer> list=new LinkedList<>();
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();

        while(!stack.empty()|| cur!=null){
            while (cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            cur=top.right;
        }
        return list;

    }
    /**
     * //非递归二叉树遍中序遍历
     * Auther:CHAOQIWEN
     */
    public static List<Integer> inOrderNoR(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);

                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
        return list;
    }
    /**
     * //非递归二叉树遍后序遍历
     * Auther:CHAOQIWEN
     */
    public static List<Integer> postOrderNoR(TreeNode root){
        List<Integer> list =new ArrayList<>();
        TreeNode last=null;
        TreeNode cur = root;
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.empty()||cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        TreeNode top = stack.peek();
        if(top.right==null||top.right==last){
            list.add(cur.val);
            stack.pop();
            last=top;
        }else {
            cur=cur.right;
        }
        return list;
    }





}
