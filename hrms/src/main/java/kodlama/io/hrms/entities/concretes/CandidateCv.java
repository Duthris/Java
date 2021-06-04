package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates_cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
@EqualsAndHashCode(callSuper = false)
public class CandidateCv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="avatar_link")
	private String avatarLink;
	
	@Column(name="is_active")
	private boolean isActive;
	
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateSchool> schools;
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateTalent> talents;
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateLanguage> languages;
	
	@OneToMany(mappedBy = "candidateCv", fetch = FetchType.LAZY)
	private List<CandidateJobExperience> jobExperiences;
	

}
