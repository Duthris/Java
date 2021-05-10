package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CompanyService;
import kodlama.io.hrms.entities.concretes.Company;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {
	
	private CompanyService companyService;

	@Autowired
	public CompaniesController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	
	@GetMapping("/getall")
	List<Company> getAll() {
		return this.companyService.getAll();
	}
	
	

}
