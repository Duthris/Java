package kodlama.io.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CandidateCvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CandidateCv;

@RestController
@RequestMapping("/api/candidatesCvs")
public class CandidatesCvsController {
	
	private CandidateCvService candidateCvService;

	@Autowired
	public CandidatesCvsController(CandidateCvService candidateCvService) {
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateCv>> getAll() {
		return this.candidateCvService.getAll();
	}
	
	@PostMapping("/addCvAvatar")
	public Result uploadCvAvatar(int id, MultipartFile multipartFile) throws IOException {
		return this.candidateCvService.uploadCvAvatar(id, multipartFile);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.add(candidateCv);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<CandidateCv>> getByCandidateId(@RequestParam int id) {
		return this.candidateCvService.getByCandidateId(id);
	}
	
	@PostMapping("/update")
	public DataResult<CandidateCv> update(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.update(candidateCv);
	}
	

}
