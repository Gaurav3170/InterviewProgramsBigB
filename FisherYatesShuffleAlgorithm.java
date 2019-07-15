import java.util.Random;
import java.util.Arrays;
/*
Shuffle a given array using Fisher–Yates shuffle Algorithm
Given an array, write a program to generate a random 
permutation of array elements. This question is also asked as
 shuffle a deck of cards or randomize a given array. 
 
 Here shuffle means that every permutation of array element 
 should equally likely.

shuffle-array
Let the given array be arr[]. A simple solution is to create
an auxiliary array temp[] which is initially a copy of arr[].
Randomly select an element from temp[], copy the randomly 
selected element to arr[0] and remove the selected element 
from temp[]. Repeat the same process n times and keep 
copying elements to arr[1], arr[2], … . The time complexity 
of this solution will be O(n^2).


 
Fisher–Yates shuffle Algorithm works in O(n) time complexity.
The assumption here is, we are given a function rand() that 
generates random number in O(1) time.
The idea is to start from the last element, swap it with a
randomly selected element from the whole array (including 
last). Now consider the array from 0 to n-2 (size reduced by 
1), and repeat the process till we hit the first element.

To shuffle an array a of n elements (indices 0..n-1):
  for i from n - 1 downto 1 do
       j = random integer with 0 <= j <= i
       exchange a[j] and a[i]


       [1,2,3,4,5]   i=4 j=3
       [1,2,3,5,4]   i=3 j=1
       [1,5,3,2,4]   i=2 j=0
       [3,5,1,2,4]   i=1 j=1
       [3,5,1,2,4]        
*/
class FisherYatesShuffleAlgorithm{

    public static void randomize(int arr[],int n){
        Random r = new Random();
        for(int i=n-1;i>=0;i--){
            int j = r.nextInt(i+1);
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int n=arr.length;
        randomize(arr,n);
    }
}