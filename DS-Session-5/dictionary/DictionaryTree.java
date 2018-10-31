/**
 * 
 */
package dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Dictionary interface.
 */
public class DictionaryTree implements Dictionary {
	private Node RootNode;

	/**
	 * The constructor will receive a list of key value pairs to be inserted in the dictionary
	 * @param listOfInitialInput input list
	 */
	public DictionaryTree(List<KeyValuePair> listOfInitialInput) {
		this.RootNode = null;
		for (KeyValuePair pair : listOfInitialInput) {
			this.add(pair.getKey(), pair.getValue());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see dictionary.Dictionary#add(int, java.lang.String)
	 */
	@Override
	public boolean add(int key, String value) {
		Node newNode = new Node(new KeyValuePair(key, value));
		return addNewNode(RootNode, newNode, key);
	}

	/**
	 * Inserting node in tree
	 * @param currentNode is the present node
	 * @param newNode to be inserted
	 * @param key which we want to add to the current node
	 * @return true if added else false
	 */
	private boolean addNewNode(Node currentNode, Node newNode, int key) {
		boolean flag = false;
		if (RootNode == null) {
			RootNode = newNode;
			flag = true;
		} else {
			if (key > currentNode.getData().getKey()) {
				if (currentNode.getRightNode() == null) {
					currentNode.setRightNode(newNode);
					flag = true;
				} else {
					flag = addNewNode(currentNode.getRightNode(), newNode, key);
				}
			} else if (key < currentNode.getData().getKey()) {
				if (currentNode.getLeftNode() == null) {
					currentNode.setLeftNode(newNode);
					flag = true;
				} else {
					flag = addNewNode(currentNode.getLeftNode(), newNode, key);
				}
			}
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * @see dictionary.Dictionary#delete(int)
	 */
	@Override
	public boolean delete(int key) {
		boolean isNodeDeletedFlag = false;
		if (isNodeExist(key)) {
			Node currentNode = RootNode;
			RootNode = deleteNode(currentNode, key);
			isNodeDeletedFlag = true;
		}
		return isNodeDeletedFlag;
	}

	/**
	 * Getting the parentNode of key
	 * @param currentNode is the node for which we want to search for parent
	 * @param key the node contains
	 * @return the parent node
	 */
	private Node getParentNode(Node currentNode, int key) {
		Node parentNode = currentNode;
		if (parentNode.getData().getKey() == key) {
			return null;
		}

		while (true) {
			if (key > parentNode.getData().getKey()) {
				if (parentNode.getRightNode().getData().getKey() == key) {
					break;
				} else {
					parentNode = parentNode.getRightNode();
				}
			} else {
				if (parentNode.getLeftNode().getData().getKey() == key) {
					break;
				} else {
					parentNode = parentNode.getLeftNode();
				}
			}
		}
		return parentNode;
	}

	/**
	 * Getting the current node address of the key
	 * @param currentNode
	 * @param key
	 * @return the node address
	 */
	private Node getCurrentNode(Node currentNode, int key) {

		Node parentNode = getParentNode(currentNode, key);
		if (parentNode == null) {
			return currentNode;
		}
		Node tempNode = null;
		if (parentNode.getRightNode() != null && parentNode.getRightNode().getData().getKey() == key) {
			tempNode = parentNode.getRightNode();
		} else if (parentNode.getLeftNode() != null && parentNode.getLeftNode().getData().getKey() == key) {
			tempNode = parentNode.getLeftNode();
		}
		return tempNode;
	}

	/**
	 * Helper method for deleting the node from the tree
	 * @param RootNode
	 * @param key
	 * @return the deleted node
	 */
	private Node deleteNode(Node RootNode, int key) {
		// if tree is empty
		if (RootNode == null) {
			return null;
		}

		Node parentNode = getParentNode(RootNode, key);
		Node currentNode = getCurrentNode(RootNode, key);

		// case 1: node which is being deleted has no child
		if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
			if (currentNode != RootNode) {
				if (parentNode.getRightNode() == currentNode) {
					parentNode.setRightNode(null);
				} else if (parentNode.getLeftNode() == currentNode) {
					parentNode.setLeftNode(null);
				}
			} else {
				RootNode = null;
			}
		}

		// case 2: node which is being deleted has two children
		else if (currentNode.getLeftNode() != null && currentNode.getRightNode() != null) {
			Node successor = getMinimumKeyNode(currentNode.getRightNode());
			currentNode.setData(successor.getData());
			currentNode = deleteNode(currentNode.getRightNode(), successor.getData().getKey());
		}
		
		// node to be deleted has only one child
		else {
			Node childOfCurrentNode = currentNode.getLeftNode() == null ? currentNode
					.getRightNode() : currentNode.getLeftNode();

			if (currentNode != RootNode) {
				if (parentNode.getLeftNode() == currentNode) {
					parentNode.setLeftNode(childOfCurrentNode);
				} else {
					parentNode.setRightNode(childOfCurrentNode);
				}
			} else {
				RootNode = childOfCurrentNode;
				return RootNode;
			}
		}
		return RootNode;
	}

	/**
	 * Getting the minimum key value node from the subtree
	 * @param currentNode
	 * @return the minimum key value node
	 */
	private Node getMinimumKeyNode(Node currentNode) {
		while (currentNode.getLeftNode() != null) {
			currentNode = currentNode.getLeftNode();
		}
		return currentNode;
	}

	/**
	 * Checking if key exist or not in current binary tree
	 * @param key for which we want to search for
	 * @return true if found else returns false
	 */
	private boolean isNodeExist(int key) {
		boolean isNodeFoundFlag = false;
		Node currentNode = RootNode;
		while (currentNode != null) {
			if (key > currentNode.getData().getKey()) {
				currentNode = currentNode.getRightNode();
			} else if (key < currentNode.getData().getKey()) {
				currentNode = currentNode.getLeftNode();
			} else {
				isNodeFoundFlag = true;
				break;
			}
		}
		return isNodeFoundFlag;
	}

	/*
	 * (non-Javadoc)
	 * @see dictionary.Dictionary#getValue(int)
	 */
	@Override
	public String getValue(int key) {
		return getValueOfKey(RootNode, key);
	}

	/**
	 * Helper method which returns the string value of current key value
	 * @param currentNode
	 * @param key whose value we want
	 * @return the value
	 */
	private String getValueOfKey(Node currentNode, int key) {
		String valueCorrespondingSpecifiedKey = "";
		try {
			if (currentNode.getData().getKey() == key) {
				valueCorrespondingSpecifiedKey = currentNode.getData().getValue();
			}
			else {
				if (key > currentNode.getData().getKey()) {
					valueCorrespondingSpecifiedKey = getValueOfKey(currentNode.getRightNode(), key);
				}
				else if (key < currentNode.getData().getKey()) {
					valueCorrespondingSpecifiedKey = getValueOfKey(currentNode.getLeftNode(), key);
				}
			}
			return valueCorrespondingSpecifiedKey;
		} catch (Exception e) {
			return "NO SUCH DATA EXIST IN MAP ERROR: " + e.getMessage();
		}
	}

	/*
	 * To get sorted list of binary tree through in order traversal
	 * (non-Javadoc)
	 * @see dictionary.Dictionary#getSortedListOfKeyValuePair()
	 */
	@Override
	public List<KeyValuePair> getSortedListOfKeyValuePair() {
		List<KeyValuePair> sortedList = new ArrayList<KeyValuePair>();
		getSortedList(RootNode, sortedList);
		return sortedList;
	}

	/**
	 * helper method for getting the sorted list
	 * @param currentNode is the node where we are
	 * @param sortedList
	 */
	private void getSortedList(Node currentNode, List<KeyValuePair> sortedList) {
		if (currentNode != null) {
			getSortedList(currentNode.getLeftNode(), sortedList);
			sortedList.add(currentNode.getData());
			getSortedList(currentNode.getRightNode(), sortedList);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see dictionary.Dictionary#getSortedListOfKeyValuePairInRange(int, int)
	 */
	@Override
	public List<KeyValuePair> getSortedListOfKeyValuePairInRange(int keyFirst, int keySecond) {
		List<KeyValuePair> listOfSortedKeyValuePair = getSortedListOfKeyValuePair();
		for (int index = 0; index < listOfSortedKeyValuePair.size(); index++) {
			if (listOfSortedKeyValuePair.get(index).getKey() < keyFirst 
					|| listOfSortedKeyValuePair.get(index).getKey() > keySecond) {
				listOfSortedKeyValuePair.remove(index);
				index--;
			}
		}
		return listOfSortedKeyValuePair;
	}
}
