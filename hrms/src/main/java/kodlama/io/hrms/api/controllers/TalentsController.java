package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.TalentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Talent;

@RestController
@RequestMapping("/api/talents")
@CrossOrigin
public class TalentsController {
	
	private TalentService talentService;

	@Autowired
	public TalentsController(TalentService talentService) {
		this.talentService = talentService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<Talent>> getAll() {
		return this.talentService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Talent talent) {
		return this.talentService.add(talent);
	}

}
