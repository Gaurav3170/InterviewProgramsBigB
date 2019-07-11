//This problem is to demonstrate the minimum Number of jumps
//needed to reach the end of the building from the start given 
//the buildings height in an array
/*
    Example :
    arr = [4,2,0,0,2,0]
     
Index:        0   1   2   3   4   5
             ___
            |___|
            |___|___         ___
            |___|___|       |___|
            |___|___|_______|___|___

Height:     [ 4   2   0   0   2   0]
*/

//Basic Naive Approach
//Use recurive case to traverse all the paths frm start that reach end
//-->Remove the comments below to run naive approach

/*import java.util.*;
class towerHopper{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter heights of different towers?");
        String inp[]=sc.nextLine().split(" ");
        int arr[]=new int[inp.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(inp[i]);
        }
        int minHops = minimumHops(arr,0,arr.length-1);
        if(minHops==Integer.MAX_VALUE){
            System.out.println("You cannot hop from the start to end!");
        }
        else{
        System.out.println("The minimum number of hops needed : "+minHops);}
        sc.close();
    }

    public static int minimumHops(int arr[],int start,int end){
        //Base Case when source and destination are same
        if(start==end){
            return 0;
        }
        //When nothing is reachable from the given source.
        if(arr[start]==0){
            return Integer.MAX_VALUE;
        }

        //Traverse through all the points reachable from arr[start]
        //Recursively get the minimum number of jumps needed to reach
        //arr[end] from these reachable points.
        int min=Integer.MAX_VALUE;
        for(int i=start+1;i<=end && i<=arr[start]+start;i++){
            int minJumps=minimumHops(arr, i, end);
            if(minJumps != Integer.MAX_VALUE && minJumps+1<min){
                min=minJumps+1;
            }
        }
        return min;
    }
}
*/

//Optimal Approach
//Dynamic Programming is Used in this Case such that we create
//a jumps[] array and for each index i from start to end 
//jumps[i] will store the minimum number of hops needed to reach
//index i from the start .
//At the end we will return jumps[n-1]
//To run this code remove the comments below for this code only.
/*
import java.util.*;
class towerHopper{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter heights of different towers?");
        String inp[]=sc.nextLine().split(" ");
        int arr[]=new int[inp.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(inp[i]);
        }

        int ans=minJumps(arr);
        if(ans==Integer.MAX_VALUE){
            System.out.println("The person cannot hop from start to end!");
        }
        else{
        System.out.println("The minimum number of hops needed : "+ans);
        }
    }

    public static int minJumps(int arr[]){
        int jumps[]=new int[arr.length];
        if(arr.length==0 || arr[0]==0){
            return Integer.MAX_VALUE;
        }
        jumps[0]=0;
        //this will calculate minJumps to reach arr[i] from arr[0]
        for(int i=1;i<arr.length;i++)
        {
            jumps[i]=Integer.MAX_VALUE;
            for(int j=0;j<i;j++)
            {
                if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE){
                    jumps[i]=Math.min(jumps[i],jumps[j]+1);
                    break;
                }
            }
        }
        return jumps[arr.length-1];
    }
}
*/
//Time Complexity = O(n^2)

//Most efficient approach O(n) solution
//In this solution we will use 3 variables
//maxReach , step and jump
//maxReach = stores the maximal reachable index in the array.
//step = stores the number of steps we can still take
//jump = stores the minimum number of jumps necessary to reach
//maximal reachable position.

import java.util.*;
class towerHopper{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter heights of different towers?");
        String inp[]=sc.nextLine().split(" ");
        int arr[]=new int[inp.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(inp[i]);
        }

        int ans = minJumps(arr,arr.length);
        if(ans==-1){
            System.out.println("The person cannot hop from start to end");
        }
        else{
            System.out.println("The minimum number of hops needed = "+ans);
        }
    }
    public static int minJumps(int arr[],int n){
        if(n<=1){
            return 0;
        }
        if(arr[0]==0){
            return -1;
        }
        int maxReach = arr[0];
        int steps = arr[0];
        int jump = 1; //stores the no of jumps necessary to reach the
                      // maximal reachable position.
        
        
        for(int i=1;i<n;i++){
            if(i == n-1){
                return jump;
            }
            maxReach = Math.max(maxReach, i+arr[i]);
            steps--;
            if(steps == 0){
                //we must have used a jump;
                jump++;
                //check if current index is the maximum 
                //reach point from previous Index
                if(arr[i]<=0){
                    return -1;
                }
                steps = maxReach-i;
            }
        }
        return -1;
    }
}
//Time Complexity = O(n)
    
        
        


