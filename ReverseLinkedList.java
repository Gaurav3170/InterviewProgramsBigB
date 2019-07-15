/* Program to Reverse Linked List in batches
head->1->2->3->4->5->6->null  k=2




*/
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next=null;
    }
}
class ReverseLinkedList{
    Node head;
    public ReverseLinkedList(){
        head = null;
    }
    public ReverseLinkedList(int d){
        head = new Node(d);
    }
    public static void display(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static Node reverse(Node head , int k){
        Node prev = null;
        Node current = head;
        Node next = null;

        int count = 0;

        while(count<k && current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        //next is pointer to (k+1)th node.
        if(next != null)
            head.next = reverse(next,k);
        
        return prev;
    }
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        display(list.head);
        System.out.println();
        Node n1 = reverse(list.head,3);
        display(n1);
    }
}