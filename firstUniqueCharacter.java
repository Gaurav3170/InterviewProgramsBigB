//Return the index of first unique character in string else return -1
import java.util.*;
class firstUniqueCharacter{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string?");
        String str=sc.nextLine();
        int ans=getIndex(str);
        if(ans==-1){
            System.out.println("No unique character exists!");
        }
        else{
            System.out.println("The first unique character occurs at index "+ans);
        }
        sc.close();
    }

    public static int getIndex(String str)
    {
        int min=Integer.MAX_VALUE;
        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
        for(int i=0;i<str.length();i++){
            char current=str.charAt(i);
            if(hmap.get(current)==null){
                hmap.put(current,i);
            }
            else{
                hmap.put(current,-1);
            }
        }
        
        for(char c: hmap.keySet()){
            int value=hmap.get(c);
            if(value!=-1 && value<min){
                min=value;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }
}
