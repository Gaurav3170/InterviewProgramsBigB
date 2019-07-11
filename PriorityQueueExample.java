//Java Program to demonstrate the working Of Priority Queue
//Initially priority Queue For Integers is a MinHeap
//Using reverse Order it can be MaxHeap
//For string Priority Queue in natural order is from capital 
//letters to small letters.
import java.util.*;
public class PriorityQueueExample {
    public static void main(String[] args) {
        //Creates an empty Priority Queue
        PriorityQueue <Integer> pQueue = new PriorityQueue <Integer>(Collections.reverseOrder());
        //Adding items to PriorityQueue using add()
        pQueue.add(5);
        pQueue.add(2);
        pQueue.add(1);
        pQueue.add(4);
        pQueue.add(3);
        //Printing the most priority element
        System.out.println("Head value using peek function:"+pQueue.peek());
        //Printing all elements
        System.out.println("The queue elements:");
        Iterator<Integer> itr=pQueue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        //removing the top priority element and printing the modified
        //pQueue using poll()
        pQueue.poll();
        System.out.println("Queue elements after removing an element with poll function");
        Iterator<Integer> itr1=pQueue.iterator();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }

        //Removing Java using remove()
        pQueue.remove(4);
        System.out.println("Queue elements after removing 4 with remove function");
        Iterator<Integer> itr2=pQueue.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        //Check if an element is present using contains()
        boolean b=pQueue.contains(5);
        System.out.println("Priority Queue contains 5 or not ?:"+b);

        //Getting objects from the queue using toArray9)
        //in an array and print the Array
        Object arr[]=pQueue.toArray();
        System.out.println("Value in Array :");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
