/* Program to place all zeroes in the array at the end by doing
array manipulation in place ! 

Time complexity amortized O(n) with no extra array space

Take two pointers p1 and p2 

traverse the array until you get the first zero . Mark it as p1 and p2=p1+1 
At this point p1 points to first zero occured and p2 may or may not point to first zero , so we have two cases:

Case 1 : if(arr[p1]==0 && arr[p2]!=0) => Then we have to swap the two values.
        After swapping we have to find the first zero after p1 so we traverse ahead 
        and p2 was already ahead of p1 so I just incremented p2 also by 1.
        We know that p1 will always be less than p2 since while swapping the two 
        values 0 has come in place of p2.
Case 2: if(arr[p1]==0 && arr[p2]==0) => Then we just have to find the first non zero 
        element in array, so we increment p2 until p2 is less than arr.length.


*/

import java.util.*;
class arrayManipulation{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array?");
        String inp[]=sc.nextLine().split(" ");
        int n=inp.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }
        arr = placeZeroes(arr);
        for(int num: arr){
            System.out.print(num+" ");
        }
    }

    public static int[] placeZeroes(int arr[]){
        int p1=-1,p2=-1; //Pointer p1 for left and p2 for right
        for(int x=0;x<arr.length;x++){
            if(arr[x]==0){
                p1=x;
                break;
            }
        }
        p2=p1+1;
        while(p2>0 && p2<arr.length){
            if(arr[p1]==0 && arr[p2]!=0)
            {
                int temp=arr[p1]; //swap
                arr[p1]=arr[p2];
                arr[p2]=temp;

                p1++;
                p2++;
                while(p1<arr.length){
                    if(arr[p1]==0){
                        break;
                    }
                    p1++;
                }
            }
            else if(arr[p1]==0 && arr[p2]==0){
                p2=p2+1;
            }
        }
        return arr;
    }
}
