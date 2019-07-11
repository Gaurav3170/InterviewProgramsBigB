import java.util.*;
class largestSquareOfOnes{

    public static int largestSquare(int arr[][]){
        int result=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]>0 && i>0 && j>0){
                    arr[i][j]=1+Math.min(Math.min(arr[i-1][j],arr[i][j-1]),arr[i-1][j-1]);
                    if(arr[i][j]>result){
                        result=arr[i][j];
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the dimensions of the matrix in \"rows columns\" format");
        String inp[]=sc.nextLine().split(" ");
        int m=Integer.parseInt(inp[0]);
        int n=Integer.parseInt(inp[1]);
        int arr[][]=new int[m][n];
        System.out.println("Enter the matrix?");
        for(int i=0;i<m;i++){
            String in[]=sc.nextLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(in[j]);
            }
        }
        int ans=largestSquare(arr);
        if(ans>0){
        System.out.println("The largest possible square of 1's possible is of side = "+ans+" cm.");
        }
        else{
            System.out.println("There exists no such square!");
        }
        sc.close();
    }
}