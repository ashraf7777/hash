package model;

import java.lang.reflect.Field;

public class Thing {
	private int tID;

	public Thing(int tID) {
		this.settID(tID);
	}
	
	public Thing() // DO NOT DELETE: Breaks Subclasses constructors
	{
		
	}

	/**
	 * @return the tID
	 */
	public int gettID() {
		return tID;
	}

	/**
	 * @param tID the tID to set
	 */
	public void settID(int tID) {
		this.tID = tID;
	}

	public String insertQuery()
	{
		String query = "insert into "; //starting with the "constant" start of the Query
		//@warning If Table Name it's not the same as the name of the class, query fails
		query += this.getClass().getSimpleName() + " "; //adding the Name of the Table!
		query += "values("; // adding constant part of query
		Field[] fields = this.getClass().getDeclaredFields(); //finding Fields present in a Class
		for (Field f:fields) //looping through the fields
		{
			// IGNORE Exceptions for now
			try {
				query += f.get(this) +","; // gets the values of the field of "this" object
			
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //adding fields separated by commas
		}
		query = query.substring(0,query.length()-1); //removing the last comma
		query+=")"; //adding the last constant part of the query
		return query;
	}

	//select * from User where username like '%2%' and password like '%3%' and type like '%4%'
	public String selectQuery() {
		String query = "select * from "; // first constant of a Query
		//	@warning If Table Name it's not the same as the name of the class, query fails
		query += this.getClass().getSimpleName() + " "; //adding the Name of the Table!
		query += "where "; //constant statement in SQL language
		Field[] fields = this.getClass().getDeclaredFields(); //finding Fields present in a Class
		for (Field f:fields) //looping through the fields
		{
			try {
				if (f.get(this) != null && !f.get(this).toString().equals("0")) //avoid nulls and zeros for field's values
				{
					query += f.getName() + " ";
					query += "like '%"; //constant statement in SQL language
					query += f.get(this) + "%' "; // gets the values of the field of "this" object
					query += "and "; //constant statement in SQL language
				}
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		query = query.substring(0, query.length()-4); //removing the last "and " from the query
		return query;
	}

	/** UPDATE table_name
	*   SET column1=value, column2=value2,...
	*   WHERE some_column=some_value 
	*/
	public String updateQuery(Thing t)
	
	{
		String query = "update "; //constant part of query
		query += this.getClass().getSimpleName() + " "; //add Table name
		query += "set "; //constant part of query
		Field[] fields = this.getClass().getDeclaredFields(); //finding Fields present in a Class
		try
		{
			for (Field f:fields) //looping through the fields
			{
				query += f.getName() +"=" + f.get(this) + ", "; // constructs the statement column1=value
			}
			
			query = query.substring(0, query.length()-2) + " "; //removing the last comma from the query
			query += "where "; //constant part of query
			
			for (Field f:fields) //looping through the fields
			{
				query += f.getName() +"=" + f.get(t) + " and "; // constructs the statement column1=value
			}
			query = query.substring(0, query.length()-4); //removing the last "and " from the query
		}
		// IGNORE Exceptions for now
		catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return query;
	}

	public String deleteQuery() {
		String query = "delete from "; //constant part of query
		query += this.getClass().getSimpleName() + " "; // Table Name
		query += "where "; // constant
		Field[] fields = this.getClass().getDeclaredFields(); //finding out fields
		for (Field f:fields)
		{
			try {
				if (f.get(this) != null && !f.get(this).toString().equals("0"))
					query += f.getName() +" = " + f.get(this) + " and ";
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // constructs the statement column1=value
		}
		query = query.substring(0, query.length()-4);
		return query;
	}
}
