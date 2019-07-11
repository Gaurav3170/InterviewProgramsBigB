import java.util.*;
class kMostFrequentElements{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array ?");
        String inp[]=sc.nextLine().split(" ");
        int arr[]=new int[inp.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("Enter the value of k?");
        int k=sc.nextInt();
        List<Integer> list=kMostFrequent(arr,k);
        System.out.println(list);
        sc.close();
    }

    public static List<Integer> kMostFrequent(int arr[],int k){
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int maxFreq=0;
        for(int i=0;i<arr.length;i++){
            if(hm.get(arr[i])==null){
                hm.put(arr[i],1);
            }
            else{
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            if(hm.get(arr[i])>maxFreq){
                maxFreq=hm.get(arr[i]);
            }
        }

        List<Integer> bucketList[] = new LinkedList[maxFreq+1];
        for(int i=0;i<=maxFreq;i++){
            bucketList[i] = new LinkedList<Integer>();
        }

        for(Integer key: hm.keySet()){
            int index=hm.get(key);
            bucketList[index].add(key);
        }

        List<Integer> result = new LinkedList<Integer>();
        for(int i=maxFreq;i>=0;i--){
            for(Integer j: bucketList[i]){
                    if(result.size()<k){
                    result.add(j);
                }
                    else{
                        return result;
                }
            }
        }
        return result;
    }
}