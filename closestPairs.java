import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Pair<U, V>
{
	public final U first;		// first field of a Pair
	public final V second; 	// second field of a Pair

	// Constructs a new Pair with specified values
	private Pair(U first, V second)
	{
		this.first = first;
		this.second = second;
	}

	@Override
	// Checks specified object is "equal to" current object or not
	public boolean equals(Object o)
	{
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Pair<?, ?> pair = (Pair<?, ?>) o;

		// call equals() method of the underlying objects
		if (!first.equals(pair.first))
			return false;
		return second.equals(pair.second);
	}

	@Override
	// Computes hash code for an object to support hash tables
	public int hashCode()
	{
		// use hash codes of the underlying objects
		return 31 * first.hashCode() + second.hashCode();
	}

	@Override
	public String toString()
	{
		return "(" + first + ", " + second + ")";
	}

	// Factory method for creating a Typed Pair instance
	public static <U, V> Pair <U, V> of(U a, V b)
	{
		// calls private constructor
		return new Pair<>(a, b);
	}
}

class closestPairs{
    public static void main(String[] args)throws Exception {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter elements of first array?");
        String inp1[]=br.readLine().split(" ");
        System.out.println("Enter elements of second array?");
        String inp2[]=br.readLine().split(" ");
        System.out.println("Enter target value?");
        int target = Integer.parseInt(br.readLine());
        int arr1[]=new int[inp1.length];
        int arr2[]=new int[inp2.length];
        for(int x=0;x<arr1.length;x++){
            arr1[x]=Integer.parseInt(inp1[x]);
        }
        for(int x=0;x<arr2.length;x++){
            arr2[x]=Integer.parseInt(inp2[x]);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int closestPair[]={arr1[0],arr2[0]};
        int smallestDiff = Math.abs(arr1[0]+arr2[0]-target);
        ArrayList<Pair<Integer,Integer>> list=new ArrayList<>();
        int row=0,column=arr2.length-1;
        while(row<arr1.length && column>=0){
            int sum=arr1[row]+arr2[column];
            int absDiff=Math.abs(sum-target);
            if(absDiff==smallestDiff){
                Pair<Integer,Integer> p1= Pair.of(arr1[row],arr2[column]);
                list.add(p1);
            }
            if(absDiff<smallestDiff){
                closestPair[0]=arr1[row];
                closestPair[1]=arr2[column];
                smallestDiff=absDiff;
            }
            if(sum>target){
                column--;
            }
            else if(sum<target){
                row++;
            }
        }
        Pair<Integer,Integer> p2=Pair.of(closestPair[0],closestPair[1]);
        list.add(p2);
        System.out.println(list);
    }
}