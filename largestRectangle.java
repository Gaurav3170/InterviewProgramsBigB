//Program is to find the area of largest rectangle in a histogram
//E.g. histogram = [1,2,3,4,5,3,3,2] 
/*
                 __
              __|  |
           __|  |  |__ __
        __|  |  |  |  |  |__
     __|  |  |  |  |  |  |  |
    |__|__|__|__|__|__|__|__|
      1  2  3  4  5  3  3  2

      Maximum area= 15 sq cm .

*/
import java.util.*;
class largestRectangle{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array of histogram ?");
        String inp[]=sc.nextLine().split(" ");
        int hist[]= new int[inp.length];
        for(int i=0;i<hist.length;i++){
            hist[i]=Integer.parseInt(inp[i]);
        }
        int max_area=maxHistogram(hist);
        System.out.println("The largest rectangular area in this histogram is : "+max_area);
        sc.close();
    }
    public static int maxHistogram(int height[]){
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;
    
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
    
            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
    
        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
    
            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
    
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
    
        return maxArea;
    }
}