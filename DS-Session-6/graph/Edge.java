package graph;

/**
 * This class holds the values of graph for edge
 * Java Comparable interface is used to order the objects of
 * user-defined class.
 */
public class Edge implements Comparable<Edge> {
	private int source;
	private int destination;
	private int weight;

	// Constructor
	public Edge(int source, int destination, int weight) {
		this.setSource(source);
		this.setDestination(destination);
		this.setWeight(weight);
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * This is used to compare the current object with the specified object.
	 */
	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
}