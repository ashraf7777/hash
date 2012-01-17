package controller;

import java.util.ArrayList;

import dataAcces.DAO;
import model.apartment.Apartment;
import model.apartment.ApartmentRegister;

public class ManageApartment {
	private ApartmentRegister apartmentReg;
	private DAO dao;
	private Apartment a;
	
	public ManageApartment() {
		super();
		apartmentReg = new ApartmentRegister();
	    dao = new DAO();
	    
	}
	//check if there is a Apartment by the apartmentId if not register one by the parameters and return true, else it return false if there is one.
	
	public boolean registerApartment(Apartment a1)
    {
		boolean ok = false;
        a = apartmentReg.getApartment(a1.getaID());
       if (a == null)
           
        {
    	   ok = dao.addApartmentDB(a1);
    	   if (ok = true)
    		   ok = apartmentReg.registerApartment(a1);
           return ok;
        }
       
       else
            return ok;
        
   
    }
	/**
	 * @return the apartmentReg
	 */
	public ApartmentRegister getApartmentReg() {
		return apartmentReg;
	}
	/**
	 * @return the apartmentDAO
	 */
	public DAO getApartmentDAO() {
		return dao;
	}
	/**
	 * @param apartmentReg the apartmentReg to set
	 */
	public void setApartmentReg(ApartmentRegister apartmentReg) {
		this.apartmentReg = apartmentReg;
	}
	/**
	 * @param apartmentDAO the apartmentDAO to set
	 */
	public void setApartmentDAO(DAO apartmentDAO) {
		this.dao = apartmentDAO;
	}

	public ArrayList<Apartment> searchApartment(Apartment myApartment) {
		ArrayList<Apartment> apartments = dao.searchApartment(myApartment);
		return apartments;
	}

	
	
}
