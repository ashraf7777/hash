package model.tenant;

import java.sql.Date;

import model.Person;


/**
 * @author Bjørn, Daniel
 * @version 0.3
 */

public class Tenant extends Person {
	
	public int tenantNO;
	public Date startDate;
	public Date stopDate;
	
	
	
	
	
	/**
	 * @param name - name of the Tenant
	 * @param address - address of the Tenant
	 * @param iD - Tenant's Identification Document Number
	 * @param tenantNO - Tenant number recorded in the system
	 * @param startDate - the date when renting period begins, NULL forbidden
	 * @param stopDate - the date when renting period ends, NULL for indefinite
	 */
	public Tenant(String name, String address, String iD, int tenantNO,
			Date startDate, Date stopDate) {
		super(name, address, iD);
		this.tenantNO = tenantNO;
		this.startDate = startDate;
		this.stopDate = stopDate;
	}
	/**
	 * @return the tennantNO
	 */
	public int getTenantNO() {
		return tenantNO;
	}
	/**
	 * @param tennantNO the tennantNO to set
	 */
	public void setTenantNO(int tennantNO) {
		this.tenantNO = tennantNO;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the stopDate
	 */
	public Date getStopDate() {
		return stopDate;
	}
	/**
	 * @param stopDate the stopDate to set
	 */
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "\nID: " + getID() + "\nName: " + getName()
				+ "\nAddress: " + getAddress() + "\nTennantNumber: "
				+ getTenantNO() + "\nStartDate: " + getStartDate()
				+ "\nStopDate: " + getStopDate() ;
	}
	
	public String toDBString() {

			return "\'" + getID() + "\',\'" + getName()
					+ "\',\'" + getAddress()
					+ "\',\'" + getStartDate()
					+ "\'," + getStopDate();
	}
	public Object[] toArray() {
		Object[] o = new Object[5];
		o[0] = getID();
		o[1] = getName();
		o[2] = getAddress();
		o[3] = getStartDate();
		o[4] = getStopDate();
		return o;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null)
		{
			Tenant t1 = (Tenant) obj;
			if (t1.getID().equals(getID())
			&& t1.getName().equals(getName())
			&& t1.getStartDate().equals(getStartDate())
			&& t1.getStopDate().equals(getStopDate())
			&& t1.getAddress().equals(getAddress()))
				return true;
			else
				return false;
		}
		else return false;
	}
	
	public void setTenant(Tenant tenant)
	{
		
		this.setID(tenant.getID());
		this.setName(tenant.getName());
		this.setStartDate(tenant.getStartDate());
		this.setAddress(tenant.getAddress());
		this.setStopDate(tenant.getStopDate());
				
	}
	
	
	
	
	
	
}
