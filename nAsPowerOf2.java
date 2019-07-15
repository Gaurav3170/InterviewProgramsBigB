/* Represent N as sum of k powers of 2*/
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
class nAsPowerOf2{
    
    public static int countSet(int n){
        int c=0;
        while(n>0){
            int temp = n&1;
            if(temp==1)
                c++; 
            n=n>>1;
        }
        return c;
    }

    public static void powerTwo(int n,int k){
        int setBits=countSet(n);
        if(setBits>k || k>n){
            System.out.println("Not possible!");
        }
        else{
            PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
            int two=1;
            while(n>0){
                if((n&1) == 1)
                    pQueue.add(two);
                two=two*2;
                n>>=1;
            }
            
            while(pQueue.size()<k){
                int ele = pQueue.poll();
                pQueue.add(ele/2);
                pQueue.add(ele/2);
            }

            Iterator<Integer> iter = pQueue.iterator();
            while(iter.hasNext())
            {
                System.out.print(iter.next()+" ");
            }
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n and k?");
        String inp[] = sc.nextLine().split(" ");
        int n=Integer.parseInt(inp[0]);
        int k=Integer.parseInt(inp[1]);
        powerTwo(n,k);
        sc.close();
    }
}