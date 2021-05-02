package Concrete;
import java.util.Date;
import Abstract.CustomerCheckService;
import Abstract.CustomerService;
import Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService 
{
	@Override
	public boolean checkIfRealPerson(Customer customer) 
	{
		return true;
	}
}
