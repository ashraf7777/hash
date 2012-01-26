/**
 * 
 */
package controller;

import model.Thing;

// CONVENTION: DO NOT USE IMPORTS IN THIS CLASS
/**
 * @author daniel
 *
 */
public class RunHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		model.User u1 = new model.User(1, "1", "2", "3", "4", "5", "6", "7");
		model.User u2 = new model.User(0, null, "username", "3", "4", "5", "6", "7");
		access.DAO dao = new access.DAO();

		System.out.println(u1.insertQuery());
		System.out.println(u1.selectQuery());
		System.out.println(u1.updateQuery(u2));
		System.out.println(u1.deleteQuery());
		System.out.println(u1.createTableQuery());
	}

}
