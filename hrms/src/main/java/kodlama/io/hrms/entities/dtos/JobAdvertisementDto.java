package kodlama.io.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobAdvertisementDto {
	
	private int cityId;
	
	private int employerId;
	
	private String description;
	
	private LocalDateTime expirationDate;
	
	private int jobPositionId;
	
	private int maxSalary;
	
	private int minSalary;
	
	private int quota;
	
	private int workingMethodId;
	
	private int workingTimeId;

}
