package dataAcces;

/**
 * @author BBDL Group
 * @version 0.3
 * DAO is the class that parses Objects into SQL Format and backwards.
 * Access to a Database is provided through a DBTool
 */
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tools.DBTool;
import model.apartment.Apartment;
import model.employee.Employee;
import model.tenant.Tenant;

public class DAO {
	private final static DAO INSTANCE = new DAO();
    private DBTool dbtool;

	public DAO() {
		setDbtool(DBTool.getInstance());
	}
    //need to test this one.
	//a method to add a apartment to the database table of name "Apartment" by the use of a apartments.DBtoString().
	   public boolean addApartmentDB(Apartment aApartment) {
		   	dbtool.connect();
		   	boolean ok = false;
	        dbtool = DBTool.getInstance();
	        Statement stmt = dbtool.getStatement();

	        try {
	            String apartmentInsert = "insert into Apartment values ( " + aApartment.toDBString() + ")";
	            System.out.println(apartmentInsert);
	            stmt.executeUpdate(apartmentInsert);
	            
	            ok = true;
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            dbtool.close();
	        }
	        dbtool.close();
			return ok;
	    }

	
	public Apartment getApartmentDB(String iD) {
		
		int priceSqm,rooms ,size,rent;
        String aID, address;	
		
        dbtool.connect();
        
        Apartment a1 = null;
	     Statement stmt = dbtool.getStatement();
	     String query = "select * from Apartment where apartmentID = " + iD; 
	     
            ResultSet rs;
			try {
				rs = stmt.executeQuery(query);
				
				if (rs.next()) {
					// AID, Address, Rooms, Size, PriceSqm, Rent
					aID = rs.getString("AID");
		            address = rs.getString("Address");
					rooms = rs.getInt("Rooms");
		            size = rs.getInt("Size");
		            priceSqm = rs.getInt("PriceSqm");
		            rent = rs.getInt("Rent");
		            
		            		            
		            a1= new Apartment(aID, address,size, rooms,priceSqm,rent);
		            //stmt.close();
					}

				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            dbtool.close();
            System.out.println(a1.toDBString());
		return a1;
	}
	
	public void insertTenant(Tenant aTenant) {
		// we are inserting an object Tenant into DB
		System.out.println("Inserting tenant in DataBase " + aTenant.toString() + getClass());
		dbtool.connect();
		String insertSQL = "insert into Tenant values ( " + aTenant.toDBString() + ")";
				System.out.println(insertSQL);
		try {
			System.out.println("Executing SQL Statement : " + insertSQL + getClass());
			dbtool.getStatement().executeUpdate(insertSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbtool.close();
		System.out.println("Employee Inserted in DataBase " + getClass());
		
	}
	
	public void insertEmployee(Employee aEmployee) {
		// we are inserting an object Tenant into DB
		System.out.println("Inserting employee in DataBase " + aEmployee.toString() + getClass());
//		String insertSQL = "insert into Tenant values ( " + aEmployee.toDBString() + ")";
//				
//		try {
//			dbtool.getStatement().executeUpdate(insertSQL);
//		} catch (SQLException e) {
//			// TODO Figure out a action-on-catch
//			e.printStackTrace();
//		}
		System.out.println("Employee inserted in DB" + getClass());
		
		
	}
	
	
	/**
	 * @return the dbtool
	 */
	public DBTool getDbtool() {
		return dbtool;
	}
	/**
	 * @param dbtool the dbtool to set
	 */
	public void setDbtool(DBTool dbtool) {
		this.dbtool = dbtool;
	}
	/**
	 * @return the instance
	 */
	public static DAO getInstance() {
		return INSTANCE;
	}
	public Tenant getTenant(String id) {
		Tenant t1 = null;
		dbtool.connect();
		String query = "select * from Tenant where ID like \'"+id+"\'";
		Statement stmt = dbtool.getStatement();
		
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String ID = rs.getString("ID");
			    String name = rs.getString("Name");
			    String address = rs.getString("Address");
			    Date StartDate = rs.getDate("StartDate");
			    Date StopDate = rs.getDate("StopDate");
			    t1 = new Tenant(ID, name, address, 0, StartDate, StopDate);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbtool.close();
		return t1;
	}
	public ArrayList<Tenant> searchTenant(Tenant myTenant) {
		
		dbtool.connect();
        Statement stmt = getDbtool().getStatement();
        String ID = myTenant.getID();
        String name = myTenant.getName();
        String address = myTenant.getAddress();
        Date startDate = myTenant.getStartDate();
        Date stopDate = myTenant.getStopDate();
        
//        select * from Tenant where StartDate like '2010-01-01' and Address like '%Roskilde%';
        
        String query = "select * from Tenant where ";
        if (ID != null)
        	query += "ID like \'%" + ID +"%\' and ";
        if (name != null)
        	query += "Name like \'%" + name +"%\' and ";
        if (address != null)
        	query += "Address like \'%" + address +"%\' and ";
        if (startDate != null)
        	query += "StartDate like \'%" + startDate +"%\' and ";
        if (stopDate != null)
        	query += "StopDate like \'%" + stopDate +"%\'";
		
        if (query.endsWith("and "))
        {
        	query = query.substring(0, query.length()-4);
        }
        System.out.println(query);
        
        ResultSet rs;
        String q_ID;
        String q_name;
        String q_address;
        Date q_StartDate;
        Date q_StopDate;
        ArrayList<Tenant> tenants = new ArrayList<Tenant>(); 
        try {
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				q_ID = rs.getString("ID");
	            q_name = rs.getString("Name");
	            q_address = rs.getString("Address");
	            q_StartDate = rs.getDate("StartDate");
	            q_StopDate = rs.getDate("StopDate");
	            Tenant t1 = new Tenant(q_ID, q_name, q_address, 0, q_StartDate, q_StopDate);
	            tenants.add(t1);
				}
//			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbtool.close();
		return tenants;
				
	}
	
	
	public ArrayList<Apartment> searchTenant(ArrayList<Tenant> tenants)
	{
		dbtool.connect();
        Statement stmt = getDbtool().getStatement();
		ArrayList<Apartment>apartments = new ArrayList <Apartment>(); 
		
		for (Tenant t1: tenants)
		{
//			select * from Main, Apartment
//			where '104' = Main.ID and Apartment.AID = Main.AID..... twin search

			String query = "select * from Main, Apartment where \'"  +t1.getID() + 
			"\' = Main.ID and Apartment.AID = Main.AID";

			System.out.println("Sending Query to Database : " + query);
			ResultSet rs;
	        String q_aID, q_address;
	        int q_rooms, q_size, q_priceSqm, q_rent;
	        try {
				rs = stmt.executeQuery(query);				
				while (rs.next()) {
					q_aID = rs.getString("AID");
			        q_address = rs.getString("Address");
			        q_rooms = rs.getInt("Rooms");
			        q_size = rs.getInt("Size");
			        q_priceSqm = rs.getInt("PriceSqm");
			        q_rent = rs.getInt("Rent");
		            Apartment a1 = new Apartment(q_aID, q_address, q_rooms, q_size, q_priceSqm, q_rent);
		            System.out.println(a1);
		            apartments.add(a1);
		            
					}
//				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
					
		dbtool.close();
		return apartments;
					
	}
	
	
	
	
	
	public void updateTenant(Tenant oldTenant, Tenant newTenant) {
		// TODO Auto-generated method stub
		dbtool.connect();
		setDbtool(DBTool.getInstance());
        Statement stmt = getDbtool().getStatement();
        String oldID = oldTenant.getID();
        String oldName = oldTenant.getName();
        String oldAddress = oldTenant.getAddress();
        Date oldStartDate = oldTenant.getStartDate();
        Date oldStopDate = oldTenant.getStopDate();
        
        String ID = newTenant.getID();
        String name = newTenant.getName();
        String address = newTenant.getAddress();
        Date startDate = newTenant.getStartDate();
        Date stopDate = newTenant.getStopDate();
		
    String query = "update Tenant " + 
    		"set ID = \'" + ID + "\', " +
    		"Name = \'" + name + "\', " +
    		"Address = \'" + address + "\', " +
    		"StartDate = \'" + startDate + "\' "; 
    		if (stopDate != null)
    			query += ", StopDate = \'" + stopDate + "\' ";
    		query +=  "where  ID = \'" + oldID + "\' " +
    		"and Name = \'" + oldName + "\' " +
    		"and Address = \'" + oldAddress + "\' " +
    		"and StartDate = \'" + oldStartDate + "\' ";
    		if (oldStopDate != null)
    			query +="and StopDate = \'" + oldStopDate + "\'";
    		
    		
    		try {
    			System.out.println(query);
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		dbtool.close();
	}
	public ArrayList<Apartment> searchApartment(Apartment myApartment) {
		dbtool.connect();
		System.out.print("Searching Apartment..." + myApartment + " in " + getClass());
        Statement stmt = getDbtool().getStatement();
        String aID = myApartment.getaID();
        String address = myApartment.getAddress();
        int rooms = myApartment.getRooms();
        int size = myApartment.getSize();
        int priceSqm = myApartment.getSize();
        int rent = myApartment.getRent();
        
//        select * from Tenant where StartDate like '2010-01-01' and Address like '%Roskilde%';
        
        String query = "select * from Apartment where ";
        if (aID != null)
        	query += "AID like \'%" + aID +"%\' and ";
        if (address != null)
        	query += "Address like \'%" + address +"%\' and ";
        if (rooms != 0)
        	query += "Rooms like %" + rooms +"% and ";
        if (size != 0)
        	query += "Size like %" + size +"% and ";
        if (priceSqm != 0)
        	query += "PriceSqm like %" + priceSqm +"%";
        if (rent != 0)
        	query += "Rent like %" + rent +"%";
        
        if (query.endsWith("and "))
        {
        	query = query.substring(0, query.length()-4);
        }
        System.out.println(query);
        
        ResultSet rs;
        String q_aID, q_address;
        int q_rooms, q_size, q_priceSqm, q_rent;
        ArrayList<Apartment> apartments = new ArrayList<Apartment>(); 
        try {
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				q_aID = rs.getString("AID");
		        q_address = rs.getString("Address");
		        q_rooms = rs.getInt("Rooms");
		        q_size = rs.getInt("Size");
		        q_priceSqm = rs.getInt("PriceSqm");
		        q_rent = rs.getInt("Rent");
	            Apartment a1 = new Apartment(q_aID, q_address, q_rooms, q_size, q_priceSqm, q_rent);
	            System.out.println(a1);
	            apartments.add(a1);
				}
//			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbtool.close();
		return apartments;
	}
	
	public void link(Apartment a1,Tenant t1)
	{
		dbtool.connect();
		Statement stmt = getDbtool().getStatement();
//		insert into Main values ('23','666');
		String query = "insert into Main values  (\'"+ a1.getaID() +"\',\'" + t1.getID() + "\');";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dbtool.close();
	}
	
	
	
}
