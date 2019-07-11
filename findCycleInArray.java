/*
Program to detect cycle in an array.
We will use tortoise and hare approach !
Take two pointers fast and slow and for each slow pointer moving
ahead move the fast pointer twice .
*/
import java.util.*;
class findCycleInArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array?");
        String inp[]=sc.nextLine().split(" ");
        int n=inp.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }
        if(cyclic(arr)){
            System.out.println("Cycle Detected!");
        }
        else{
            System.out.println("Cycle not Detected!");
        }
    }

    //Tortoise and Hare algorithm (Floyd's and Brent algorithm)

    public static boolean cyclic(int arr[]){
        int slow=0,fast=0; //two pointers
        while(true){
            if(slow<0 || fast<0 || slow>=arr.length || fast>=arr.length){
                return false;
            }
            fast=arr[fast];
            if(slow==fast){
                return true;
            }
            if(fast<0 || fast>=arr.length){
                return false;
            }
            fast=arr[fast];
            if(fast==slow){
                return true;
            }
            slow=arr[slow];
            if(slow==fast){
                return true;
            }
        }
    }
}