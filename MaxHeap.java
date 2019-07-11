//There are N bags each containing different amounts of chocolates.
//There is a Wizard and a Kid
//At each second , kid eats all the chocolates from the bag
//containing maximum number of chocolates.
//Wizard fills the bag with half the amount of chocolates.
//Find the total number of chocolates eaten by the child after T seconds.
import java.io.*;
public class MaxHeap {
    private int size;
    private int Heap[];
    private int maxsize;

    private static final int FRONT=1;

    public MaxHeap(int maxsize){
        this.maxsize=maxsize;
        this.size=0;
        Heap = new int[this.maxsize+2];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos){ return pos/2; }
    private int leftChild(int pos){ return (2*pos); }
    private int rightChild(int pos){ return (2*pos)+1; }

    private boolean isLeaf(int pos){
        if(pos>(size/2) && pos<=size) { return true;} 
        else {return false;}
    }

    private void swap(int fpos,int spos){
        int temp=Heap[fpos];
        Heap[fpos]=Heap[spos];
        Heap[spos]=temp;
    }

    private void maxHeapify(int pos){
        if(!isLeaf(pos)){
            if(Heap[pos]<Heap[leftChild(pos)] || Heap[pos]<Heap[rightChild(pos)]){
                if(Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                    swap(pos,leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else{
                    swap(pos,rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element){
        if(size>=maxsize){
            System.out.println("Cannot add more elements!");
            return;
        }
        Heap[++size] = element;
        int current = size;
        while(Heap[current] > Heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }

    public void maxHeap() {
        for(int pos = (size/2) ; pos>=1 ; pos--){
            maxHeapify(pos);
        }
    }

    public int remove(){
        int chocolates = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return chocolates;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of bags?");
        int n=Integer.parseInt(br.readLine());
        int bags[]=new int[n];
        MaxHeap maxHeap = new MaxHeap(n);
        for(int x=0;x<n;x++){
            System.out.println("Enter amount of chocolates for bag : "+(x+1));
            bags[x] = Integer.parseInt(br.readLine());
            maxHeap.insert(bags[x]);
        }
        maxHeap.maxHeap();
        int sum=0;
        System.out.println("Enter the time (t) for which the kid eats chocolates?");
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            int amount = maxHeap.remove();
            sum+=amount;
            maxHeap.insert(amount/2);
        }
        System.out.println("The total amount of chocolates eaten = "+sum);
    }
}
