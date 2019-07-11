import java.util.*;

class Coordinates{
    int x,y;
    public Coordinates(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class overlappingRectangles{
    public static int areaOverlap(Coordinates B1,Coordinates T1,Coordinates B2,Coordinates T2){
        int area=0;
        int length,width;
        int overlapBottomX,overlapBottomY,overlapTopX,overlapTopY;
        overlapBottomX=Math.max(B1.x,B2.x);
        overlapBottomY=Math.max(B1.y,B2.y);
        overlapTopX=Math.min(T1.x,T2.x);
        overlapTopY=Math.min(T1.y,T2.y);
        length=overlapTopX-overlapBottomX;
        width=overlapTopY-overlapBottomY;
        area=length*width;
        return area;
    }
    public static void main(String[] args) {
        Coordinates B1 = new Coordinates(-4,0);
        Coordinates T1 = new Coordinates(-1,3);
        Coordinates B2 = new Coordinates(-3,1);
        Coordinates T2 = new Coordinates(-2,2);
        int ans= areaOverlap(B1, T1, B2, T2);
        if(ans<=0){
            System.out.println("The rectangles do not overlap!");
        }
        else{
            System.out.println("The area of overlapping rectangles = "+ans+" square cm.");
        }
    }
}
