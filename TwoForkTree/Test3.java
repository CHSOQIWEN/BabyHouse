package com.bittch.TwoForkTree;

import java.util.Arrays;


public class Test3 {
    public static class TreeNode{
        char val;

        TreeNode left;
        TreeNode right;
        TreeNode(char x){
            this.val=x;

        }
    }
    public static int find(char[] array,char v){
        for(int i=0;i<array.length;i++){
            if(array[i]==v){
                return i;
            }

        }
        return -1;
    }
    /**
     * 利用前序+中序创建二叉树
     * Auther:CHAOQIWEN
     */
    public static TreeNode buildTree(char[] preorder,char[] inorder){
        if(preorder.length==0){
            return null;
        }
        //1.根据前序，找到根的值，并且创建根节点
        char rootVal= preorder[0];
        TreeNode root=new TreeNode(rootVal);

        //2.在中序中找到根的值所在的下标
        int leftSize=find(inorder,rootVal);


        //3.切出左子树的前序和中序
        char[] leftPreOrder=Arrays.copyOfRange(preorder,1,1+leftSize);
        char[] leftInOrder = Arrays.copyOfRange(inorder,0,leftSize);
        root.left=buildTree(leftPreOrder,leftInOrder);

       //4.切出右子树的前序和中序
       char[] rightPreOrder = Arrays.copyOfRange(preorder,1+leftSize,preorder.length);
       char[] righntInOrder = Arrays.copyOfRange(inorder,leftSize+1,inorder.length);
       root.right=buildTree(rightPreOrder,righntInOrder);

       return root;


    }

    /**
     * 根据中序和后序创建二叉树
     */
    public static TreeNode buildTree1(char[] inOrder,char[] postOrder){
        if(inOrder.length==0){
            return null;
        }
        char rootval=postOrder[postOrder.length];
        TreeNode root = new TreeNode(rootval);

        int leftsize=find(postOrder,rootval);

        char[] leftinOrder=Arrays.copyOfRange(inOrder,0,leftsize);
        char[] leftpostOrder = Arrays.copyOfRange(postOrder,0,leftsize);
        root.left=buildTree1(leftinOrder,leftpostOrder);

        char[] rightinOrder = Arrays.copyOfRange(inOrder,leftsize+1,inOrder.length);
        char[] rightpostOrder = Arrays.copyOfRange(postOrder,leftsize,postOrder.length-1);
        root.right=buildTree1(rightinOrder,rightpostOrder);


        return root;

    }

}
