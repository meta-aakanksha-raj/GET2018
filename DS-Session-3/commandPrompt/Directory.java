package commandPrompt;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

/**
 * To create a node for making directory
 */
public class Directory {
	private String name;
	private Directory parent;
	private List<Directory> childList = new ArrayList<Directory>();
	private String path;

	private Date time;

	//Constructor
	public Directory(String name, Directory parent, String path) {
		this.name = name;
		this.parent = parent;
		this.path = path;
		time = new Date();
	}

	/**
	 * To get the childlist
	 * @return the childList
	 */
	public List<Directory> getChildList() {
		return childList;
	}
	
	/**
	 * To get the time of creation of that node
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}


	/**
	 * @param childList the childList to set
	 */
	public void setChildList(List<Directory> childList) {
		this.childList = childList;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the parent
	 */
	public Directory getParent() {
		return parent;
	}

	/**
	 * To add the child node to the list
	 * @param node
	 * @return the list after adding the node
	 */
	public boolean addChildNode(Directory node) {
		return childList.add(node);
	}
}