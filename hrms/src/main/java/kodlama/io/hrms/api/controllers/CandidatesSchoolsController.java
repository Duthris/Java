package kodlama.io.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidateSchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CandidateSchool;

@RestController
@RequestMapping("/api/candidatesSchools")
@CrossOrigin
public class CandidatesSchoolsController {
	
	private CandidateSchoolService candidateSchoolService;

	@Autowired
	public CandidatesSchoolsController(CandidateSchoolService candidateSchoolService) {
		this.candidateSchoolService = candidateSchoolService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSchool>> getAll() {
		return this.candidateSchoolService.getAll();
	}
	
	@GetMapping("/getByCandidateCvId")
	public DataResult<List<CandidateSchool>> getByCandidateCvId(@RequestParam int id) {
		return this.candidateSchoolService.getByCandidateCvId(id);
	}
	
	@PostMapping("/update")
	public DataResult<CandidateSchool> update(@RequestBody CandidateSchool candidateSchool) {
		return this.candidateSchoolService.update(candidateSchool);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchool candidateSchool) {
		return this.candidateSchoolService.add(candidateSchool);
	}
	
	@GetMapping("/getCandidateSchoolsByGraduationDateDesc")
	public DataResult<List<CandidateSchool>> orderCandidateSchoolsByGraduationDateDesc(int id) {
		return this.candidateSchoolService.orderCandidateSchoolsByGraduationDateDesc(id);
	}

}
