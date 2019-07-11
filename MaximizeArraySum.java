import java.io.*;
import java.util.*;
public class MaximizeArraySum{
    public static void main(String[] args)throws Exception {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //Taking n as number of elements
        System.out.println("Enter the number of elements?");
        int n=Integer.parseInt(br.readLine());
        //Inputting the array elements
        System.out.println("Enter the elements?");
        String inp[]=br.readLine().split(" ");
        //Input value of k?
        System.out.println("Enter the value of k?");
        int k=Integer.parseInt(br.readLine());
        //Implementing min Heap Priority Queue to store
        //the minimum element at top
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(n);
        for(int i=0;i<inp.length;i++){
            pQueue.add(Integer.parseInt(inp[i]));
        }
        while(k-- > 0){
            int ele=(pQueue.poll())*-1;
            pQueue.add(ele);
        }
        int max_sum=0;
        Iterator<Integer> itr=pQueue.iterator();
        while(itr.hasNext())
        {
            max_sum+=(itr.next());
        }
        System.out.println("Maximum sum after k negations = "+max_sum);
    }
}