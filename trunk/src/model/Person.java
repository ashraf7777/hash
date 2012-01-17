/**
 * 
 */
package model;

/**
 * @author Daniel Șerbănescu
 * @version 0.1
 */
public class Person {
	private String name;
	private String address;
	private String ID;
	/**
	 * @param name The name of the person
	 * @param address The current address of the person
	 * @param iD The ID of the person
	 */
	public Person(String iD, String name, String adress) {
		this.name = name;
		this.address = adress;
		ID = iD;
	}
	/**
	 * @return the name of the Person
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set for the Person
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address of the Person
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set for the Person
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the ID of the Person 
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set for the Person
	 */
	public void setID(String iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return  name + "#" + address + "#" + ID;
	}
	
	
	
	
}
