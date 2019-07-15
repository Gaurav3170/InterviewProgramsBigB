/*
Given n matrices , multiply them in the minimum number of 
operations possible.
Eg: A1 [4*5] A2[5*6] A3[6*3] A4[3*5]
therefore dimensions dim[]= [4,5,6,3,5] where for each matrice A`i`
(1<=i<=n-1) the dimension is  dim[i-1]*dim[i]
eg: for ABC => (AB)C || A(BC)
     (4*5*6)+(4*6*3) || (4*5*3)+(5*6*3)
        (120+72) || (60+90)
        192 || 150
        ans = 150. 
        Therefore we will multiply in this order A(BC)


There are two approaches for this problem :
1) Recursive Approach

A simple solution is to place parenthesis at all possible 
places, calculate the cost for each placement and return 
the minimum value. In a chain of matrices of size n, we can 
place the first set of parenthesis in n-1 ways. For example,
if the given chain is of 4 matrices. let the chain be ABCD,
then there are 3 ways to place first set of parenthesis
outer side: (A)(BCD), (AB)(CD) and (ABC)(D). So when we 
place a set of parenthesis, we divide the problem into
subproblems of smaller size. Therefore, the problem has
optimal substructure property and can be easily solved
using recursion.
*/
/*
class matrixChainMultiplication{
    public static void main(String[] args) {
        int dim[] = {4,5,3,2};
        int n=dim.length;
        System.out.println("Minimum Number of multiplications possible = " + minMultiply(dim,1,n-1));
    }
    public static int minMultiply(int arr[],int start,int end)
    {
        if(start==end){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int index=start;index<end;index++){
            int count = minMultiply(arr, start, index) + minMultiply(arr, index+1, end) + arr[start-1]*arr[index]*arr[end];
            min=Math.min(min,count);
        }
        return min;
    }
}
*/


/*
Dynamic Approach
Since same suproblems are called again, this problem has 
Overlapping Subproblems property. So Matrix Chain Multiplication
problem has both properties of a dynamic programming problem. 
Like other typical Dynamic Programming(DP) problems, 
recomputations of same subproblems can be avoided by 
constructing a temporary array m[][] in bottom up manner.
 */
import java.util.*;
public class matrixChainMultiplication{
    private int[][] m;
    private int[][] s;
    private int n;
    public matrixChainMultiplication(int dim[]){
        n=dim.length-1; //no of matrices
        m=new int[n+1][n+1];
        s=new int[n+1][n+1];
        matrixChainOrder(dim); //run dp algorithm
    }
    private void matrixChainOrder(int dim[]){
        //initial cost for single dimensions 
        for(int i=1;i<=n;i++){
            m[i][i]=0;
        }

        //Solve the chains of increasing length l.
        for(int l=2;l<=n;l++){
            for(int i=1;i<=n-l+1;i++){
                int j=i+l-1;
                m[i][j]=Integer.MAX_VALUE;
                //check each possible split to see if it's better
                //than all seen so far.
                for(int k=i;k<j;k++){
                    int q = m[i][k]+m[k+1][j] + dim[i-1]*dim[k]*dim[j];
                    if(q<m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    private String printOptimalParanthesis(int i,int j){
        if(i==j){
            return "A["+i+"]";
        }
        else{
            return " ( " + printOptimalParanthesis(i, s[i][j]) + printOptimalParanthesis(s[i][j]+1, j) + " ) ";
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array p[], which represents the chain of matrices such that the ith matrix A[i] is of dimension dim[i-1] * dim[i]");
        System.out.println("Enter the total length?");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter dimensions?");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        matrixChainMultiplication obj=new matrixChainMultiplication(arr);
        System.out.println("Matrices will be multiplied in this order!");
        System.out.println(obj.printOptimalParanthesis(1, n-1));
        System.out.println("Minimum Number of multiplications possible = "+obj.m[1][n-1]);
        sc.close();
    }
}
