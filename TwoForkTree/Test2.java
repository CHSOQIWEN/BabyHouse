package com.bittch.TwoForkTree;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 利用前序遍历创建二叉树
 * Auther:CHAOQIWEN
 */
class CreateTreeReturnValue{
    //创建好的二叉树的根节点
    public Test2.Node returnRoot;
    public int used;
    CreateTreeReturnValue(Test2.Node returnRoot,int used){
        this.returnRoot=returnRoot;
        this.used=used;
    }


}
public class Test2 {

    public static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
            this.left = left;
            this.right = right;

        }

    }
    public  static  CreateTreeReturnValue creatTree(char[] preOrder){
        if(preOrder.length==0){
            return new CreateTreeReturnValue(null,0);
        }

        char rootvalue=preOrder[0];
        if (rootvalue == '#') {
            return  new CreateTreeReturnValue(null,1);
        }




        //找根节点
        Node root = new Node(rootvalue);
        //左子树，利用遍历建树
        char[] leftPreOrder = new char[preOrder.length-1];
        leftPreOrder=Arrays.copyOfRange(preOrder,1,preOrder.length);
        CreateTreeReturnValue leftTree=creatTree(leftPreOrder);
        //右子树
        char[] rightPreOrder = new char[preOrder.length-1-leftTree.used];
        rightPreOrder=Arrays.copyOfRange(preOrder,leftTree.used+1,preOrder.length);
        CreateTreeReturnValue rightTree=creatTree(rightPreOrder);
        //绑定左右子树和根
        root.left=leftTree.returnRoot;
        root.right=rightTree.returnRoot;

        return new CreateTreeReturnValue(root,1+rightTree.used+leftTree.used);


    }

    public static void main(String[] args) {
        char[] preOrder =new char[] {'A','B','C','#','D','#','#','#','E'};
        CreateTreeReturnValue returnValue=creatTree(preOrder);


        System.out.println(returnValue.used);

    }
}

