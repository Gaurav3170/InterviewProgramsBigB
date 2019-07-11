/*
    Program to implement a Queue using Stack .
    We have to take two stacks one for enqueue operations and
    one for dequeue operations.
    If you want to push in a dequeue ->  push in enqueue stack 
    If you want to pop : Then two conditions arises -->
                        1) If the dequeue stack is empty : pop all the
                            elements from enqueue stack and push to 
                            dequeue stack. and then pop from dequeue stack.
                        2) Pop from dequeue stack since it contains one element.
                    
*/
/*
import java.util.*;
class QueueUsingStacks {
    Stack<Integer> enqueue,dequeue;
    public QueueUsingStacks(){
        enqueue=new Stack<>();
        dequeue=new Stack<>();
    }
    public void push(int value){
        enqueue.push(value);
    }
    public int pop(){
        if(dequeue.isEmpty()){
            while(!enqueue.isEmpty()){
                int ele=enqueue.peek();
                dequeue.push(ele);
                enqueue.pop();
            }
        }
        int ans=dequeue.peek();
        dequeue.pop();
        return ans;
    }
    public static void main(String[] args) {
        QueueUsingStacks obj=new QueueUsingStacks();
        obj.push(1);
        obj.push(2);
        obj.push(4);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
*/

/* 
Implement a Queue using One Stack 
=> For push operations we can directly push into stack
=> For pop elements we have to return the last element of the stack , so
   we have to return the last element somehow using that one stack . 
   We can do so by recursion such that if len(stack)==1 then we have to pop
   else store the last value in some variable . Call the function recursively again
   and then after recursive statement push the element stored in that variable.
   at the end you will have that element . 
*/

import java.util.*;
class QueueUsingStacks{
    Stack<Integer> stack;
    public QueueUsingStacks(){
        stack = new Stack<>();
    }
    public void push(int value){
        stack.push(value);
    }
    public int pop_value(){
        if(stack.size()==1){
            int ele=stack.peek();
            stack.pop();
            return ele;
        }
        else{
            int cur_element=stack.peek();
            stack.pop();
            int result=pop_value();
            stack.push(cur_element);
            return result;
        }
    }
    public static void main(String[] args) {
        QueueUsingStacks obj=new QueueUsingStacks();
        obj.push(1);
        obj.push(2);
        obj.push(4);
        obj.push(3);
        System.out.println(obj.pop_value());
        System.out.println(obj.pop_value());
        System.out.println(obj.pop_value());
    }
}