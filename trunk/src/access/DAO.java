package access;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.Thing;
import tools.DBTool;

public class DAO {
	DBTool dbTool;

	
	public DAO() {
		dbTool = DBTool.getInstance(); //contacting the DBTool singleton
	}

    //TODO: Add Cross-Checking when it's available (CRUD:retrieve use-case)
	// equals method Needed in each type of "Thing"
	public boolean createThing(Thing t) {
		boolean status = false;
		Statement st = dbTool.getStatement();
		String query = t.insertQuery(); //generate query according to Thing's types and Name ;)
		System.out.print(query);
		try {
			st.executeUpdate(query); // send data to DB
			status = true; // at this point the "Thing" is considered created
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return status;
	}
	
	// CRUD Use Case (Point R = Retrieve) AKA. Search
	public Vector<Thing> retrieveThing(Thing t)
	{
		Vector<Thing> result = new Vector<Thing>(); // JTable can easily integrate data from a Vector, therefore Vector is preferable
		Statement st = dbTool.getStatement();
		String query = t.selectQuery(); //Generate Select Query of the current Thing
		
		try {
			ResultSet rs = st.executeQuery(query); // send Query to DB
			int columns = rs.getMetaData().getColumnCount(); //getting how many columns are in table
			String className = rs.getMetaData().getTableName(1);//getting Table Name

			while (rs.next()) //for each row do:
			{
				Object[] contents = new Object[columns]; //array containing all the data in a Table Row
				for(int i=0;i<columns;i++) // traverse each column of the current Row
					contents[i] = rs.getObject(i+1); //Saving contents from tables in the local "contents" array
				@SuppressWarnings("rawtypes")
				Class c = Class.forName("model."+className); //Generate a Class object of the Class with the same name as our Table
				
				@SuppressWarnings("rawtypes")
				Class[] classes = new Class[]{Object[].class}; //Preparing an array (classes) that contains the Class Object of an Object Array
				//Note: any "Thing" object must have a Constructor with Object[] as a parameter !!! (Otherwise this method fails to work)
				@SuppressWarnings({ "unchecked", "rawtypes" })
				Constructor constructor = c.getConstructor(classes); //Getting the constructor declared with "classes"; 
				Thing t1 = (Thing) constructor.newInstance(new Object[]{contents}); //Using the actual constructor to (re)make a "Thing"
				result.add(t1); //adding the Thing to the Vector that contains results
				
			}
			
			//TODO: Edit exception actions
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public boolean updateThing(Thing oldThing, Thing newThing)
	{
		boolean status = false;
		if(oldThing.getClass().equals(newThing.getClass())) //making sure that the things are of the same type (this is supposed to be true all the time)
		{
			Statement st = dbTool.getStatement();
			String query = oldThing.updateQuery(newThing); //Generate Select Update Query out of the 2 thing information
			try {
				st.executeUpdate(query); //send query to the DB
				status = true; //if the runtime execution gets to this point the information got to DB successfully
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}	
		return status;
	}
	
	public boolean deleteThing(Thing t)
	{
		boolean status = false;
		Statement st = dbTool.getStatement();
		String query = t.deleteQuery();
		try {
			st.executeUpdate(query); //sending query to DB
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
