//Program to find K largest elements in the array 

import java.io.*;
public class MinHeap {
    private int Heap[]; //Array to store the numbers
    private int size; //size of heap as numbers are entered
    private int maxsize; //maximum size alotted to minHeap

    private static final int FRONT = 1; //index of first element used for removing the minimum element at the root
    
    public MinHeap(int maxsize){ //Constructor to initizlize minHeap with initial values
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize+1];
        Heap[0] = Integer.MIN_VALUE; //So that any negative number when compared to Root could easily identify
    }

    //Function to return the position of the parent
    //for the node currently at pos
    private int parent(int pos){
        return pos / 2;
    }

    //function to return the position of the left child for
    //the node currently at pos
    private int leftChild(int pos){
        return (2*pos);
    }

    //function to return the position of the right child for
    //the node currently at pos
    private int rightChild(int pos){
        return (2*pos)+1;
    }

    //Function that returns true if the passed node is a leaf
    //node
    private boolean isLeaf(int pos) 
    {
        if(pos > (size/2) && pos <= size) {
            return true;
        }
        return false;
    }

    //Function to swap two nodes of the heap
    private void swap(int fpos , int spos){
        int tmp=Heap[fpos];
        Heap[fpos]=Heap[spos];
        Heap[spos]=tmp;
    }

    //Function to heapify the node at postion - "pos"
    private void minHeapify(int pos){
        if(!isLeaf(pos)) { //Because if it is a leaf node then it has already been in a correct position
            if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos]>Heap[rightChild(pos)]){
                    if(Heap[leftChild(pos)]<Heap[rightChild(pos)]){
                        swap(pos,leftChild(pos));
                        minHeapify(leftChild(pos));
                    }
                    else{
                        swap(pos,rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
                }
            }
    }

    //Function to insert a node into the heap
    public void insert(int element) {
        if(size >= maxsize) {
            if(Heap[FRONT]<element){
                Heap[FRONT]=element;
                minHeapify(FRONT);
            }
            else{
                return;
            }
        }
        else
        {
        Heap[++size] = element;
        int current = size;

        while(Heap[current] < Heap[parent(current)]) {
            swap(current , parent(current));
            current = parent(current);
        }
    }
    }

    //Function to print the contents of the heap
    public void print() {
        for(int i=1;i<=size/2;i++){
            System.out.print("Parent: "+Heap[i]+" Left Child : "+Heap[2*i]+" Right Child : "+Heap[2*i+1]);
            System.out.println();
        }
    }

    //Function to build the minHeap using minHeapify
    public void minHeap() {
        for(int pos= (size/2); pos>=1 ;pos--){
            minHeapify(pos);
        }
    }

    //Function to remove and return the minimum element from the heap
    public int remove(){
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    //main function
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of largest elements you want to print (K)?");
        int k=Integer.parseInt(br.readLine());
        MinHeap minHeap = new MinHeap(k);
        int arr[]={84,19,56,22,9,28,29,2,31};
        if(k>arr.length){
            System.out.println("Enter atleast k elements in the array next time !");
            System.exit(0);
        }
        for(int x=0;x<arr.length;x++){
            minHeap.insert(arr[x]);
        }
        minHeap.minHeap();
        minHeap.print();
        System.out.println("The kth largest element is "+minHeap.Heap[1]);
    }
}