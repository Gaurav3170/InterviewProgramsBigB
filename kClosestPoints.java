/* 
Program to find the k-closest points from the origin .
Input : [(-2,4) , (0,-2) , (-1,0) , (2,5) , (-2,-3) , (3,2)] , K=2
Output: [(0,-2) , (-1,0)]
Time complexity = O(n+(n-k)logk)

*/
import java.util.*;
class Pair<U,V>
{
    public final U x_cor;
    public final V y_cor;

    private Pair(U x_cor,V y_cor){
        this.x_cor=x_cor;
        this.y_cor=y_cor;
    }

    public static <U,V> Pair<U,V> newPair(U a,V b){
        return new Pair<>(a, b);
    }

    @Override
    public String toString(){
        return "("+x_cor+","+y_cor+")";
    }
}

class kClosestPoints{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of points in the array?");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter "+n+" points.");
        List<Pair<Integer,Integer>> pairs = new ArrayList<>(n);
        for(int x=0;x<n;x++){
            String inp[]=sc.nextLine().split(" ");
            int a=Integer.parseInt(inp[0]);
            int b=Integer.parseInt(inp[1]);
            Pair<Integer,Integer> p=Pair.newPair(a, b);
            pairs.add(p);                                       //O(n)
        }
        System.out.println("Enter the value of K?");
        int k=sc.nextInt();
        HashMap<Integer,ArrayList<Pair<Integer,Integer>>> hMap = new HashMap<>();
        for(Pair<Integer,Integer> m: pairs){
            int d=distance(m.x_cor,m.y_cor);
            if(hMap.get(d)==null){
                ArrayList<Pair<Integer,Integer>> temp=new ArrayList<>();
                temp.add(m);
                hMap.put(d,temp);
            }
            else{
                ArrayList<Pair<Integer,Integer>> temp=hMap.get(d);
                temp.add(m);
                hMap.put(d,temp);
            }
        }
        //System.out.println("Ok tested hashmap!");
        int arr[]=new int[n];
        int i=0;
        Set<Integer> keys = hMap.keySet();
        for(int key: keys){
            int len=hMap.get(key).size();
            while(len>0){
                arr[i]=key;
                i++;
                len--;
            }
        }
        // for(i=0;i<n;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
        //System.out.println("Array tested!");
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(i=0;i<k;i++){
            pQueue.add(arr[i]);         //O(k logk)
        }
        for(int x=k;x<arr.length;x++){          //O[(n-k) log k]
            if(arr[x]<pQueue.peek()){
                pQueue.poll();   //O(log k)
                pQueue.add(arr[x]); //O(log k)
            }
        }
        // Iterator<Integer> iter=pQueue.iterator();
        // while(iter.hasNext()){
        //     System.out.print(iter.next()+" ");
        // }
        // System.out.println();
        // System.out.println("Tested pQueue! --> Created a max Heap");
        ArrayList<Pair<Integer,Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while(!pQueue.isEmpty()){
            int ele=pQueue.poll();          //O[(n-k) log k]
            minHeap.add(ele);
        }
        Iterator<Integer> iter2=minHeap.iterator();
        Set<Integer> values=new HashSet<>();
        while(iter2.hasNext()){
            values.add(iter2.next());
        }
        System.out.println("Created Min Heap ! ");
        for(int num: values){
            for(Pair<Integer,Integer> t: hMap.get(num)){
                result.add(t);
            }
        }
        System.out.println(result);
        sc.close();
    }
    public static int distance(int a,int b){
        return a*a + b*b;
    }
}