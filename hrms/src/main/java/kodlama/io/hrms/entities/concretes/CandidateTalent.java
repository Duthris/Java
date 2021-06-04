package kodlama.io.hrms.entities.concretes;

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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidates_talent")
@EqualsAndHashCode(callSuper = false)
public class CandidateTalent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = CandidateCv.class)
	@JoinColumn(name="candidates_cv_id")
	@JsonIgnoreProperties
	private CandidateCv candidateCv;

	
	@ManyToOne
	@JoinColumn(name="talents_id")
	private Talent talent;
	
	public CandidateTalent (CandidateCv candidateCv, Talent talent) {
		this.talent = talent;
		this.candidateCv = candidateCv;
	}
}
