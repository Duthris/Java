package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidateTalentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CandidateTalent;
import kodlama.io.hrms.entities.concretes.Talent;

@RestController
@RequestMapping("/api/candidatesTalents")
@CrossOrigin
public class CandidatesTalentsController {
	
	private CandidateTalentService candidateTalentService;

	public CandidatesTalentsController(CandidateTalentService candidateTalentService) {
		this.candidateTalentService = candidateTalentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateTalent>> getAll() {
		return this.candidateTalentService.getAll();
	}
	
	@GetMapping("/getByCandidateCvId")
	public DataResult<List<CandidateTalent>> getByCandidateCvId(int id) {
		return this.candidateTalentService.getByCandidateCvId(id);
	}
	
	@PostMapping("/addTalentToCv")
	public Result addTalentToCv(@RequestBody Talent talent, @RequestParam int candidateId) {
		return this.candidateTalentService.addTalentToCv(talent, candidateId);
	}
	
	
}
