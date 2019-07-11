//Program For Directed Graph
/*
import java.util.*;
import java.io.*;
class DepthFirstSearch{

    private int V; //No. of vertices
    private LinkedList<Integer> adj[]; //Array of lists for Adjacency List Representation
    //Constructor
    public DepthFirstSearch(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }

    //Function to add an edge to Graph to a directed graph
    void addEdge(int v,int w){
        adj[v].add(w);
    }

    //function used by dfs
    void DFS(int v,boolean visited[]){
        visited[v]=true;
        System.out.print(v+" ");

        //Recur for all vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n=i.next();
            if(!visited[n])
                DFS(n,visited);
        }
    }
    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        boolean visited[]=new boolean[g.V];
        g.DFS(1, visited);
    }
}
*/

//Program for undirected graph
import java.util.*;
import java.io.*;
class DepthFirstSearch{

    private int V; //No. of vertices
    private LinkedList<Integer> adj[]; //Array of lists for Adjacency List Representation
    private boolean visited[];//array to mark visited nodes
    //Constructor
    public DepthFirstSearch(int v){
        V=v;
        adj=new LinkedList[v];
        visited=new boolean[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }

    //Function to add an edge to Graph to a directed graph
    void addEdge(int v,int w){
        adj[v].add(w);
    }

    //function used by dfs
    void DFS(int v){
        visited[v]=true;
        System.out.print(v+" ");

        //Recur for all vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n=i.next();
            if(!visited[n])
                DFS(n);
        }
    }
    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 5);
        for(int i=0;i<g.V;i++){
            if(g.visited[i]==false)
                g.DFS(i);
        }
    }
}

