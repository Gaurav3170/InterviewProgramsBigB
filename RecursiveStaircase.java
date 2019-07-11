
import java.util.*;
class RecursiveStaircase{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of steps in the staircase?");
        int n=sc.nextInt();
        long ways=rec_staircase(n);
        System.out.println("The number of ways to climb a staircase of "+n+" steps by climbing 1 or 2 steps at a time = "+ways);
    }
    public static long rec_staircase(int num)
    {
        long dp[]=new long[num+1];
        dp[0]=1;
        dp[1]=1;
        for(int x=2;x<=num;x++){
            dp[x]=dp[x-1]+dp[x-2];
        }
        return dp[num];
    }

}