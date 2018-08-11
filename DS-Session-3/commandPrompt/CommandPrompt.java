package commandPrompt;

/**
 * To create a virtual Command Prompt (VCP) for managing virtual directories
 * where a few operations/commands will be supported
 */
public class CommandPrompt {
	public final Directory ROOTNODE;
	public Directory currentNode;
	private String currentPath;

	//Constructor
	public CommandPrompt() {
		ROOTNODE = new Directory("E>", null, "E:\\");
		this.currentPath = ROOTNODE.getPath();
		currentNode = ROOTNODE;
	}

	/**
	 * checking whether the command is valid or not	
	 * @param command entered by user
	 * @return true if command is correct else returns false
	 */
	public boolean isValidCommand(String command) {
		boolean flag = false;
		String splittedCommand[] = command.split(" ");
		if ((splittedCommand[0].equals("exit") || splittedCommand[0].equals("ls")
				|| splittedCommand[0].equals("bk") || splittedCommand[0].equals("tree"))
				&& (splittedCommand.length == 1)) {
			flag = true;
		}
		if ((splittedCommand[0].equals("cd") || splittedCommand[0].equals("mkdir") || splittedCommand[0]
				.equals("find")) && (splittedCommand.length == 2)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * checking if newNode is already available in the list
	 * @param newNode made by user
	 * @return true if node already exists else returns false
	 */
	private boolean doesNewNodeExists(Directory newNode) {
		boolean flag = false;

		for (Directory node : currentNode.getChildList()) {
			if (node.getName().equals(newNode.getName())) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * for creating the directory by using mkdir(make directory)
	 * @param NodeName is the new directory made
	 * @return
	 */
	public boolean makeDirectory(String NodeName) {
		String pathOfTheNode = new String(currentPath + NodeName + ">");

		Directory newNode = new Directory(NodeName, currentNode, pathOfTheNode);
		if (!doesNewNodeExists(newNode)) {
			currentNode.addChildNode(newNode);
		} else {
			throw new RuntimeException("Cannot be added.. file already exist");
		}
		return true;
	}

	/**
	 * checking whether a particular node exist or not	
	 * @param nameOfNode to search
	 * @return true if exists else false
	 */
	private boolean doesNodeNameExistInChildListOfCurrentNode(String nameOfNode) {
		boolean flag = false;
		for (Directory node : currentNode.getChildList()) {
			if (node.getName().equals(nameOfNode)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	/**
	 * getting the node object through name by using find command
	 * @param nameOfNode user wants to search
	 * @return all the nodes in which node of that name is present 
	 */
	private Directory getChildNodeObjectOfCurrentNodeByNameOfNode(String nameOfNode) {
		Directory found = null;
		for (Directory node : currentNode.getChildList()) {
			if (node.getName().equals(nameOfNode)) {
				found = node;
			}
		}
		return found;
	}

	/**
	 * changing the current directory to another directory by using cd(change directory)
	 * @param nameOfNode is the directory to which user want to switch to
	 * @return true if that Node is present in the current node else throws error
	 */
	public boolean changeDirectory(String nameOfNode) {
		if (doesNodeNameExistInChildListOfCurrentNode(nameOfNode)) {
			currentNode = getChildNodeObjectOfCurrentNodeByNameOfNode(nameOfNode);
			currentPath = currentNode.getPath();
		} else {
			throw new RuntimeException("directory does not exist in current directory");
		}
		return true;
	}

	/**
	 * moving back to parent directory by using bk(back)
	 * @return true if switched to parent directory else returns false
	 */
	public boolean moveBackToParentDirectory() {
		boolean flag = false;
		if (!currentNode.equals(ROOTNODE)) {
			currentNode = currentNode.getParent();
			currentPath = currentNode.getPath();
			flag = true;
		}
		return flag;
	}

	/**
	 * getting the list of all directory which are present 
	 * in current level by using command ls(list)	
	 * @return list of child nodes with time of creation
	 */
	public String getListOfAllDirectoryOfFirstLevel() {
		StringBuffer allDirectory = new StringBuffer();

		for (Directory node : currentNode.getChildList()) {
			allDirectory.append(node.getName() + "\t"+ node.getTime().toString() + "\n");
		}
		return allDirectory.toString();
	}

	/**
	 * finding path of nodeName	
	 * @param nodeName is the node for which we have to find path
	 * @return directs to getNodePath method which would give the required path of the node
	 */
	public String findPaths(String nodeName) {
		StringBuffer pathOfNodeName = new StringBuffer("");
		return getNodePath(nodeName, pathOfNodeName, currentNode).toString();
	}

	/**
	 * calling recursively the same function 	
	 * @param nodeName is the node for which we have to find the path
	 * @param pathOfNodeName
	 * @param current is the current node
	 * @return path of the node
	 */
	private StringBuffer getNodePath(String nodeName, StringBuffer pathOfNodeName,
			Directory current) {
		if ("R".equals(nodeName)) {
			return new StringBuffer(currentPath);
		} else {
			for (Directory node : current.getChildList()) {
				if (node.getName().equals(nodeName)) {
					pathOfNodeName.append(node.getPath() + "\n");
				}
				if (node.getChildList().size() == 0) {
					continue;
				} else {
					pathOfNodeName.append("\n");
					getNodePath(nodeName, pathOfNodeName, node);
				}
			}
		}
		return pathOfNodeName;
	}

	/**
	 * getting the tree of the current Directory by using tree command
	 * @return directs to getWholeTree method which would give the whole structure of tree
	 */
	public String getTree() {
		StringBuffer treePath = new StringBuffer("");
		int numberOfSpaces = 0;
		return getWholeTree(treePath, currentNode, numberOfSpaces).toString();
	}

	/**
	 * getting the whole tree through recursion  	
	 * @param treePath
	 * @param current is the current node
	 * @param numberOfSpaces
	 * @return the path of tree
	 */
	private StringBuffer getWholeTree(StringBuffer treePath, Directory current, int numberOfSpaces) {
		int nodeIndex = 0;
		for (Directory node : current.getChildList()) {
			if (nodeIndex == 0) {
				treePath.append(getSymbolForFirstNewNode(numberOfSpaces)
						+ node.getName());

			} else {
				treePath.append(getSymbolForOtherNewNode(numberOfSpaces)
						+ node.getName());

			}
			nodeIndex++;
			if (node.getChildList().size() == 0) {
				continue;
			} else {
				treePath.append("\n" + getSpace(numberOfSpaces));

				int newNumberSpaces = numberOfSpaces + 3;
				getWholeTree(treePath, node, newNumberSpaces);
			}
		}
		return treePath;
	}

	/**
	 * getting structure for first node
	 * @param num is number of space
	 * @return the structure
	 */
	private String getSymbolForFirstNewNode(int numberOfSpaces) {
		return getSpace(numberOfSpaces) + "\u2514" + "\u2500"; // |__
	}

	/**
	 * getting structure for other nodes
	 * @param numberOfSpaces
	 * @return the structure
	 */
	private String getSymbolForOtherNewNode(int numberOfSpaces) {
		return "\n" + getSpace(numberOfSpaces) + "\u251c" + "\u2500"; // |---
	}

	/**
	 * For getting the required space
	 * @param numberOfSpace
	 * @return spaces
	 */
	private String getSpace(int numberOfSpace) {
		String spaces = "";
		for (int i = 0; i < numberOfSpace; i++) {
			spaces += " ";
		}
		return spaces;
	}

	/**
	 * @return the currentPath
	 */
	public String getCurrentPath() {
		return currentPath;
	}
}
