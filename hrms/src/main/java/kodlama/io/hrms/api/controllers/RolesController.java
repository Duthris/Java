package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Role;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
	
	private RoleService roleService;

	@Autowired
	public RolesController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Role>> getAll() {
		return this.roleService.getAll();		
	}
	
	
	
	

}
