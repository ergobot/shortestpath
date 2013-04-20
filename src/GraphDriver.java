
/**
 * class GraphDriver 
 *   initializes a graph
 *      reads the start node
 *      computes distance table
 *      shows paths
 *      repeats upon user request
 * 
 * @author (Lydia Sinapova) 
 * @version (2012)
 */
import java.util.*;
public class GraphDriver
{
    
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int nodes = 7; 
        int edges;
        int start;          // start vertex
        int target;         // vertex to see the path
        String ans1, ans2;  // ans1 - compute with new start vertex
                            // ans2 - see the path to another target vertex
        int [][] dTable = new int[nodes][2];
        
        int [][] graphD = {{0, 1, 0, 4, 0, 0, 0},  // directed weighted graph
                           {0, 0, 0, 5, 4, 0, 0},
                           {3, 0, 0, 2, 0, 6, 0},
                           {0, 0, 0, 0, 0, 3, 2},
                           {0, 0, 0, 1, 0, 0, 0},
                           {0, 0, 0, 0, 0, 0, 2},
                           {0, 0, 0, 0, 3, 0, 0}};
       	ans1 = "y";
	do
	{
		System.out.print("Enter start node: ");
		start = scan.nextInt();
		
// compute distance table		
		Graphs.minWeightPath(start, nodes, graphD, dTable);
		
		Graphs.printDistanceTable(nodes, dTable);

// show paths		
		ans2 = "y";
		do
		{
		System.out.print("Enter a node to see the path : ");
		target = scan.nextInt();
		
		target--;
		Graphs.printMinPath(target,nodes,dTable);
		System.out.print("Another path? (y/n): ");
		ans2 = scan.next();
        }
         while(ans2.equals("y"));
     
		System.out.println("");
     System.out.print("\nSAnother run? (y/n): ");
	 ans1 = scan.next();
    }
     while(ans1.equals("y"));                    

  } 
}
