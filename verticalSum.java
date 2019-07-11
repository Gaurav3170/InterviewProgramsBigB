//Program to print the vertical sum in a Binary Tree
/*
    Binary Tree
         1
        / \
       2   3
      / \ / \
     4  5 6  7    
     
     So the vertical sum for 1st Line = 4
                             2nd Line = 2
                             3rd Line = 1+5+6 = 12
                             4th Line = 3
                             5th Line = 7  
*/

import java.util.HashMap;

//class for a treenode
class TreeNode {
    //data members
    private int key;
    private TreeNode left;
    private TreeNode right;

    //accessor methods
    public int key() { return key; }
    public TreeNode left() { return left; }
    public TreeNode right() { return right; }

    //Constructor
    public TreeNode(int key){
        this.key = key;
        left = null;
        right = null;
    }

    //Methods to set left and right subtrees
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
}

//class for a binary tree
class Tree {
    
    private TreeNode root;
    //constructors
    public Tree() { root = null; }
    public Tree(TreeNode n) { root = n; }

    //method to be called by consumer class like Main class
    public void VerticalSumMain() {
        VerticalSum(root);
    }

    public void VerticalSum(TreeNode root) {
        //base case
        if(root == null) { return; }
        //Creates an empty hashMap hM
        HashMap<Integer,Integer> hM = new HashMap<Integer,Integer>();
        //Calls the VerticalSumUtil() to store the vertical sum values in hM
        VerticalSumUtil(root, 0, hM);
        if(hM!=null) {
            System.out.println(hM.entrySet());
        }
    }

    private void VerticalSumUtil(TreeNode root , int hD , HashMap<Integer,Integer> hM) {
        //base case
        if(root == null) {
            return ;
        }
        //Store the values in hM for left subtree
        VerticalSumUtil(root.left(), hD-1, hM);
        //update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null)? 0 : hM.get(hD);
        hM.put(hD, root.key() + prevSum);
        //store the values in hM for right subtree
        VerticalSumUtil(root.right(),hD+1,hM);
    }
}

public class verticalSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left().setLeft(new TreeNode(4));
        root.left().setRight(new TreeNode(5));
        root.right().setLeft(new TreeNode(6));
        root.right().setRight(new TreeNode(7));
        Tree t=new Tree(root);
        t.VerticalSumMain();
    }
}
