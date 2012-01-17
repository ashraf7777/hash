package tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunDBtool {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		 DBTool dbt = DBTool.getInstance();
	        Statement stmt = dbt.getStatement();
	        String sqlQuery = "select * from Tennant";
	        ResultSet rs = stmt.executeQuery(sqlQuery);
	        while (rs.next()) {
	           
	            System.out.println("column 1: " + rs.getString("ID"));
	            System.out.println("column 2: " + rs.getString("Name"));
	            System.out.println("column 3: " + rs.getInt("TennantNO"));
	        }
	        dbt.close();

	}

}
