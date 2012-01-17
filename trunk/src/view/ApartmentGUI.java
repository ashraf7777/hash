package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.apartment.Apartment;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import controller.ManageApartment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ApartmentGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5875531062926132346L;
	private JTextField textAID;
	private JTextField textFieldAddress;
	private JTextField textFieldRooms;
	private JTextField textFieldSize;
	private JTextField textFieldPriceSqm;
	private JTextField textFieldRentPrice;
	private ManageApartment manageApartments;
	private JTable table;
	private DefaultTableModel tm;
	private ArrayList<Apartment> apartments;
	/**
	 * Create the panel.
	 */
	
		

	
	public ApartmentGUI() {
		
		manageApartments = new ManageApartment();
		setLayout(null);
		// all the gui compornets for this panel
		textAID = new JTextField();
		textAID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textAID.setBounds(153, 44, 86, 20);
		add(textAID);
		textAID.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldAddress.setBounds(153, 76, 86, 20);
		add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldRooms = new JTextField();
		textFieldRooms.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldRooms.setColumns(10);
		textFieldRooms.setBounds(153, 107, 86, 20);
		add(textFieldRooms);
		
		textFieldSize = new JTextField();
		textFieldSize.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(153, 138, 86, 20);
		add(textFieldSize);
		
		textFieldPriceSqm = new JTextField();
		textFieldPriceSqm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldPriceSqm.setColumns(10);
		textFieldPriceSqm.setBounds(153, 169, 86, 20);
		add(textFieldPriceSqm);
		
		textFieldRentPrice = new JTextField();
		textFieldRentPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldRentPrice.setColumns(10);
		textFieldRentPrice.setBounds(153, 200, 86, 20);
		add(textFieldRentPrice);
		
		JLabel lblaID = new JLabel("Apartment ID");
		lblaID.setBounds(10, -8, 125, 123);
		add(lblaID);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 12, 80, 144);
		add(lblAddress);
		
		JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setBounds(10, 59, 80, 113);
		add(lblRooms);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(10, 105, 80, 82);
		add(lblSize);
		
		JLabel lblPriceSqm = new JLabel("Price/m²");
		lblPriceSqm.setBounds(10, 152, 80, 51);
		add(lblPriceSqm);
		
		JLabel lblNr = new JLabel("RentPrice");
		lblNr.setBounds(10, 198, 80, 20);
		add(lblNr);
		
		JButton addAparmentButton = new JButton("Add Apartment");
		addAparmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addApartment();
			}
		});
		addAparmentButton.setBounds(10, 243, 121, 23);
		add(addAparmentButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 43, 326, 263);
		add(scrollPane);
		
		Object[] headers = new Object[]{"ID","Address","Rooms","Size","Price/m²","Rent"};
		tm = new DefaultTableModel(new Object[0][0],headers); // creating an empty TableModel with Headers

		table = new JTable(tm);
		scrollPane.setViewportView(table);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textAID, textFieldAddress, textFieldRooms, textFieldSize, textFieldPriceSqm, textFieldRentPrice, addAparmentButton, lblNr, lblPriceSqm, lblSize, lblRooms, lblAddress, lblaID}));

	}
	// we make local var. for the textfields, then calls joptionpane for confirm on going on if we should start registration,
	//then we call the registerApartment method from ManageApartment class, and print out if we are successful in the text area. 
	public void addApartment()
	{		
	    Apartment a1 = getTextFields();
	    int check = JOptionPane.showConfirmDialog(null, "Start Registration ?","chose one", JOptionPane.YES_NO_OPTION);
	    if (check == 0)
	    {
	    	if(manageApartments.registerApartment(a1))
	          {
	    		//TODO: Replace all the annoying JOptionPane with a StatusBar
	    		// preferably present in the MainFrame / DesktopPanel
	    		JOptionPane.showMessageDialog(null, "Registration done\n");
	          }
	    	else
	    		JOptionPane.showMessageDialog(null, "Registration failed \n");
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(null, "Registration cancelled\n");
	    }
		
	}
	
	public ArrayList<Apartment> searchApartment()
	{
		Apartment myApartment = getTextFields();
		apartments = manageApartments.searchApartment(myApartment);
		return apartments;
	}
	
	public void refreshSearch()
	{
		tm.setRowCount(0); // delete old data from the rows
		ArrayList<Apartment> apartments = searchApartment(); //arraylist containing tenants that matched search criteria
		for (Apartment a1: apartments)
			tm.addRow(a1.toArray()); // adding each tennant as a Row in our TableModel
	}
	
	public Apartment getTextFields()
	{
		
		System.out.println("Getting data from TextFields... " + getClass());
		
		String aID = null;
		if (!textAID.getText().equals(""));
			aID = textAID.getText();
			
		String address = null;
		if(!textFieldAddress.getText().equals(""));
			address = textFieldAddress.getText();
		
		int rooms=0;
		try
		{
		if (!textFieldRooms.getText().equals(""))
			rooms = Integer.parseInt(textFieldRooms.getText());
		}
		catch(Exception e){}
		
		int size = 0;
		try
		{
			if (!textFieldSize.getText().equals(""))
			size = Integer.parseInt(textFieldSize.getText());
		}
		catch(Exception e){}
		
		int priceSqm = 0;
		try
		{
			priceSqm = Integer.parseInt(textFieldPriceSqm.getText());
		}
		catch (Exception e){}
		
		int rent = 0;
		try
		{
			rent = Integer.parseInt(textFieldRentPrice.getText());
		}
		catch (Exception e){}
		
		Apartment a1;
		if (rent == 0)
			a1 = new Apartment(aID, address, rooms, size, priceSqm);
		else
			a1 = new Apartment(aID, address, rooms, size, priceSqm, rent);
		System.out.println("Data retrieved from TextFields. " + getClass());
		return a1;
	}
	public DefaultTableModel getTm() {
		return tm;
	}
	public void setTm(DefaultTableModel tm) {
		this.tm = tm;
	}


	
} // End ApartmentGui Class

