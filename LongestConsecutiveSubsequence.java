//Dynamic Approach
class LCS
{
    public static void main(String args[]){
      String x="GAURAV";
      String y="PIYUSH MISHRA";
      char s1[]=x.toCharArray();
      char s2[]=y.toCharArray();
      int l1=s1.length;
      int l2=s2.length;
      display(s1,s2,Subsequence(s1,s2,l1,l2));
    }
    
    public static int[][] Subsequence(char s1[],char s2[],int len1,int len2){
      int dp[][]=new int[len1+1][len2+1];
      for(int i=0;i<=len1;i++){
        for(int j=0;j<=len2;j++){
          if(i==0 || j==0){
            dp[i][j]=0;
          }
          else if(s1[i-1]==s2[j-1]){
            dp[i][j] = 1 + dp[i-1][j-1];
          }
          else{
            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
          }
        }
    }
      return dp;
    }
  
    public static void display(char s1[],char s2[],int arr[][]){
      String result="";
      int i=s1.length;
      int j=s2.length;
      while(i>0 && j>0)
      {
        if(s1[i-1]==s2[j-1])
          result=""+s1[i-1]+result;
        if(arr[i-1][j]==arr[i][j-1]){
          i--;
          j--;
        }
        else if(arr[i-1][j] > arr[i][j-1])
          i--;
        else
          j--;
      }
      System.out.println(result);
    }
}
