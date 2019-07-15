/*Coin Game Of Two Corners -- Greedy Approach 
Consider a two player coin game where each player gets turn 
one by one. There is a row of even number of coins, and a 
player on his/her turn can pick a coin from any of the two 
corners of the row. The player that collects coins with more 
value wins the game. Develop a strategy for the player 
making the first turn, such he/she never looses the game.

Approach : Since there are even number of coins,
therefore if 1st player chooses 1st index(odd one) then 2nd player will have to 
chose between 2nd index and nth index(both are even)
if 1st player chooses nth index(even one) , then 2nd player 
is left with options of 1st and (n-1)th index .

So if we know the sum of even indexes element and sum of odd indexes element,
we can decide  what the first player should choose so at the end 
he will always win.

*/
class coinGame{
    public static void main(String[] args) {
        int arr1[]={20, 30, 2, 2, 2};
        display(arr1);
    }
    public static void display(int arr[]){
        int oddSum=0,evenSum=0;
        for(int i=0;i<arr.length;i++){
            if(i%2==0)
                evenSum+=arr[i];
            else
                oddSum+=arr[i];
        }
        int start_index = (evenSum>oddSum)?0:1;
        for(int x=start_index;x<arr.length;x+=2){
            System.out.print(arr[x]+" ");
        }
    }
}
