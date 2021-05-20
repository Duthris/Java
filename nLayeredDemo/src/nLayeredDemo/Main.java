package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.jLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		
		//ToDo: will be fixed with Spring IoC
		ProductService productService = new ProductManager(new AbcProductDao(), new jLoggerManagerAdapter());
		
		Product product1 = new Product(1,2,"Elma",12,50);
		productService.add(product1);
	}

}
