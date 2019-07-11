/*
Program to find the odd times occuring number in an array
of integers.
 */
import java.util.*;
class oddOcuuringNumber{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array?");
        String inp[]=sc.nextLine().split(" ");
        int arr[]=new int[inp.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(inp[i]);
        }
        int ele=findOdd(arr);
        System.out.println("The number which has occured odd number of times = "+ele);
    }

    public static int findOdd(int arr[]){
        HashSet<Integer> hSet=new HashSet<>();
        for(int num: arr){
            if(hSet.contains(num)){
                hSet.remove(num);
            }
            else{
                hSet.add(num);
            }
        }
        Iterator elements=hSet.iterator();
        return (Integer)(elements.next());
    }
}