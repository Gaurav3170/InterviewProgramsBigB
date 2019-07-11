/*
abc(){()}[] -- valid

*/

import java.util.*;
class validateParanthesis{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the expression of paranthesis?");
        String exp=sc.nextLine();
        boolean ans=validate(exp);
        if(ans){
            System.out.println("The paranthesis are valid!");
        }
        else{
            System.out.println("The paranthesis are not valid!");
        }
        sc.close();
    }

    public static boolean validate(String expression){
        HashMap<Character,Character> pair = new HashMap<Character,Character>();
        Stack<Character> stack = new Stack<>();
        pair.put('(',')');
        pair.put('{','}');
        pair.put('[',']');
        boolean ans=true;
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(pair.get(ch)!=null){
                stack.push(ch);
            }
            else{
                char top=stack.peek();
                if(pair.get(top)==ch){
                    stack.pop();
                }
                else{
                    ans=false;
                    break;
                }
            }
        }
        return ans;
    }
}
