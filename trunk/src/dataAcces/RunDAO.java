/**
 * 
 */
package dataAcces;

import java.sql.Date;

import model.tenant.Tenant;

/**
 * @author bjrn
 *
 */
public class RunDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// Start TIME
//		System
		
		DAO dao = new DAO();
		// Testing add Apartment
//		dao.addApartmentDB(0, 1, 2, "3", "4", "5");
//		System.out.println(dao.getApartmentDB(999).toString());
		 
//		Testing search
		populateDB();
		Tenant myTenant = new Tenant(null, null, "Roskilde", 0, Date.valueOf("2010-01-01"), null);
		for(Tenant ct : dao.searchTenant(myTenant))
		{
			System.out.println(ct.toString());
		}
		
	}
	
	// Daniel: This should Populate our DB with a specific number of "Random" Objects
	
	static void populateDB()
	{
		String[] names = new String[]{"Daniel","Bo","Bjørn","Lasse","Unknown","Lars","Thomas","Bob"};
		String[] addresses = new String[]{"Roskilde","København","Kalundborg","Moon","Sun","Jupiter","Mars","Haslev","HashLand","ComputerCity"};
		Date[] dates = new Date[]{Date.valueOf("1999-02-01"),Date.valueOf("2010-01-01"), Date.valueOf("2001-09-11")};
		int id = 0;
		for(int n=0; n<names.length;n++)
			for (int a=0; a<addresses.length;a++)
				for (int d=0;d<dates.length;d++)
				{
					Tenant aTenant = new Tenant(id+"", names[n], addresses[a], 0, dates[d], null);
					System.out.println("Tenant details " + aTenant.toString());
					DAO.getInstance().insertTenant(aTenant);
					id++;
				}
	}

}
