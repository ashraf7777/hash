/**
 * 
 */
package model.tenant;


import java.util.ArrayList;

import model.apartment.Apartment;

import dataAcces.DAO;

/**
 * @author bjrn
 * @version pre-alpha
 * @
 */
public class TenantRegister {
	
	private ArrayList <Tenant> tenants;
	private DAO dao;
	private static final TenantRegister INSTANCE = new TenantRegister();

	/**
	 * Main constructor... sets a new collection of tenants ready for working and opens dao for usage
	 *  ### same as tenants = new ArrayList<Tenant>()
	 */
	private TenantRegister() {
		setTenants(new ArrayList<Tenant>());
		dao = DAO.getInstance();
	}


	/**
	 * @return tennants (a collection containing Tenant objects)
	 */
	public ArrayList <Tenant> getTenants() {
		return tenants;
	}


	/**
	 * @param tenants the tennants to set
	 */
	public void setTenants(ArrayList <Tenant> tennants) {
		this.tenants = tennants;
	}


	/**
	 * @return the instance
	 */
	public static TenantRegister getInstance() {
		return INSTANCE;
	}

	/**
	 * 
	 * @param aTenant is the object we want to compare with the objects inside ArrayList and DB
	 * @return statement whether object already exists or not, in system
	 */
	public boolean registerTennant(Tenant aTenant) {
		boolean ok = false;
		for (Tenant myTenant:tenants)// were taking each element within the ArrayList
		{
			if (myTenant.equals(aTenant)) // we are comparing the new tenant with the ones present in ArrayList
				ok = true; //if statement is correct we are changing ok to be true
		}
		Tenant dbTenant = dao.getTenant(aTenant.getID());
		System.out.println("Comparing " + aTenant +" with the one in db "+ dbTenant + getClass());
		if (dbTenant != null) //&& aTenant.equals(dbTenant)) // we are comparing the new tenant with the one in DB
		ok = true; // if statement is correct we are changing ok to be true
		
		if (ok == false) // if tenant doesn't exist proceed with adding
		{
			this.tenants.add(aTenant);
			this.dao.insertTenant(aTenant);
		}
		
		
		return ok;
		
	}
	
	public void updateTenant(Tenant oldTenant, Tenant newTenant)
	{
		System.out.println(tenants.toString());
		int index;
		if (tenants.size()>0)
		{
			index = tenants.lastIndexOf(oldTenant);
			Tenant t1 = tenants.get(index);
			t1.setTenant(newTenant);
		}
		dao.updateTenant(oldTenant,newTenant);
	}


	public ArrayList<Tenant> searchTenant(Tenant myTenant) {
		ArrayList<Tenant> tenants = dao.searchTenant(myTenant);
		return tenants;
	}


	@Override
	public String toString() {
		String megaString = "ArrayList with " + tenants.size() + " elements\n";
		for (Tenant t1: tenants)
			megaString += t1.toString();
		return megaString;
	}
	
	public ArrayList<Apartment> searchTenant(ArrayList<Tenant> tenants)
	
	{
		ArrayList <Apartment> apartments = dao.searchTenant(tenants);
		return apartments;
		
	}
	

}
