import java.util.*;
class Node{
    int val;
    Node left,right;
    public Node(int val){
        this.val=val;
        left = right = null;
    }
}

class BinaryTree{
    Node root;
    public BinaryTree(){
    root = null;
    }
    public BinaryTree(int val){
        root = new Node(val);
    }
    public static void main(String args[]){
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    zigzag(tree.root);
    //1 3 2 4 5 6 7
    }
    
    public static void zigzag(Node root){
        boolean leftToRight = true;
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currentLevel.push(root);
        while(!currentLevel.isEmpty()){
            Node temp = currentLevel.pop();
            System.out.print(temp.val+" ");
            if(leftToRight){
                if(temp.left!=null){
                nextLevel.push(temp.left);
                }
                if(temp.right!=null){
                nextLevel.push(temp.right);
                }
            }
            else{
               if(temp.right!=null){
                nextLevel.push(temp.right);
                }
                if(temp.left!=null){
                nextLevel.push(temp.left);
                }
            }
            if(currentLevel.isEmpty()){
                Stack<Node> swap = currentLevel;
                currentLevel = nextLevel;
                nextLevel = swap;
                leftToRight = !leftToRight;
            }
        }  
    
}
}