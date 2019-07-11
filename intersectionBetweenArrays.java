/*
Program to find the intersection between arrays !
*/
import java.util.*;
class intersectionBetweenArrays
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array elements for 1st array?");
        String inp1[]=sc.nextLine().split(" ");
        int n1=inp1.length;
        int arr[]=new int[n1];
        for(int x=0;x<n1;x++){
            arr[x] = Integer.parseInt(inp1[x]);
        }
        System.out.println("Enter the array elements for 1st array?");
        String inp2[]=sc.nextLine().split(" ");
        int n2=inp2.length;
        int arr2[]=new int[n2];
        for(int x=0;x<n2;x++){
            arr2[x] = Integer.parseInt(inp2[x]);
        }
        System.out.println("Enter the array elements for 1st array?");
        String inp3[]=sc.nextLine().split(" ");
        int n3=inp3.length;
        int arr3[]=new int[n3];
        for(int x=0;x<n3;x++){
            arr3[x] = Integer.parseInt(inp3[x]);
        }
        List<Integer> list=intersectionArrays(arr,arr2,arr3,n1,n2,n3);
        System.out.println(list);
        sc.close();
    }

    public static List<Integer> intersectionArrays(int arr1[],int arr2[],int arr3[],int n1,int n2,int n3)
    {
        List<Integer> result=new ArrayList<>();
        int x=0,y=0,z=0;
        while(x<n1 && y<n2 && z<n3){
            if(arr1[x] == arr2[y] && arr2[y] == arr3[z]){
                result.add(arr1[x]);
                x++;
                y++;
                z++;
            }
            else{
            if(arr1[x]<arr2[y] || arr1[x]<arr3[z]){
                x++;
            }
            else if(arr2[y]<arr1[x] || arr2[y]<arr3[z]){
                y++;
            }
            else{
                z++;
            }
            }   
        }
        return result;
    }
}
