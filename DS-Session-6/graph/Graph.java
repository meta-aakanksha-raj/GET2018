package graph;

import java.util.List;

/**
 * It is an interface for undirected weighted graph with different functionalities
 */
public interface Graph {

	/**
	 * To check if all the vertices of the graph are connected or not.
	 * @return - true if connected else returns false
	 */
    public boolean isConnected();

    /**
     * To find list of nodes which are reachable from a particular node
     * @param source - is the source from where we have to start 
     * @return - the list of reachable nodes from the source
     */
    public List<Integer> reachable(int source);
 
    /**
     * To get minimum spanning tree
     * @return - the list of edges of minimum spanning tree
     */
    public List<Edge> minimumSpanningTree();
 
    /**
     * To get the shortest path from one particular node to another
     * @param source
     * @param destination
     * @return - the shortest path
     */
    public int shortestPath(int source, int destination);
}