package Mid_Term;

import java.util.Stack;

public class IDDFS_2b {

    private int numberOfNodes;
    private int depth;
    private int maxDepth;
    private boolean goalFound = false;
    int count = 0;
    private Stack<Integer>stack;
    private static int[][] adj_matrix;
    

    IDDFS_2b(int n)
    {
        
        stack = new Stack<Integer>();
        adj_matrix = new int[n][n];
    }

    
    public void IDDFS(int adjacencyMatrix[][], int destination)
    {
        numberOfNodes = adjacencyMatrix[1].length - 1;
        while (!goalFound)
        {
            depthLimitedSearch(adjacencyMatrix, 0, destination);
            maxDepth++;
        }
        System.out.println("\nGoal Found at depth " + depth);
    }
 
    private void depthLimitedSearch(int adjacencyMatrix[][], int source, int goal)
    {
        int element, destination = 1;
        int[] visited = new int[numberOfNodes + 1];
        stack.push(source);
        depth = 0;
        System.out.println("\nAt Depth " + maxDepth);
        System.out.print(source + "\t");
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            while (destination <= numberOfNodes)
            {
                if (depth < maxDepth)
                {
                    if (adjacencyMatrix[element][destination] == 1)
                    {
                        stack.push(destination);
                        visited[destination] = 1;
                        System.out.print(destination + "\t");
                        depth++;
                        if (goal == destination)
                        { 
                            goalFound = true;
                            return;
                        }
                        element = destination;
                        destination = 1;
                        continue;
                    }
                } else 
                {
                    break;
                }
                destination++;
            }
            destination = stack.pop() + 1;
            depth--;
        }
    }

   static void addEdge(int source, int destination)
    {
        adj_matrix[source][destination] = 1;
    }
    public static void main(String[] args) {
        IDDFS_2b graph = new IDDFS_2b(9);
        int A=0,B=1,C=2,D=3,E=4,F=5,G=6,H=7,I=8; 
        graph.addEdge(A,B);
        graph.addEdge(A,D);
        graph.addEdge(B,E);
        graph.addEdge(B,C);
        graph.addEdge(C,F);
        graph.addEdge(D,E);
        graph.addEdge(D,G);
        graph.addEdge(E,F);
        graph.addEdge(E,H);
        graph.addEdge(F,I);
        graph.addEdge(G,H);
        graph.addEdge(H,I); 
        graph.IDDFS(adj_matrix, I);
    }
    
}
