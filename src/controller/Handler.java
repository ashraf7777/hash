/**
 * 
 */
package controller;

import model.Thing;
import access.DAO;


/**
 * @author daniel
 * Handles System's Actions
 */
public class Handler {
	
	private DAO dao;
	
	
	public Handler() {
		dao = new DAO();
	}


	public boolean createThing(Thing t)
	{
		return dao.createThing(t);
	}

}
