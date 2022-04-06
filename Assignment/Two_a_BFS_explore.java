package Assignment;

import java.util.LinkedList;
import java.util.Queue;

public class Two_a_BFS_explore {
    int vertex;
    int increment=0;
    int matrix[][];
   boolean[] visited = {false, false, false, false, false, false, false, false};
    int []exploring = new int[8];
    int []explored = new int[8];
    Queue<Integer> q
            = new LinkedList<>();

    public Two_a_BFS_explore(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination) {
        //add edge
        matrix[source][destination]=1;

        //add back edge for undirected graph
        matrix[destination][source] = 0;
    }

    public void BFS(int node)
    {
        
        
    }

    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        System.out.print("   ");
        for (int i = 0; i < vertex; i++) {
            if(i==1)System.out.print("B: ");
            else if(i==2)System.out.print("C: ");
            else if(i==3)System.out.print("D: ");
            else if(i==4)System.out.print("E: ");
            else if(i==5)System.out.print("F: ");
            else if(i==6)System.out.print("G: ");
            else if(i==7)System.out.print("H: ");

            for (int j = 0; j <vertex ; j++) {
            if(i==0 && j==0)
            {
                System.out.print("A ");
                System.out.print("B ");
                System.out.print("C ");
                System.out.print("D ");
                System.out.print("E ");
                System.out.print("F ");
                System.out.print("G ");
                System.out.println("H ");
                System.out.print("A: ");
            }
            
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Two_a_BFS_explore object = new Two_a_BFS_explore(8);
        int A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7; 
        object.addEdge(A,B);
        object.addEdge(A,C);
        object.addEdge(B,C);
        object.addEdge(B,D);
        object.addEdge(B,E);
        object.addEdge(C,F);
        object.addEdge(D,G);
        object.addEdge(E,C);
        object.addEdge(E,D);
        object.addEdge(E,F);
        object.addEdge(E,G);
        object.addEdge(E,H);
        object.addEdge(F,H);
        object.addEdge(H,G);

        object.printGraph();

        object.BFS(A);
    }
}
