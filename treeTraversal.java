/*recursive Method*/

import java.util.Scanner;
class Node{
    int val;
    Node left,right;
    public Node(int val){
        this.val=val;
        left=right=null;
    }
}

class treeTraversal{
    Node root;
    public treeTraversal(){
        root = null;
    }
    public treeTraversal(int key){
        root=new Node(key);
    }
    //Preorder(root,left,right)
    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //Inorder(left,root,right)
    public static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }
    //Postorder(left,right,root)
    public static void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        treeTraversal tree = new treeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("Enter the choice?");
        System.out.println(" 1 - Preorder traversal");
        System.out.println(" 2 - Inorder traversal");
        System.out.println(" 3 - Postorder traversal");
        int choice = sc.nextInt();
        switch(choice){
            case 1 : preOrder(tree.root);
                     break;
            case 2 : inOrder(tree.root);
                     break;
            case 3 : postOrder(tree.root);
                     break;
            default : System.out.println("Wrong choice entered!");     
        }
        sc.close();
    }
}