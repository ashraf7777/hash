/**
 * 
 */
package view;

import static org.junit.Assert.*;

import javax.swing.JFrame;
//import javax.swing.JTextField;

import model.apartment.Apartment;

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
public class TestApartmentGUI {

	private ApartmentGUI apartmentGUI;
	private JFrame s;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		apartmentGUI = new ApartmentGUI();
		s = new JFrame();
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}


	/**
	 * Test method for {@link view.ApartmentGUI#addApartment()}.
	 */
	@Test
	public void testAddApartment() {
		
//		apartmentGUI.getTextFieldAid().setText("1");
//		apartmentGUI.getTextFieldEntPlace().setText("F");
//		apartmentGUI.getTextFieldFloor().setText("100");
//		apartmentGUI.getTextFieldNr().setText("1999");
//		apartmentGUI.getTextFieldRoom().setText("10");
//		apartmentGUI.getTextFieldSize().setText("1000");
		
		
		
	
		
		
		
		s.add(apartmentGUI);
		s.setBounds(500, 500, 500, 500);
		s.setVisible(true);
		
		apartmentGUI.addApartment();
		
		DAO dao = new DAO();
		// TODO: To FINISH
		Apartment expResult = new Apartment (null, null, 0, 0, 0);
		
		Apartment result = dao.getApartmentDB(1+"");
		
		System.out.println(expResult.equals(result));
		assertEquals(expResult, result);
	}

}
