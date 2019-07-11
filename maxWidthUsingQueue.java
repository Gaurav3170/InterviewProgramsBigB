import java.util.LinkedList;
import java.util.Queue;

public class maxWidthUsingQueue {
    //A binary tree node has data , pointer to left child , and a pointer to rigt child
    static class node
    {
        int data;
        node left,right;
        public node(int data) {
            this.data = data;
        }
    }

    //Function to find max-Width of tree using level order traversal
    static int maxWidth(node root) {
        //Base case
        if(root == null) 
            return 0;
        //Initialize count_max=0
        int count_max=0;
        //Do level order traversing keeping track of number of nodes at ever level
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            //get the size of queue when the level order traversal for one level finishes
            int count = q.size();
            //Update the maximum node count value 
            count_max = Math.max(count_max,count);
            //iterate for all the nodes in the queue currently
            while(count-->0) {
                //dequeue a node from queue
                node temp = q.remove();
                //enqueue left and right children of dequeued node
                if(temp.left != null){
                    q.add(temp.left);
                } 
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return count_max;
    }

    public static void main(String args[]) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.right = new node(8);
        root.right.right.left = new node(6);
        root.right.right.right = new node(7);
        System.out.println("Maximum Width of the Tree is : "+maxWidth(root));
    }

}