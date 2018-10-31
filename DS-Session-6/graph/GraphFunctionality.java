/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * To provide implementation to the Graph interface to obtain certain informations
 */
public class GraphFunctionality implements Graph {
	int noOfVertices;
	List<Edge>[] edgeList;

	@SuppressWarnings("unchecked")
	public GraphFunctionality(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		edgeList = new LinkedList[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			edgeList[i] = new LinkedList<Edge>();
		}
	}

	/**
	 * To add edges to the list
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdge(int source, int destination, int weight) {
		edgeList[source].add(new Edge(source, destination, weight));
		edgeList[destination].add(new Edge(destination, source, weight));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graph.Graph#isConnected()
	 */
	@Override
	public boolean isConnected() {
		Boolean[] nodeTraversed = new Boolean[noOfVertices];
		boolean isConnected = true;

		for (int i = 0; i < noOfVertices; i++) {
			nodeTraversed[i] = false;
		}

		dfsTraversal(0, nodeTraversed);

		for (int i = 0; i < noOfVertices; i++) {
			if (nodeTraversed[i] == false) {
				isConnected = false;
				break;
			}
		}
		return isConnected;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graph.Graph#reachable(int)
	 */
	@Override
	public List<Integer> reachable(int source) {
		List<Integer> reachableNodes = new ArrayList<>();
		Boolean[] nodeTraversed = new Boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			nodeTraversed[i] = false;
		}

		dfsTraversal(source, nodeTraversed);

		for (int i = 0; i < noOfVertices; i++) {
			if (i != source && nodeTraversed[i] == true) {
				reachableNodes.add(i);
			}
		}
		return reachableNodes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graph.Graph#minimumSpanningTree()
	 */
	@Override
	public List<Edge> minimumSpanningTree() {
		List<Edge> minSpanningTree;
		int parent[] = new int[noOfVertices];
		int key[] = new int[noOfVertices];
		Boolean mstSet[] = new Boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < noOfVertices - 1; count++) {
			int u = minKey(key, mstSet);

			mstSet[u] = true;
			List<Edge> edges = edgeList[u];

			for (int v = 0; v < noOfVertices; v++) {
				for (Edge listEdges : edges) {
					if (listEdges.getDestination() == v) {
						if (listEdges.getWeight() != 0 && !mstSet[v]
								&& listEdges.getWeight() < key[v]) {
							parent[v] = u;
							key[v] = listEdges.getWeight();
						}
					}
				}
			}
		}

		minSpanningTree = new ArrayList<>();

		for (int i = 1; i < noOfVertices; i++) {
			List<Edge> edges = edgeList[i];
			for (Edge edgeConnected : edges) {
				if (edgeConnected.getDestination() == parent[i]) {
					Edge edge = new Edge(parent[i], i,
							edgeConnected.getWeight());
					minSpanningTree.add(edge);
				}
			}
		}
		return minSpanningTree;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graph.Graph#shortestPath(int, int)
	 */
	@Override
	public int shortestPath(int source, int destination) {
		List<Edge> adjacentEdges = new LinkedList<>();
		int distance[] = new int[noOfVertices];

		Boolean processed[] = new Boolean[noOfVertices];

		for (int i = 0; i < noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
			processed[i] = false;
		}

		distance[source] = 0;

		for (int count = 0; count < noOfVertices - 1; count++) {
			int shortestDistanceNode = minKey(distance, processed);
			processed[shortestDistanceNode] = true;
			adjacentEdges = edgeList[shortestDistanceNode];

			for (int v = 0; v < noOfVertices; v++) {
				for (Edge listEdges : adjacentEdges) {
					if (listEdges.getDestination() == v) {
						if (!processed[v] && listEdges.getWeight() != 0	&& distance[shortestDistanceNode] != Integer.MAX_VALUE
								&& distance[shortestDistanceNode] + listEdges.getWeight() < distance[v]) {
							distance[v] = distance[shortestDistanceNode]
									+ listEdges.getWeight();
						}
					}
				}
			}
		}

		return distance[destination];
	}

	/**
	 * It finds the index of smallest value in distance array
	 * @param distance
	 * @param processed
	 * @return index of smallest value
	 */
	private int minKey(int distance[], Boolean processed[]) {
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int vertex = 0; vertex < noOfVertices; vertex++) {
			if (processed[vertex] == false && distance[vertex] < min) {
				min = distance[vertex];
				minIndex = vertex;
			}
		}

		return minIndex;
	}

	/**
	 * it traverse to all the vertices of graph and if it is possible then changes that boolean value to true
	 * @param graphNode
	 * @param nodeTraversed
	 */
	private void dfsTraversal(int graphNode, Boolean[] nodeTraversed) {
		nodeTraversed[graphNode] = true;

		Iterator<Edge> iterator = edgeList[graphNode].iterator();

		while (iterator.hasNext()) {
			int node = iterator.next().getDestination();

			if (!nodeTraversed[node]) {
				dfsTraversal(node, nodeTraversed);
			}
		}
	}
}
