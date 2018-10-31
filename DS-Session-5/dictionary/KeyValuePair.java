package dictionary;

/**
 * This is the class for generating key value pair
 */
public class KeyValuePair {

	private int key;
	private String value;

	public KeyValuePair(int key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("{" + key + "," + value + "}");
	}
}