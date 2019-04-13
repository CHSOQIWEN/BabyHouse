package com.bittch.TwoForkTree;



/**
 * Auther:CHAOQIWEN
 */
public class Test1 {
    public static  class Node{
        int value;
        Node left;
        Node right;

        Node (int v){
            this.value=v;
        }
    }
    public  static int count(Node root){
        if(root==null){
            return 0 ;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else {
            return count(root.left)+count(root.right)+1;
        }
    }
    public  static int leafCount(Node root){
        if(root==null){
            return 0 ;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else {
            return leafCount(root.left)+leafCount(root.right);
        }
    }


    public static int height(Node root){
        if(root==null){
            return 0 ;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else {
            if(height(root.left)>height(root.right)) {
                return height(root.left)+1;
            }else {
                return height(root.right)+1;
            }
        }

    }

    public static int getKLevelSize(Node root, int k) {
        if(root==null){
            return 0;
        }else if(k==1){
            return 1;
        }else {
            return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
        }
    }
    public static Node find(Node root, int value){
        if(root==null){
            return null;
        }else if(root.value==value){
            return root;
        }else if(find(root.left,value)!=null) {
            return find(root.left, value);
        }else if (find(root.right, value)!=null) {
            return find(root.right,value);

        }else {
            return null;
        }
    }


    public static boolean isMirror(Node p,Node q ){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.value==q.value&&isMirror(p.right,q.left)&&isMirror(p.left,q.right);

    }

    public static void main(String[] args) {
        Node na=new Node(1);
        Node nb=new Node(2);
        Node nc=new Node(3);
        Node nd=new Node(4);
        Node ne=new Node(5);
        Node nf=new Node(6);
        Node ng=new Node(7);
        Node nh=new Node(8);

        na.left=nb;na.right=nc;
        nb.left=nd;nb.right=ne;
        nc.left=nf;nc.right=ng;
        ne.right=nh;



        System.out.println(height(na));
        System.out.println(count(na));
        System.out.println(leafCount(na));

    }
}
