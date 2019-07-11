/*
Program to reverse array in place
*/

import java.util.*;
class ReverseArray{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the elements of array?");
        String inp[]=sc.nextLine().split(" ");
        int arr[]=new int[inp.length];
        for(int x=0;x<arr.length;x++){
            arr[x]=Integer.parseInt(inp[x]);
        }
        arr=reverseArray(arr);
        for(int num: arr){
            System.out.print(num+" ");
        }
        sc.close();
    }

    public static int[] reverseArray(int arr[]){
        int start=0,end=arr.length-1;
        if(end<=start){
            return arr;
        }
        else{
            while(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
            return arr;
        }

    }
}