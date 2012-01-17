/**
 * 
 */
package model.employee;

import java.sql.Date;

import model.Person;

/**
 * @author bjrn
 *
 */
public class Employee extends Person {
	
	public int employeeNO;
	public String title;
	public Date hiredDate;
	
	

	/**
	 * @param iD
	 * @param name
	 * @param adress
	 * @param employeeNO
	 * @param title
	 * @param hiredDate
	 */
	public Employee(String iD, String name, String adress, int employeeNO,
			String title, Date hiredDate) {
		super(iD, name, adress);
		this.employeeNO = employeeNO;
		this.title = title;
		this.hiredDate = hiredDate;
	}



	/**
	 * @return the employeeNO
	 */
	public int getEmployeeNO() {
		return employeeNO;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @return the hiredDate
	 */
	public Date getHiredDate() {
		return hiredDate;
	}



	/**
	 * @param employeeNO the employeeNO to set
	 */
	public void setEmployeeNO(int employeeNO) {
		this.employeeNO = employeeNO;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @param hiredDate the hiredDate to set
	 */
	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tenant [getID()=" + getID() + ", getName()=" + getName()
				+ ", getAddress()=" + getAddress() + ", employeeNO="
				+ employeeNO + ", title=" + title + ", hiredDate=" + hiredDate
				+ "]";
	}



	public String toDBString() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}