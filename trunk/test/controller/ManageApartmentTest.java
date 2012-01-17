/**
 * 
 */
package controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.apartment.Apartment;
import model.apartment.ApartmentRegister;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataAcces.DAO;

/**
 * @author bjrn
 *
 */
public class ManageApartmentTest {

	ApartmentRegister apartmentReg;
	DAO apartmentDAO;
	private ManageApartment m;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}
	
	public static ArrayList<Apartment> randomArrayList(int length)
    {
        ArrayList<Apartment> apartments = new ArrayList<Apartment>(length);
        for (int i=0; i < length; i++)
        {
        	Apartment a1 = new Apartment("", "", i, i, i);
        	apartments.add(a1);
        }
		return apartments;
    }
    

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		 m = new ManageApartment();
		apartmentReg = m.getApartmentReg();
		apartmentDAO = m.getApartmentDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link controller.ManageApartment#registerApartment(int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRegisterApartment() {
		
		String aID = "999";
		String address = "New Earth";
		int rooms = 1;
		int size = 100;
		int priceSqm = 19;
		
		boolean registerApartment = m.registerApartment(new Apartment (aID, address, rooms, size, priceSqm));
		
		Apartment expResult = new Apartment(aID, address, rooms, size, priceSqm);
		
		Apartment result1 = apartmentReg.getApartment(aID);
		Apartment result2 = apartmentDAO.getApartmentDB(aID);
		//TODO: we need .equals() for EACH OBJECT
		assertEquals(expResult.toString(), result1.toString());
		assertEquals(expResult.toString(), result2.toString());
//		testRegisterApartmentLenght();
	}
	

	public void testRegisterApartmentLenght() {
		
		
		for (int i=0; i<10;i++)
			m.registerApartment(randomArrayList(10).get(i)); // we are register apartments from our generated register
		
		ArrayList<Apartment> result = new ArrayList<Apartment>();
		
		for (int i=0; i<10;i++)
			result.add(apartmentDAO.getApartmentDB(i+""));
		
		ArrayList<Apartment> expResult = randomArrayList(10);
		
		assertEquals(expResult.toString(), result.toString());
		  
		
	}

}