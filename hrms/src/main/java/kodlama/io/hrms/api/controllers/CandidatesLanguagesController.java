package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidateLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CandidateLanguage;
import kodlama.io.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/candidatesLanguages")
@CrossOrigin
public class CandidatesLanguagesController {
	
	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidatesLanguagesController(CandidateLanguageService candidateLanguageService) {
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateLanguage>> getAll() {
		return this.candidateLanguageService.getAll();
	}
	
	@GetMapping("/getByCandidateCvId")
	public DataResult<List<CandidateLanguage>> getByCandidateCvId(int id) {
		return this.candidateLanguageService.getByCandidateCvId(id);
	}
	
	
	@PostMapping("/addLanguageToCv")
	public Result addLanguageToCv(@RequestBody Language language, @RequestParam int candidateId) {
		return this.candidateLanguageService.addLanguageToCv(language, candidateId);
	}

}
