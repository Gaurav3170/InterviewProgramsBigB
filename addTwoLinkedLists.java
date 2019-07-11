import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class addTwoLinkedLists{
    class node
    {
        int val;
        node next;
        public node(int val){
            this.val=val;
        }
    }
    node head1,head2,result,cur;
    int carry;
    public addTwoLinkedLists(){
        this.head1=null;
        this.head2=null;
        this.result=null;
        this.cur=null;
        this.carry=0;
    }
    //function to print linked list
    void printList(node head)
    {
        while(head != null)
        {
            System.out.print(head.val + " ");
            head= head.next;
        }
    }
    //A utility function to push a value in a linked list
    void push(int val,int list)
    {
        node newnode = new node(val);
        if(list==1){
            newnode.next = head1;
            head1 = newnode;
        }
        else if(list==2){
            newnode.next = head2;
            head2 = newnode;
        }
        else{
            newnode.next = result;
            result=newnode;
        }
    }
    
    //Add two linked lists of same size represented by head1
    //and head2 and returns head of the resultant linked list.
    //Carry is propagated while returning from the recursion
    void addSameSize(node n,node m){
        if(n==null)
        {
            return;
        }
        addSameSize(n.next, m.next);
        int sum = n.val+m.val+carry;
        carry = sum/10;
        sum=sum%10;
        push(sum,3);
    }

    //function to get size of linekd list
    int getsize(node head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }

    void addDifferentSize(node n,node m,int s1,int s2){
        //first list must be larger than the second list
        if(s1<s2){
            node temp=head1;
            head1=head2;
            head2=temp;
        }
        int diff=Math.abs(s1-s2);
        node temp=head1;
        while(diff-- > 0){
            temp = temp.next;
            cur = temp;
        }
        addSameSize(cur, head2);
        propagateCarry(head1);
    }

    void propagateCarry(node head1){
        if(head1!=cur){
            propagateCarry(head1.next);
            int sum = carry + head1.val;
            carry = sum/10;
            sum = sum%10;
            push(sum,3);
        }
    }

    //Main Function to add two lists
    void addLists(){
        if(head1==null){
            result=head2;
            return;
        }

        if(head2==null){
            result=head1;
            return;
        }

        int s1=getsize(head1);
        int s2=getsize(head2);

        if(s1 == s2){
            addSameSize(head1,head2);
        }
        else{
            addDifferentSize(head1,head2,s1,s2);
        }
        if(carry>0)
            push(carry,3);
    }
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        addTwoLinkedLists list = new addTwoLinkedLists();
        System.out.println("Enter the first number ? eg : \"1 9 6\" ");
        String input1[]=br.readLine().split(" ");
        System.out.println("Enter the second number ? eg : \"9 6\" ");
        String input2[]=br.readLine().split(" ");
        for(int i=input1.length-1;i>=0;i--){
            list.push(Integer.parseInt(input1[i]),1);
        }
        for(int i=input2.length-1;i>=0;i--){
            list.push(Integer.parseInt(input2[i]),2);
        }
        list.addLists();
        list.printList(list.result);
        
    }



}