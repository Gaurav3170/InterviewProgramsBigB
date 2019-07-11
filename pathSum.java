//constructing a binary node
class Node{
    Node left,right;
    int val;
    public Node(int val){
        this.val=val;
        left=right=null;
    }
}

//constructing a binary Tree
class pathSum{
    Node root;
    pathSum(){
        root=null;
    }
    pathSum(int val){
        root = new Node(val);
    }
    public boolean hasPathSum(Node root,int sum){
        if(root==null){
            return false;
        }
        else if(root.val==sum && root.left==null && root.right==null){
            return true;
        }
        else{
            return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
        }
    }
    public static void main(String[] args) {
        pathSum tree=new pathSum();                        
                                                           //  Creating a tree
        tree.root = new Node(5);                           //                 5
        tree.root.left = new Node(4);                      //                / \
        tree.root.right = new Node(8);                     //               4   8
        tree.root.left.left = new Node(11);                //              /   / \
        tree.root.right.left = new Node(13);               //             11  13  4
        tree.root.right.right = new Node(4);               //            /  \      \
        tree.root.left.left.left = new Node(7);            //           7    2      1  
        tree.root.left.left.right = new Node(2);
        tree.root.right.right.right = new Node(1);
        int sum=23;
        boolean ans = tree.hasPathSum(tree.root,sum);
        if(ans){
            System.out.println("The tree has a path with sum : "+sum);
        }
        else{
            System.out.println("The tree does not have a path with sum : "+sum);
        }
    } 
}
