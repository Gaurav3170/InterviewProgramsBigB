import java.util.*;
class longestConsecutiveElements{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String in[]=sc.nextLine().split(" ");
        int arr[]=new int[in.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(in[i]);
        }
        int ans=longestSequence(arr);
        System.out.println("The longest consecutive elements in the array is of length: "+ans);
        sc.close();
        
    }
    
    public static int longestSequence(int arr[]){
        int longest=0;
        HashSet<Integer> hSet = new HashSet<>();
        for(int i: arr){
            hSet.add(i);
        }
        for(int curr: arr){
            int i=curr;
            if(!hSet.contains(curr-1)){
                while(hSet.contains(curr)){
                    curr++;
                }
                longest=Math.max(longest,curr-i);
            }
        }
        return longest;
    }
}