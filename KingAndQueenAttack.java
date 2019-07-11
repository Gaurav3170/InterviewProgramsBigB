/* 
Program to return true if king and queen can attack each other
*/
import java.util.*;
class KingAndQueenAttack{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the kings coordinates?");
        String inp_king[]=sc.nextLine().split(" ");
        int kx=Integer.parseInt(inp_king[0]);
        int ky=Integer.parseInt(inp_king[1]);
        System.out.println("Enter the queen coordinates?");
        String inp_queen[]=sc.nextLine().split(" ");
        int qx=Integer.parseInt(inp_queen[0]);
        int qy=Integer.parseInt(inp_queen[1]);
        boolean ans=willAttack(kx,ky,qx,qy);
        if(ans){
            System.out.println("King is threatened by Queen!");
        }
        else{
            System.out.println("King is not threatened by the Queen!");
        }
        sc.close();
    }

    public static boolean willAttack(int kx,int ky,int qx,int qy){
        if(qx==kx || qy==ky || qx+qy==kx+ky || Math.abs(ky-qy)==Math.abs(kx-qx)){
            return true;
        }
        return false;
    }
}