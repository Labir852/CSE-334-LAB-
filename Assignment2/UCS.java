package Assignment2;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class UCS {

    private int Node;
    private LinkedList<Integer>adj_List[];
    PriorityQueue<Integer> CumulativeList = new PriorityQueue<Integer>();
    int[][] Cost = new int[10][10];
    int []parent = new int [10];
    int i = 0;
    public UCS(int N)
    {
        Node = N;
        adj_List = new LinkedList[N];
        for(int i=0; i<Node; i++)
        {
            adj_List[i] = new LinkedList<>();
        }  
    }

    public void solve_UCS(int start, int []goal)
    {
        boolean []visited = new boolean[Node];
        visited[start] = true;
        CumulativeList.add(start);
        while(CumulativeList.isEmpty() == false)
        {
            int removedNode = CumulativeList.remove();
            System.out.println(removedNode);
            for (int i = 0; i < 3; i++) 
            {
                if(removedNode == goal[i])
                {
                    System.out.println("Found Goal node: G"+(i+1));
                    return;
                }
            }
            


            for(int i=0;i<adj_List[removedNode].size();i++)
            {
                int adj_node = adj_List[removedNode].get(i);
                parent[adj_node] = removedNode;
                if(visited[adj_node] == false)
                {
                    visited[adj_node] = true;
                    CumulativeList.add(adj_node+Cost[parent[adj_node]][adj_node]);
                }
            }
        }
       
    }


    void addEdge(int source, int destination,int cost)
    {
        adj_List[source].add(destination);
        Cost[source][destination] = cost;
    }
    public static void main(String[] args) 
    {
        UCS graph = new UCS(10);
        int S=0,A=1,B=2,C=3,D=4,E=5,F=6,G1=7,G2=8,G3=9; 
        graph.addEdge(S,A,5);
        graph.addEdge(S,B,9);
        graph.addEdge(S,D,6);
        graph.addEdge(A,B,3);
        graph.addEdge(A,G1,9);
        graph.addEdge(B,A,2);
        graph.addEdge(B,C,1);
        graph.addEdge(C,F,7);
        graph.addEdge(C,G2,5);
        graph.addEdge(C,S,6);
        graph.addEdge(D,C,2);
        graph.addEdge(D,E,2);
        graph.addEdge(E,G3,7);
        graph.addEdge(F,D,2);
        graph.addEdge(F,G3,8);
        int []goal = new int[3];
        goal[0] = G1;
        goal[1] = G2;
        goal[2] = G3;
        graph.solve_UCS(S,goal);
        
    }
    
}
