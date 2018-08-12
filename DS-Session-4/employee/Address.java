package employee;

/**
 * This is the class to store the address of the Employee
 */
public class Address {
	private int houseNo;
	private String locality;
	private String city;

	//Constructor of address to initialise the Address class variables
	public Address(int houseNo,String locality,String city)
	{
		this.houseNo = houseNo;
		this.locality = locality;
		this.city = city;
	}

	/**
	 * To get the house number
	 * @return the house number
	 */
	public int getHouseNo() {
		return houseNo;
	}

	/**
	 * To get the locality
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * To get the city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}	
}
