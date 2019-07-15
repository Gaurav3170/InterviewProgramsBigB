class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data = data;
        left= right=null;
    }
}
class converArrayToBST{
    static Node root;
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public static Node sortedArrayToBST(int arr[],int start,int end){
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid-1);
        node.right = sortedArrayToBST(arr, mid+1, end);
        return node;
    }

    public static void main(String[] args) {
        converArrayToBST tree=new converArrayToBST();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int n = arr.length;
        root = sortedArrayToBST(arr,0,n-1);
        System.out.println("Inorder Traversal");
        tree.inOrder(root);

    }
}