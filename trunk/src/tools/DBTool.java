/* DBTool A utility class
 * Copyright 1998 Michael Claudius, Inc. All Rights Reserved.
 * Version 1.0 Last modified 2003.10.19, 2005.11.13, 2011.04.26
 * All rights reserved
 */

package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTool {

    private Connection con = null;
    private Statement stmt = null;
    private String login, passwd, url, driverClass;
    private static final DBTool INSTANCE = new DBTool();

//Default constructor
    private DBTool() {
        login = "root";
        passwd = "qwerty";
        url = "jdbc:mysql://localhost:3306/hashDB"; //data source
        driverClass = "com.mysql.jdbc.Driver";
        connect();
    }

// Customized constructor
    private DBTool(String url, String login, String passwd, String driverClass) {
        this.url = url;
        this.login = login;
        this.passwd = passwd;
        this.driverClass = driverClass;
        connect();
    }

// Establish connection and statement
    public void connect() {
        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(url, login, passwd);
            stmt = con.createStatement();
        } catch (java.lang.ClassNotFoundException ex) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.print("Connection refused: ");
            System.err.println(ex.getMessage());
            close();
        }
    }

    public Statement getStatement() {
        return stmt;
    }

    public Connection getConnection() {
        return con;
    }

// Close connection and statement
    public void close() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
//
//    public static void main(String args[]) throws SQLException {
//        DBTool dbt = new DBTool();
//        Statement stmt = dbt.getStatement();
//        String sqlQuery = "select * from Tennant";
//        ResultSet rs = stmt.executeQuery(sqlQuery);
//        while (rs.next()) {
//           
//
//        }
//        dbt.close();
//
//    }

	/**
	 * @return the instance
	 */
	public static DBTool getInstance() {
		return INSTANCE;
	}
    
}
