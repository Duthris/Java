package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates_schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
@EqualsAndHashCode(callSuper = false)
public class CandidateSchool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="starting_date")	
	private Date startingDate;
	
	@Column(name="graduation_date")
	private Date graduationDate;
	
	@Column(name="is_graduated")
	private boolean isGraduated;
	
	@ManyToOne(targetEntity = CandidateCv.class)
	@JoinColumn(name="candidates_cv_id")
	@JsonIgnore
	private CandidateCv candidateCv;
}
