/*Longest Common Substring*/
class Solution{
    static int l_x=0,l_y=0;
    public static char[] reverse(char inp[]){
      int n=inp.length;
      for(int i=0,j=n-1;i<n/2;i++,j--){
        char temp=inp[i];
        inp[i]=inp[j];
        inp[j]=temp;
      }
      return inp;
    }
    
    public static int[][] LongestCommonSubstring(char s1[],char s2[],int m,int n){
      int dp[][] = new int[m+1][n+1];
      int longest=-1;
      for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
          if(i==0 || j==0)
            dp[i][j]=0;
          else if(s1[i-1]==s2[j-1]){
            dp[i][j] = 1 + dp[i-1][j-1];
            if(longest<dp[i][j]){
              l_x=i;
              l_y=j;
              longest=dp[i][j];
            }
          }   
          else
            dp[i][j]=0;
        }
      }
      return dp;
    }
    
    public static void main(String args[])
    {
      String inp="forgeeksskeegfor";
      char s1[]= inp.toCharArray();
      char s2[]=reverse(inp.toCharArray());
      int len=s1.length;
      display2(LongestCommonSubstring(s1,s2,len,len),s1);
    }
    
  //   public static void display1(int arr[][]){
  //     for(int i=0;i<arr.length;i++){
  //       for(int j=0;j<arr[0].length;j++){
  //         System.out.print(arr[i][j]+" ");
  //       }
  //       System.out.println();
  //     }
  //     System.out.println(l_x+" "+l_y);
  //   }
    
    public static void display2(int arr[][],char s1[]){
      while(arr[l_x--][l_y--]>=1){
        System.out.print(s1[l_x]);
      }
    }
  }
  
  
  
  /*       a n a n a b 
   
         0 0 0 0 0 0 0 
      b  0 0 0 0 0 0 1 
      a  0 1 0 1 0 1 0 
      n  0 0 2 0 2 0 0 
      a  0 1 0 3 0 3 0 
      n  0 0 2 0 4 0 0 
      a  0 1 0 3 0 5 0
  */