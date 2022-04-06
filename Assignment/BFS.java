
import java.util.LinkedList;
import java.util.Queue;


public class BFS {
    private int Node;
    private int Goal_node = 6;
    int count = 0;
    private LinkedList<Integer>adj_List[];
    private Queue<Integer>queue;
    

    BFS(int n)
    {
        Node = n;
        adj_List = new LinkedList[n];
        for (int i = 0; i < n; i++) 
        {
            adj_List[i] = new LinkedList<>();
            queue = new LinkedList<>();

        }
    }

    void solve_BFS(int start)
    {
        boolean []visited = new boolean[Node];
        int []parent = new int[Node];
        //taking start node and pushing into stack
         visited[start] = true;
         count++;
         queue.add(start);
         //stack if is not empty continue pushing and popping.
         while (queue.isEmpty() == false)
         {
            int popped_node = queue.remove();
            System.out.print(popped_node+" ");

            if(popped_node == Goal_node)
            {
                System.out.println(" Goal Node Found ");
                System.out.println("Total number of nodes visited: "+count);
                return;
            }
            for(int i=0;i<adj_List[popped_node].size();i++)
            {
                int adj_node = adj_List[popped_node].get(i);
                parent[adj_node] = popped_node;
                if(visited[adj_node] == false)
                {
                    visited[adj_node] = true;
                    count++;
                    queue.add(adj_node);
                }
            }
         }
    }

    void addEdge(int source, int destination)
    {
        adj_List[source].add(destination);
    }
    public static void main(String[] args) 
    {
        BFS graph = new BFS(8);
        int A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7; 
        graph.addEdge(A,B);
        graph.addEdge(A,C);
        graph.addEdge(B,C);
        graph.addEdge(B,D);
        graph.addEdge(B,E);
        graph.addEdge(C,F);
        graph.addEdge(D,G);
        graph.addEdge(E,C);
        graph.addEdge(E,D);
        graph.addEdge(E,F);
        graph.addEdge(E,G);
        graph.addEdge(E,H);
        graph.addEdge(F,H);
        graph.addEdge(H,G); 
        graph.solve_BFS(A);
    }
}
