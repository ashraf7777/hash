package model;

import java.lang.reflect.Field;

public class Thing {
	private int tID;

	/**
	 * Constructor that initializes a Thing using a tID 
	 * @param tID	ID of the Thing
	 */
	public Thing(int tID)
	{
		this.settID(tID);
	}
	/**
	 * Constructor that initializes a Thing as a basic object
	 * @warning DO NOT DELETE: Breaks Subclasses' constructors
	 */
	public Thing()
	{
		
	}

	/**
	 * @return	ID of the Thing
	 */
	public int gettID() {
		return tID;
	}

	/**
	 * @param param tID	ID of the Thing
	 */
	public void settID(int tID) {
		this.tID = tID;
	}
	
	/**
	 * Generates an SQL Insert query based on Thing's fields and Class name
	 * <p> Example: insert into User values(1,1,2,3,4,5,6,7)
	 * @return a String containing an SQL Insert query
	 */
	public String insertQuery()
	{
		String query = "insert into "; //starting with the "constant" start of the Query
		//@warning If Table Name it's not the same as the name of the class, query fails
		query += this.getClass().getSimpleName() + " "; //adding the Name of the Table!
		query += "values("; // adding constant part of query
		query += sqlCondition(this,null,",");
		query+=")"; //adding the last constant part of the query
		return query;
	}

	/**
	 * Generates a SQL select Query based on Thing's fields and Class name
	 * <p> Example: select * from User where uID like '%1%' and name like '%user%' and password like '%password%'
	 * @return a String containing a SQL Insert Query
	 */
	public String selectQuery() {
		String query = "select * from "; // first constant of a Query
		//	@warning If Table Name it's not the same as the name of the class, query fails
		query += this.getClass().getSimpleName() + " "; //adding the Name of the Table!
		query += "where "; //constant statement in SQL language
		query += sqlCondition(this," like '%","%' and "); //generating the SQL condition using like and "and"
		query += "%'"; //adding the missing part
		return query;
	}

	/**
	 * Generates a SQL update Query for updating the current Thing (this) with other Thing provided by parameter
	 * <p> Example: update User set uID = 0, name = new_name, username = new_username where uID = 1, name = old_name, username = old_username
	 * @param t	Thing that should replace the current Thing
	 * @return a String containing a SQL update Query
	 */
	public String updateQuery(Thing t)
	{
		String query = "update "; //constant part of query
		query += this.getClass().getSimpleName() + " "; //add Table name
		query += "set "; //constant part of query
		query += sqlCondition(t, " = ", ", "); //constructing the condition with the fields
		query += " where "; //constant part of query
		query += sqlCondition(this, " = ", ", ");
		return query;
	}

	/**
	 * Generates a SQL delete Query for the current Thing
	 * <p> Example: delete from User where uID = 1 and name = 1 and username = 2 and password = 3 and type = 4 and ID = 5 and email = 6 and phone = 7
	 * @return a String containing a SQL delete Query
	 */
	public String deleteQuery() {
		String query = "delete from "; //constant part of query
		query += this.getClass().getSimpleName() + " "; // Table Name
		query += "where "; // constant
		query += sqlCondition(this, " = ", " and ");
		return query;
	}
	
	/**
	 * Generates a SQL condition from the object and one or two regular expressions
	 * <p> Example: field_name regex1 field_value regex2 field_name regex1 field_value
	 * <p> Last regex will always be deleted (because it is illegal in SQL language)
	 * @param t - the Thing that the condition is applied for | could not be NULL
	 * @param regex1 - string that represents what should be after field's names in a SQL Condition | if NULL, only values will be used
	 * @param regex2 - string that represents what should be after field's values in a SQL Condition | if NULL, only names will be used
	 * @return the resulted SQL condition
	 */
	private String sqlCondition(Thing t, String regex1, String regex2)
	{
		Field[] fields = t.getClass().getDeclaredFields(); //finding Fields present in a Class
		String result = "";
		for (Field f:fields)
		{
			try {
				if (regex1 == null)
					result += f.get(t) + regex2; // generate SQL condition using just values and regex2
				
				if (regex2 == null)
					result += f.getName() + regex1; // generate SQL condition using just names and regex1;
				
				if (f.get(this) != null && !f.get(this).toString().equals("0") && regex1 != null && regex2 != null) //avoid nulls and zeros
					result += f.getName() + regex1 + f.get(t) + regex2; // generate SQL condition from fields, thing and separator
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // constructs the statement column1=value
		}
		if (regex2 != null)
			result = result.substring(0, result.length()-regex2.length()); //cutting the last regex2 that appears in the query (it is illegal in SQL
		else result = result.substring(0, result.length()-regex1.length()); //cutting the last regex1 that appears in the query (it is illegal in SQL
		return result;
	}
	
	/**
	 * Generates a create Table Query for the Thing using it's Class name and fields
	 * @return a String containing the definition of the query
	 */
	public String createTableQuery()
	{
		String query = "create table "; //constant part of the query
		query += this.getClass().getSimpleName() + " ( ";
		Field[] fields = this.getClass().getDeclaredFields(); //finding Fields present in a Class
		for (Field f:fields)
		{
			if(f.getName().contains("ID") && f.getType().getSimpleName().equals("int")) // in case we have an int identifier "ID" we increment it automatically
				query += f.getName() + " " + f.getType().getSimpleName() + " not null auto_increment, ";
			else if (f.getType().getSimpleName().equals("String"))
				query += f.getName() + " varchar(250) not null, ";
			else query += f.getName() + " " + f.getType().getSimpleName() + " not null, ";
		}
		query = query.substring(0, query.length()-2);
		query += ")";
		return query;
	}
}
