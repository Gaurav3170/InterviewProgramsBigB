/*Given a BST replace every node with sum of all nodes which 
are greater than that node. replace the maximum value node 
with 0.

            5                       
           /  \
          3    7
         / \  / \
        2   4 6  8
       /          \
      1            10
                   /
                  9

*/      
class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data = data;
        left= right=null;
    }
}
class BSTexample{
    static Node root;
    static int sum=0;
    public Node sortedArrayToBST(int arr[],int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid-1);
        node.right = sortedArrayToBST(arr, mid+1, end);
        return node;
    }
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    public void transformTree(Node root){
        if(root==null)
            return;
        transformTree(root.right);
        sum = sum + root.data;
        root.data = sum - root.data;
        transformTree(root.left);
    }
    public static void main(String[] args) {
        BSTexample tree =new BSTexample();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int n = arr.length;
        root = tree.sortedArrayToBST(arr,0,n-1);
        tree.transformTree(root);
        tree.inOrder(root);
    }
}