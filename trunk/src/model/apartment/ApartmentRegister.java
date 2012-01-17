package model.apartment;

import java.util.ArrayList;


public class ApartmentRegister {
	
private ArrayList<Apartment> apartments;

public ApartmentRegister() {
	
	apartments = new ArrayList<Apartment>();
	
//	String aID, String address, int size, int rooms, int priceSqm
//	
}
// register a apartment and add in to the arraylist apartments. and return true
	
	public boolean registerApartment(Apartment a1)
		{
		apartments.add(a1);
		return true;	

		}

// find a apartment in the apartmentRegister by the apartment id. 
public Apartment getApartment(String aID)
{
	
	        String myaID;
	        for (Apartment a : apartments) {
	        	myaID = a.getaID();
	            if (myaID.equals(aID)) {
	                return a;
	            }
	        }
	        return null; // not found

	    
}

}
