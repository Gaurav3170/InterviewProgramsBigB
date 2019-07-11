import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//Pair class to store coordinates.
class Pair<U, V>
{
	public final U first;		// first field of a Pair
	public final V second; 	// second field of a Pair
	private Pair(U first, V second)
	{
		this.first = first;
		this.second = second;
	}
	@Override
	public String toString()
	{
		return "(" + first + ", " + second + ")";
	}
	public static <U, V> Pair <U, V> of(U a, V b)
	{
		return new Pair<>(a, b);
	}
}
//Main Class
class nQueens{
    static int n;
    static int row=0,index=0;
    static ArrayList<Pair<Integer,Integer>> queens=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the dimensions of n*n chessboard ?");
        n=sc.nextInt();
        boolean flag=false;
        while(index<n){
            if(!queensPlaced(0)){
                if(flag==false){
                    System.out.println("N Queens cannot be placed!");
                }
                break;
            }
            else
            {
                flag=true;
                System.out.println(queens);
                queens.clear();
            }
        }
        sc.close();
    }
    public static boolean queensPlaced(int column){
        if(column>=n){
            return true;
        }
        int row=0;
        if(column==0){
            row=index+1;
        }
        while(row<n){
            Pair<Integer,Integer> p=Pair.of(row,column);
            queens.add(p);
            if(isSafe(row, column) && queensPlaced(column+1)){
                index=row;
                return true;
            }
            queens.remove(queens.size()-1);
            row++;
        }
        return false;

    }
    public static boolean isSafe(int ro,int col)
    {
        //check if it lies in the same row or same diagonal
        for(int i=0;i<queens.size()-1;i++){
            int r=queens.get(i).first;
            int c=queens.get(i).second;
            if((r==ro) || (Math.abs(r-ro)==Math.abs(c-col))){
                return false;
            }
        }
        return true;
        
    }
}