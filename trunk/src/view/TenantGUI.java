package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.apartment.Apartment;
import model.tenant.Tenant;
import controller.ManageApartment;
import controller.ManageTenant;

	/**
	 * @author Daniel Șerbănescu
	 * @version 0.3 
	 */
public class TenantGUI extends JPanel {
	private static final long serialVersionUID = -1198366844901637498L;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldStartDate;
	private JTextField textFieldStopDate;
	private ManageTenant tenantController;
	private JTable table;
	private JScrollPane scrollPane_1;
	private DefaultTableModel tm;
	private ArrayList<Tenant> tenants;
	/**
	 * Create the panel.
	 */
	public TenantGUI() {
		setForeground(UIManager.getColor("nimbusRed"));
		setBackground(UIManager.getColor("Button.background"));
		
		tenantController = ManageTenant.getInstance();
		
		textFieldID = new JTextField();
		textFieldID.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldID.setBounds(12, 57, 114, 19);
		textFieldID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldName.setBounds(12, 116, 114, 19);
		textFieldName.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldAddress.setBounds(12, 174, 114, 19);
		textFieldAddress.setColumns(10);
		
		textFieldStartDate = new JTextField();
		textFieldStartDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldStartDate.setBounds(12, 240, 114, 19);
		textFieldStartDate.setColumns(10);
		
		textFieldStopDate = new JTextField();
		textFieldStopDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				refreshSearch();
			}
		});
		textFieldStopDate.setBounds(12, 300, 114, 19);
		textFieldStopDate.setColumns(10);
		
		JLabel jLabelID = new JLabel("ID");
		jLabelID.setBounds(36, 30, 60, 15);
		
		JLabel jLabelName = new JLabel("name");
		jLabelName.setBounds(36, 89, 60, 15);
		
		JLabel jLabelAddress = new JLabel("address");
		jLabelAddress.setBounds(36, 147, 60, 15);
		
		JLabel JlabelStartDate = new JLabel("startDate");
		JlabelStartDate.setBounds(36, 213, 90, 15);
		
		JLabel jLabelStopDate = new JLabel("stopDate");
		jLabelStopDate.setBounds(36, 273, 90, 15);
		
		JButton btnAddTennant = new JButton("add Tennant");
		btnAddTennant.setBackground(new Color(255, 0, 0));
		btnAddTennant.setBounds(12, 347, 222, 27);
		btnAddTennant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerTennant();
			}
		});
		setLayout(null);
		add(textFieldID);
		add(textFieldName);
		add(textFieldAddress);
		add(textFieldStartDate);
		add(textFieldStopDate);
		add(jLabelID);
		add(jLabelName);
		add(jLabelAddress);
		add(JlabelStartDate);
		add(jLabelStopDate);
		add(btnAddTennant);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(255, 45, 404, 385);
		add(scrollPane_1);
		
		
		Object[] headers = new Object[]{"ID","Name","Address","StartDate","StopDate"};
		tm = new DefaultTableModel(new Object[0][0],headers); // creating an empty TableModel with Headers

		table = new JTable(tm);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateTenant();
			}
		});
		scrollPane_1.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	}
	
	protected void updateTenant() {
		int index = table.getSelectedRow();
		Tenant oldTenant = tenants.get(index); // getting the Old Tenant from the searchResult that should happen before updateing
		
		//Extracting data from JTable
		String ID = (String) tm.getValueAt(index, 0);		
		String name = (String) tm.getValueAt(index, 1);
		String address = (String) tm.getValueAt(index, 2);
		Date startDate =  Date.valueOf(tm.getValueAt(index, 3).toString());
		Date stopDate = null;
		if (tm.getValueAt(index, 4) != null)
		stopDate = Date.valueOf(tm.getValueAt(index, 4).toString());
		// Creating a new Tenant containing the changes
		Tenant newTenant = new Tenant(ID, name, address, 0, startDate, stopDate);
		tenantController.updateTenant(oldTenant, newTenant); //replacing the old Tenant with the updated one
		
	}

	public void registerTennant()
	{
		System.out.println("Starting registering the tenant... " + getClass()); 
		Tenant myTenant = getTextFields();
		
		int check =  JOptionPane.showConfirmDialog(getParent(), myTenant); //Check if you want to proceed
		if (check == 0)
		{
		
			boolean ok = tenantController.registerTennant(myTenant);// Proceed and ask for a boolean
			if (ok == true) // tenant already exist
			{
				JOptionPane.showMessageDialog(null, "## Tenant already exists" + myTenant.toString()); //return statement
			}
		}
		
		String  aID = JOptionPane.showInputDialog("You need to link Tenat to Apartment ");
		Apartment a1 = new Apartment(aID, null, 0, 0, 0);
		tenantController.link(a1,myTenant);
		System.out.println("Tenant registration done.  " + getClass());
	}
	
	public ArrayList<Tenant> searchTenant()
	{
		Tenant myTenant = getTextFields();
		tenants = tenantController.searchTenant(myTenant);
		return tenants;
	}
	
	public void refreshSearch()
	{
		tm.setRowCount(0); // delete old data from the rows
		ArrayList<Tenant> tenants = searchTenant(); //arraylist containing tenants that matched search criteria
			for (Tenant t1: tenants)
			tm.addRow(t1.toArray()); // adding each tennant as a Row in our TableModel
					
					
					JInternalFrame ifApartments = null;
					JInternalFrame ifTenants = null;
					Component[] comps = this.getParent().getParent().getParent().getParent().getComponents();
					try {
						for(Component c1: comps)
						{
							JInternalFrame iframe = (JInternalFrame) c1;
							if (iframe.getTitle().equals("Apartments"))
								ifApartments = (JInternalFrame) c1;
							if (iframe.getTitle().equals("Tenants"))
								ifTenants = (JInternalFrame) c1;
							System.out.println("Components from DesktopPane"+iframe.getTitle());
						}
					}
					
					
					catch(Exception e){}
					
					if (ifApartments != null && ifApartments.isVisible())
					{
						Component[] components = ifApartments.getComponents();
						for(Component c1: components)
							{
							try
								{
									System.out.println("Component in ifTenants: " + c1);
									JRootPane jrp = (JRootPane) c1;
									Component[] coomps = jrp.getComponents();
									System.out.println(jrp.getComponents());
									for(Component cp : coomps)
										{
										System.out.println("Components in JRootpane" + cp);
											try {
											JLayeredPane jp = (JLayeredPane) cp;
											System.out.println("Component from JLP" + jp.getComponent(0));
											ApartmentGUI aGUI = (ApartmentGUI) jp.getComponent(0);
											DefaultTableModel tm = aGUI.getTm();
											ArrayList<Apartment> apartments = tenantController.searchTenant(tenants);
											tm.setRowCount(0);
											for (Apartment a1: apartments)
												tm.addRow(a1.toArray());
											
											}
											catch (Exception e) {}
										}
								}
						catch (Exception e) {}
						
						}
					}
					
	}
	
	public Tenant getTextFields()
	{
		System.out.println("Getting data from TextFields... " + getClass());
		String ID = null;
		if (!textFieldID.getText().equals(""));
			ID = textFieldID.getText();
		String name = null;
		if(!textFieldName.getText().equals(""));
			name = textFieldName.getText();
		
		String address = null;
		if (!textFieldAddress.getText().equals(""))
			address = textFieldAddress.getText();
		
		Date startDate = null;
		try
		{
			startDate = Date.valueOf(textFieldStartDate.getText());
		}
		catch(Exception e){}
		
		Date stopDate = null;
		try
		{
			stopDate = Date.valueOf(textFieldStopDate.getText());
		}
		catch (Exception e){}
		
		Tenant myTenant = new Tenant(ID, name, address, 0, startDate, stopDate);
		System.out.println("Data retrieved from TextFields. " + getClass());
		return myTenant;
	}
}
