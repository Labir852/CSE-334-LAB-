import java.util.*; 

public class dfs {
    
    private int Node;
    private LinkedList<Integer>adj_list[];
    private Stack<Integer>stack;
    
    dfs(int n)
    {
       Node=n;
       adj_list=new LinkedList[n];
       for(int i=0; i<n; i++)
       {
           adj_list[i]=new LinkedList<>();
       }
       stack=new Stack<Integer>();
    }
    
    void addEdge(int u, int v)
    {
        adj_list[u].add(v);
    }
    
    void solve_dfs(int start, int goal)
    {
        boolean visited[]=new boolean[Node];
        int count=0;
        int parent[]=new int[Node];
        
        visited[start]=true;
        count++;
        stack.push(start);
        
        while(stack.empty()!=true)
        {
           int popped_node=stack.pop();
            System.out.println(popped_node);
            if (popped_node==goal) 
            {
                System.out.println("Goal node has been found");
                System.out.println("Total number of nodes visited before goal node: "+count);
                return;
            }
           
           for(int i=0; i<adj_list[popped_node].size(); i++)
           {
               int adj_node=adj_list[popped_node].get(i);
               parent[adj_node]=popped_node;
               
               if(visited[adj_node]==false)
               {
                    visited[adj_node]=true;
                    count++;
                    stack.push(adj_node);
               }
           }
        }
    }
    
    
    public static void main(String args[])
    {
        dfs graph = new dfs(8);
        int A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7;
        
        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(B, E);
        graph.addEdge(C, F);
        graph.addEdge(D, G);
        graph.addEdge(E, H);
        graph.addEdge(E, G);
        graph.addEdge(E, C);
        graph.addEdge(E, D);
        graph.addEdge(E, F);
        graph.addEdge(F, H);
        graph.addEdge(H, G);
        
        graph.solve_dfs(A,G);
    }
    
}
