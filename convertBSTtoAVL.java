import java.util.*;
class Node {
    int data;
    Node left,right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class convertBSTtoAVL
{
    Node root;
    //This function traverses the skewed binary tree and stores its nodes pointers in vector nodes[]
    void storeBSTNodes(Node root , Vector<Node> nodes){
        //Base Case
        if(root == null){
            return;
        }
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }
    //Recursive function to construct binary tree
    Node buildTreeUtil(Vector<Node> nodes,int start,int end) {
        //base case
        if(start>end)
            return null;

        //get the middle element and make it root
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        //Using index in Inorder traversal, construct left and right subtrees
        node.left = buildTreeUtil(nodes, start, mid-1);
        node.right = buildTreeUtil(nodes, mid+1, end);

        return node;
    }

    //This functions converts an unbalanced BST to a balanced BST
    Node buildTree(Node root){
        //store nodes of given bst in sorted order.
        Vector<Node> nodes = new Vector<Node>();
        storeBSTNodes(root, nodes);

        //construct bst from nodes[]
        int n=nodes.size();
        return buildTreeUtil(nodes, 0, n-1);
    }

    //Function to do preorder traversal of tree
    void preOrder(Node node) {
        if(node == null)
            return;
        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String args[]) {
        /* Constructed skewed binary tree is
                    10
                   /
                  8
                 /
                7
               /
              6
             /
            5       
        */
        convertBSTtoAVL tree = new convertBSTtoAVL();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(5);

        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }

}