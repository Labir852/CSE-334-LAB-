package Assignment;

public class One_a_DFS_explore {
    int vertex;
    int increment=0;
    int matrix[][];
   boolean[] visited = {false, false, false, false, false, false, false, false};
    int []exploring = new int[8];
    int []explored = new int[8];

    public One_a_DFS_explore(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination) {
        //add edge
        matrix[source][destination]=1;

        //add back edge for undirected graph
        matrix[destination][source] = 0;
    }

    public void DFS(int node)
    {
        System.out.print(" "+node); 
        exploring[increment] = node;
        if (node == 6)
        {
            System.out.println(" Found Goal node");
            return;
        }
        visited[node] = true;
        for(int i = 0; i <=7;i++)
        {
           if(matrix[node][i] == 1 && !visited[i])
           {
               DFS(i);
           }
        }
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
        One_a_DFS_explore object = new One_a_DFS_explore(8);
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

        object.DFS(A);

        for(int i = 0; i<=7; i++)
        {
            for(int j = 0; j<=7;j++)
            {
                
            }
        }

    }
}
