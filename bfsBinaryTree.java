import java.util.LinkedList;
import java.util.Queue;

/*  
Write a program to print the values in level order of a binary
tree such that there is a new line after every level.

eg :        1
           / \
          2   3
         /   / \ 
        4   5   6

Output: 1
        2 3
        4 5 6
*/

class node{
    node left;
    node right;
    int value,level;
    public node(int value){
        this.value=value;
        this.level = 0;
        left=null;
        right=null;
    }
}
class bfsBinaryTree{
    node root;
    
    bfsBinaryTree(){
        root = null;
    }

    bfsBinaryTree(int key){
        root = new node(key);
    }

    public void levelOrder(node rNode){
        int currentLevel=1;
        rNode.level=currentLevel;
        Queue<node> queue=new LinkedList<>();
        queue.add(rNode);

        while(queue.size()!=0){
            node temp=queue.remove();
            if(temp.level>currentLevel){
                System.out.println();
                currentLevel++;
            }
            System.out.print(temp.value+" ");
            if(temp.left!=null){
                temp.left.level = temp.level+1;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.level = temp.level+1;
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        bfsBinaryTree tree= new bfsBinaryTree();
        tree.root = new node(1);
        tree.root.left = new node(2);
        tree.root.right = new node(3);
        tree.root.left.left = new node(4);
        tree.root.right.left = new node(5);
        tree.root.right.right = new node(6);
        tree.levelOrder(tree.root);
    }
}