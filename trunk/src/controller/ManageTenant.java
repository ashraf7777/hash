/**
 * 
 */
package controller;

import java.util.ArrayList;

import dataAcces.DAO;

import model.apartment.Apartment;
import model.tenant.Tenant;
import model.tenant.TenantRegister;


/**
 * @author Bjørn, Daniel
 * @version pre-alpha
 */
public class ManageTenant {
	
	private static final ManageTenant INSTANCE = new ManageTenant();
	private TenantRegister register;
	/**
	 * Default constructor
	 */
	private ManageTenant() {
		register = TenantRegister.getInstance();
	}

	/**
	 * @return the instance of this Singleton
	 */
	public static ManageTenant getInstance() {
		return INSTANCE;
	}

	public boolean registerTennant(Tenant myTenant) {	
		return register.registerTennant(myTenant);
	}

	public ArrayList<Tenant> searchTenant(Tenant myTenant) {
		return register.searchTenant(myTenant);
		
	}
	
	public void updateTenant(Tenant oldTenant, Tenant newTenant)
	{
		register.updateTenant(oldTenant,newTenant);
		
	}
	
	public void link(Apartment a1,Tenant t1)
	{
		DAO.getInstance().link(a1, t1);
	}

public ArrayList<Apartment> searchTenant(ArrayList<Tenant> tenants)
	
	{
		ArrayList <Apartment> apartments = register.searchTenant(tenants);
		return apartments;
		
	}





}
