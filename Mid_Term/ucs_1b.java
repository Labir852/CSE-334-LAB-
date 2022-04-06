package Mid_Term;

import java.util.LinkedList;

public class ucs_1b 
{
    
    private int Node; 
    private int adj[][]; 
    
   
    private LinkedList<Integer> list_node; 
    private LinkedList<Integer> list_cost; 

    public ucs_1b(int n) 
    {
        
        Node = n;
        adj=new int[n][n];
        list_node=new LinkedList<Integer>();
        list_cost=new LinkedList<Integer>();
    }
    
    void addEdge(int u, int v, int cost)
    {
        adj[u][v]=cost; 
    }
    
    int find_lowest_cost_index(LinkedList<Integer> list_cost)
    {
        
        int lowest_cost=999; 
        int lowest_cost_index=-1;
        for(int i=0; i<list_cost.size(); i++)
        {
            int temp=list_cost.get(i); 
            if(temp<lowest_cost) 
            {
                lowest_cost=temp;
                lowest_cost_index=i;
            }
        }
        return lowest_cost_index;
    }
    
    void solve_ucs(int s, int g)
    {
        list_node.add(s); 
        list_cost.add(0); 
      
        
        
        while(list_node.isEmpty()!=true)
        {
            
            int lowest_cost_index = find_lowest_cost_index(list_cost); 
         
            
            int popped_node = list_node.get(lowest_cost_index); 
            int popped_node_cost = list_cost.get(lowest_cost_index); 
            
            list_node.remove(lowest_cost_index); 
            list_cost.remove(lowest_cost_index);
            System.out.print("-> "+popped_node);
           
            
            if(popped_node==g)
            {
                System.out.println("\nTotal Fuel cost: "+popped_node_cost);
                return; 
            } 
            
            
            for(int i=0; i<Node; i++)
            {
                if(adj[popped_node][i]!=0) 
                {
                    int total_cost=popped_node_cost+adj[popped_node][i]; 
                    list_node.add(i); 
                    list_cost.add(total_cost); 
                }
            }
            
        }
        
    }
    
    public static void main(String[] args) 
    {
        ucs_1b graph = new ucs_1b(7);
        int S=0,A=1,B=2,C=3,D=4,E=5,G=6;
        graph.addEdge(S, A, 1);
        graph.addEdge(S, C, 2);
        graph.addEdge(S, E, 6);
        graph.addEdge(A, B, 3);
        graph.addEdge(A, C, 1);
        graph.addEdge(B, D, 3);
        graph.addEdge(C, D, 1);
        graph.addEdge(C, G, 2);
        graph.addEdge(D, G, 4);
        graph.addEdge(E, G, 6);
        
        graph.solve_ucs(S,G);
       
    }
}
    

