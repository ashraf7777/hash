/**
 * 
 */
package model.apartment;

import java.util.Vector;

/**
 * @author bjrn
 *
 */
public class Apartment {
	
	private String aID;
	private String address;
	private int size;
	private int rooms;
	private int priceSqm;
	private int rent;
	/**
	 * @param aID
	 * @param address
	 * @param size
	 * @param rooms
	 * @param priceSqm
	 */
	public Apartment(String aID, String address, int size, int rooms,
			int priceSqm) {
		this.aID = aID;
		this.address = address;
		this.size = size;
		this.rooms = rooms;
		this.priceSqm = priceSqm;
		setRent(priceSqm * size);
	}
	public Apartment(String aID, String address, int rooms, int size,
			int priceSqm, int rent) {
		this.aID = aID;
		this.address = address;
		this.size = size;
		this.rooms = rooms;
		this.priceSqm = priceSqm;
		this.setRent(rent);
	}
	/**
	 * @return the aID
	 */
	public String getaID() {
		return aID;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @return the rooms
	 */
	public int getRooms() {
		return rooms;
	}
	/**
	 * @return the priceSqm
	 */
	public int getPriceSqm() {
		return priceSqm;
	}
	/**
	 * @param aID the aID to set
	 */
	public void setaID(String aID) {
		this.aID = aID;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	/**
	 * @param priceSqm the priceSqm to set
	 */
	public void setPriceSqm(int priceSqm) {
		this.priceSqm = priceSqm;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Apartment [aID=" + aID + ", address=" + address + ", size="
				+ size + ", rooms=" + rooms + ", priceSqm=" + priceSqm + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aID == null) ? 0 : aID.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + priceSqm;
		result = prime * result + rooms;
		result = prime * result + size;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Apartment a1 = (Apartment) obj;
		if  (a1.getaID().equals(aID) && a1.getAddress().equals(address) && 
				a1.getPriceSqm() == priceSqm  && a1.getRooms() == rooms && a1.getSize() == size)
			return true;
		else 
			return false;
	}
	
	public String toDBString() {

		return "\'" + getaID() + "\',\'" + getAddress()
				+ "\'," + getSize()
				+ "," + getRooms()
				+ "," + getPriceSqm()
				+ "," + getRent();
		
}
	/**
	 * @return the rent
	 */
	public int getRent() {
		return rent;
	}
	/**
	 * @param rent the rent to set
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
	public Object[] toArray() {
		Object[] o = new Object[6];
		o[0] = getaID();
		o[1] = getAddress();
		o[2] = getSize();
		o[3] = getRooms();
		o[4] = getPriceSqm();
		o[5] = getRent();
		System.out.println(o);
		return o;
	}
	
	
	
	

}
