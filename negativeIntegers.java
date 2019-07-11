//Program To find the number of negative integers in 
//a row-wise/column-wise sorted matrix.
import java.util.*;
class negativeIntegers{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows and columns");
        String inp[]=sc.nextLine().split(" ");
        int row=Integer.parseInt(inp[0]);
        int column=Integer.parseInt(inp[1]);
        System.out.println("Enter the matrix ?");
        int arr[][]=new int[row][column];
        for(int i=0;i<row;i++)
        {
            String in[]=sc.nextLine().split(" ");
            for(int j=0;j<column;j++){
                arr[i][j]=Integer.parseInt(in[j]);
            }
        }
        int ans=countNegative(arr,row,column);
        System.out.println("The number of negative integers in this array = "+ans);
        sc.close();
    }
    public static int countNegative(int arr[][],int row,int column){
        int count=0;
        int r=0,c=column-1;
        while(r<row && c>=0){
            if(arr[r][c]<0){
                count+=(c+1);
                r++;
            }
            else{
                c--;
            }
        }
        return count;
    }
}