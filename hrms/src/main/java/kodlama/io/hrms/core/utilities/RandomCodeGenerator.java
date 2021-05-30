package kodlama.io.hrms.core.utilities;

import java.util.Random;

public class RandomCodeGenerator {
	public String createCode() {
		int leftLetter = 97;
		int rightLetter = 122;
		int codeLength = 16;
		
		Random random = new Random();
		
		String createdCode = random.ints(leftLetter, rightLetter + 1).limit(codeLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		
		return createdCode;
	}

}
