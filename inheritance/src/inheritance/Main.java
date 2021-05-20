package inheritance;

public class Main 
{
	public static void main(String[] args) 
	{
		IndividualCustomer anýl = new IndividualCustomer();
		anýl.customerNumber = "12345";
		
		CorporateCustomer hepsiBurada = new CorporateCustomer();
		hepsiBurada.customerNumber = "78910";
		
		UnionCustomer union = new UnionCustomer();
		union.customerNumber = "99999";
		
		CustomerManager customerManager = new CustomerManager();
		
		Customer[] customers = {anýl, hepsiBurada, union};
		
		customerManager.addMultiple(customers);
		
	}

}
