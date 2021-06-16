package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.WorkingMethodService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.WorkingMethod;

@RestController
@RequestMapping("/api/workingMethods")
@CrossOrigin
public class WorkingMethodsController {
	
	private WorkingMethodService workingMethodService;

	@Autowired
	public WorkingMethodsController(WorkingMethodService workingMethodService) {
		this.workingMethodService = workingMethodService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingMethod>> getAll() {
		return this.workingMethodService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<WorkingMethod> getById(int id) {
		return this.workingMethodService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingMethod workingMethod) {
		return this.workingMethodService.add(workingMethod);
	}
	

}
