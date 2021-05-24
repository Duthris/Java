package kodlama.io.hrms.core.utilities.results;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	
	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}
	
	
	

}
