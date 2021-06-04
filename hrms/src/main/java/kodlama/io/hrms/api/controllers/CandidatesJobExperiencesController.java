package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidateJobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.CandidateJobExperience;

@RestController
@RequestMapping("/api/candidatesJobExperiences")
public class CandidatesJobExperiencesController {
	
	private CandidateJobExperienceService candidateJobExperienceService;

	@Autowired
	public CandidatesJobExperiencesController(CandidateJobExperienceService candidateJobExperienceService) {
		this.candidateJobExperienceService = candidateJobExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateJobExperience>> getAll() {
		return this.candidateJobExperienceService.getAll();
	}
	
	@GetMapping("/getCandidateJobExperiencesByStartingDateDesc")
	public DataResult<List<CandidateJobExperience>> orderCandidateJobExperiencesByStartingDateDesc(int id) {
		return this.candidateJobExperienceService.orderCandidateJobExperiencesByStartingDateDesc(id);
	}
	

}
