
import java.util.Date;

import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Adapters.MernisServiceAdapter;
import Concrete.CustomerCheckManager;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main 
{
	public static void main(String[] args) 
	{
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Adem Anýl");
		customer1.setLastName("Yalýmdemir");
		customer1.setDateOfBirth(new Date(2000,7,20));
		customer1.setNationalityId("12345678910");
		
		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setFirstName("Engin");
		customer2.setLastName("Demiroð");
		customer2.setDateOfBirth(new Date(1985,1,7));
		customer2.setNationalityId("28861499108");	
		
		
		System.out.println("\n######### Nero Customer Manager Tests #########\n");
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager(new CustomerCheckManager());
		neroCustomerManager.save(customer2);
		
		System.out.println("\n######### Starbucks Manager Tests #########\n");
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		starbucksCustomerManager.save(customer1); // Fake
		starbucksCustomerManager.save(customer2); // Real
	}

}
