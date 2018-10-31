package dictionary;

/**
 * To create the node of the tree
 */
public class Node {
	private Node leftNode;
	private Node rightNode;
	private KeyValuePair data;

	// Constructor
	public Node(KeyValuePair data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	/**
	 * To set the data
	 * @param data
	 */
	public void setData(KeyValuePair data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public KeyValuePair getData() {
		return data;
	}

	/**
	 * @return the leftNode
	 */
	public Node getLeftNode() {
		return leftNode;
	}

	/**
	 * @return the rightNode
	 */
	public Node getRightNode() {
		return rightNode;
	}

	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}
