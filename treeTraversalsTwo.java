import java.util.Stack;

/*Iterative Method*/
class Node{
    protected int val;
    protected Node left,right;
    public Node(int val){
        this.val = val;
        left = right= null;
    }
}

class treeTraversalsTwo{
    Node root;
    public treeTraversalsTwo(){
        root = null;
    }
    public treeTraversalsTwo(int key){
        root = new Node(key);
    }
    //Preorder(root,left,right)
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() ){
            root = stack.peek();
            stack.pop();
            System.out.print(root.val+" ");
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
    }

    //InOrder(left,root,right)
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val+" ");
            root = root.right;
        }
    }

    //PostOrder(left,right,root)
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 =new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            Node temp = stack1.pop();
            stack2.push(temp);
            if(temp.left!=null)
                stack1.push(temp.left);
            if(temp.right!=null)
                stack1.push(temp.right);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().val+" ");
        }
    }

    public static void main(String[] args) {
        treeTraversalsTwo tree = new treeTraversalsTwo();
        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);
        // tree.root.left.left = new Node(4);
        // tree.root.left.right = new Node(5);
        // tree.root.right.left = new Node(6);
        // tree.root.right.right = new Node(7);
        System.out.println("Inorder");
        inOrder(tree.root);
        System.out.println();
        System.out.println("Preorder");
        preOrder(tree.root);
        System.out.println();
        System.out.println("Postorder");
        postOrder(tree.root);
        System.out.println();
    }
}