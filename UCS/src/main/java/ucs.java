import java.util.LinkedList;

public class ucs {
    private int Node; //Total number of nodes, 10 in this example
    private int adj[][]; //Adjacency matrix which contains the costs between each pair of nodes
    
    //We need a list containing both the nodes and their costs from start node. Let's divide the list in two lists:
    private LinkedList<Integer> list_node; //List for containing the nodes
    private LinkedList<Integer> list_cost; //List for containing the their costs

    public ucs(int n) //Constructor
    {
        //Initializing class variables
        Node = n;
        adj=new int[n][n];
        list_node=new LinkedList<Integer>();
        list_cost=new LinkedList<Integer>();
    }
    
    void addEdge(int u, int v, int cost)
    {
        adj[u][v]=cost; //We're storing the cost between node u and v
    }
    
    int find_lowest_cost_index(LinkedList<Integer> list_cost)
    {
        //We're finding lowest cost from "list_cost" in conventional way. 
        //We can't use priority queue or sort the "list_cost" because there is another list "list_node" associated with it. 
        //Sorting the "list_cost" will result in mismatch with "list_node"
        int lowest_cost=999; 
        int lowest_cost_index=-1;
        for(int i=0; i<list_cost.size(); i++)
        {
            int temp=list_cost.get(i); //Getting i-th element from "list_cost" 
            if(temp<lowest_cost) 
            {
                lowest_cost=temp;
                lowest_cost_index=i;
            }
        }
        return lowest_cost_index;
    }
    
    void solve_ucs(int s, int g1, int g2, int g3)
    {
        list_node.add(s); //Adding start node "s" to the list_node
        list_cost.add(0); //Adding cost of of start node "s"=0 to the list_cost
        //Remember both "list_node" and "list_cost" should go parallely
        
        
        while(list_node.isEmpty()!=true)
        {
            //At each iteation find out the lowest cost. To find that first find out the index of the lowest cost.
            int lowest_cost_index = find_lowest_cost_index(list_cost); 
         
            
            int popped_node = list_node.get(lowest_cost_index); //Getting the node with lowest cost
            int popped_node_cost = list_cost.get(lowest_cost_index); //Getting the cost of the node with lowest cost
            
            list_node.remove(lowest_cost_index); //Remove the seleced node from list_node
            list_cost.remove(lowest_cost_index); //Remove the seleced node's cost from list_cost
            
            if(popped_node==g1 || popped_node==g2 || popped_node==g3) return; //If the node is the goal then return to main
            
            //Finding out the adjacent nodes of the selected node 
            for(int i=0; i<Node; i++)
            {
                if(adj[popped_node][i]!=0) //There is an adjacency only if the cost is non-zero
                {
                    int total_cost=popped_node_cost+adj[popped_node][i]; //Total cost of a node = cost of the previous node(popped_node) + it's own cost in adjacency matrix
                    System.out.println("Added to list:   "+i+"\t"+total_cost); //Print out the sequence of nodes in the list
                    list_node.add(i); //Add node i to the "list_node"
                    list_cost.add(total_cost); //Add cost of node i to the "list_cost" parallely
                }
            }
        }
    }
    
    
    public static void main(String args[])
    {
        ucs graph = new ucs(10);
        int S=0,A=1,B=2,C=3,D=4,E=5,F=6,G1=7,G2=8,G3=9;
        graph.addEdge(S, A, 5);
        graph.addEdge(S, B, 9);
        graph.addEdge(S, D, 6);
        graph.addEdge(A, B, 3);
        graph.addEdge(A, G1, 9);
        graph.addEdge(B, A, 2);
        graph.addEdge(B, C, 1);
        graph.addEdge(C, S, 6);
        graph.addEdge(C, F, 7);
        graph.addEdge(C, G2, 5);
        graph.addEdge(D, C, 2);
        graph.addEdge(D, E, 2);
        graph.addEdge(E, G3, 7);
        graph.addEdge(F, D, 2);
        graph.addEdge(F, G3, 8);
        
        graph.solve_ucs(S,G1,G2,G3);
        
       }
}
