/**
 * Class Graphs contains static methods to implement graph algorithms. Methods
 * to be implemented: public static void minWeightPath(int start, int nodes, int
 * [][] graph, int [][] dTable) computes dTable for ditected weighted graphs
 * 
 * public static int computeEdges(int nodes, int [][]graph) computes the number
 * of edges given the adjacency matrix
 * 
 * public static void printWeightMinPath(int nodes, int [][] dTable) prints the
 * distance table for weighted graph
 * 
 * public static void printMinPath(int target,int nodes,int [][]dTable) prints
 * the path to a specified node
 * 
 * @author ()
 * @version
 */
public class Graphs {
	public static void minWeightPath(int start, int nodes, int[][] graph,
			int[][] dTable) {
		
		start--;
		
		// #1
		// Compute the number of edges in the graph (use computeEdges)
		int totalEdges = Graphs.computeEdges(nodes, graph);
				
		// #2
		// Initialize distance table with -1, 
		// and 0 in the row for the start vertex
		for(int i = 0; i < nodes; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				if(i == start)
				{
					dTable[i][j] = 0;
				}
				else
				{
					dTable[i][j] = -1;
				}
			}
		}
		
		// #3
		// Create an object of type Cell to
		// contain the start vertex with key = 0
		Cell cell = new Cell(0,start);
		
		// #4
		// declare  and instantiate a priority queue
		// of type PQueueCell with size = totalEdges
		PQueueCell priorityQueue = new PQueueCell(totalEdges);		
		
		// #5
		// Insert the start vertex (as a Cell object)
		// in the priority queue 
		priorityQueue.insert(cell);
		
		/* 6#
		 * while queue is not empty
		 * 
		 * DeleteMin a vertex v from the queue For all adjacent vertices w:
		 * compute new_distance if distance to w not computed or new distance is
		 * better store new_distance and parent v of w in the distance table
		 * store w in the queue with priority = new_distance
		 */
		while(!priorityQueue.isEmpty())
		{
			// # 6.1
			// DeleteMin a vertex v from the queue
			Cell vertex = priorityQueue.deleteMin();
			
			// # 6.2
			
			int indexNode = vertex.getItem();
			
			
			// For all adjacent vertices w
			for(int adjacentNode = 0; adjacentNode < nodes; adjacentNode++)
			{
				int edge = graph[indexNode][adjacentNode];
				// graph is the graphD in driver 
				
				// This means that it is an connected
				if(edge != 0)
				{
					// Compute the new distance;
					// new_distance = DT(v,0) + distance(v,w)
					int newDistance = dTable[indexNode][0] + edge;
			
					// If the distance to w not computed (DT(w,0) = -1) or the computed
					// distance is greater than the new distance:
					if(dTable[adjacentNode][0] == -1 || 
					   dTable[adjacentNode][0] > newDistance)
					{
						// store new distance in table : DT(w,0) = new_distance
						dTable[adjacentNode][0] = newDistance;
						// insert w in the priority queue with priority new_distance
						priorityQueue.insert(new Cell(newDistance,adjacentNode));
						// record the parent of w, i.e. DT(w,1) = v
						dTable[adjacentNode][1] = (vertex.getItem());
					}
					
				}
				
				
			}
		}
		
		
		
	}

	/*------------------ compute edges -------------------------------*/
	public static int computeEdges(int nodes, int[][] graph) {
		int edges = 0;

		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				if (graph[i][j] != 0) {

					edges++;
				}

			}

		}

		return edges;
	}

	/*-------------------- print distance table ---------------------------*/
	public static void printDistanceTable(int nodes, int[][] dTable) {
		
		
		for(int i = 0; i < dTable.length; i++)
		{
			for(int j = 0; j < dTable[0].length; j++)
			{
				if(j == 0)
				{
					System.out.print(dTable[i][j] + " ");
				}
				else if (j == 1)
				{
					System.out.print((dTable[i][j] + 1) + " ");
				}
			}
			// New row
			System.out.print("\n");
		}
		System.out.print("\n");
		
		// o finito di typare
	}

	/*----------------------- print path to node --------------------------*/
	public static void printMinPath(int target, int nodes, int[][] dTable) {

		if(dTable[target][0] == 0)
		{
			System.out.print(target+1);
			return;
		}
		else
		{
			printMinPath(dTable[target][1],nodes,dTable);
			//System.out.print(dTable[target-1][1]);
			System.out.print(" ," + (target+1));
			return;
		}
		
		
		//		target--;
		
		// get the parent
//		int parent = dTable[target][1];

		// if the parent is not 0, then go to next parent
//		if(parent != 0)
//		{
//			System.out.print("target = " + (target+1) + " \n");
//
//			int nextParent = dTable[parent][1];
//			System.out.println("Next parent = " + (nextParent +1)+ " \n");
//			// Print the parent
////						System.out.print("parent = " + (parent + 1) + " \n\n");
//			
//			// go to the next parent
//			printMinPath(parent,nodes,dTable);
//		}
//		else
//		{
////			System.out.print("Else parent: " + (parent+1) + "\n");
//			System.out.print("Else target: " + (target+1) + "\n");
//		}

	}
}
