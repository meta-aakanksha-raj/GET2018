package dictionary;

import java.util.List;

/**
 * Interface for a dictionary and implementing it using a binary search tree.
 * This dictionary would support various features.
 * The list of key value pairs to be inserted in dictionary will be provided as a JSON value.
 */
public interface Dictionary {

	/**
	 * To add a key value pair to dictionary
	 * @param key to be added
	 * @param value to be added corresponding to that key
	 * @return true if key is added else returns false
	 */
	public boolean add(int key, String value);

	/**
	 * To delete a key value pair from the dictionary
	 * @param key to be deleted
	 * @return true if key is deleted else returns false
	 */
	public boolean delete(int key);

	/**
	 * To get the value corresponding to a specified key
	 * @param key whose value we want to fetch
	 * @return the value corresponding to that key
	 */
	public String getValue(int key);

	/**
	 * To get sorted list of key value pairs
	 * @return sorted list of key value pairs
	 */
	public List<KeyValuePair> getSortedListOfKeyValuePair();

	/**
	 * To get the sorted list of key value pairs for all the keys >=K1 and <=K2
	 * @param keyFirst is first key
	 * @param keySecond is second key
	 * @return the sorted list of key value pairs for all the keys >=K1 and <=K2
	 */
	public List<KeyValuePair> getSortedListOfKeyValuePairInRange(int keyFirst, int keySecond);
}