package kodlama.io.hrms.core.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.adapters.abstracts.ImageAdapterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageAdapterManager implements ImageAdapterService {
	
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap( "cloud_name", "duthris",
															  "api_key", "894622896213114",
															  "api_secret", "DoDpqcAQMyKoqa78uwm4j8a1eQc"));

	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
		
		Map<String, Object> specs = new HashMap<>();
		
		var formats = Arrays.asList("png", "bmp", "jpeg", "jpg");
		specs.put("formats", specs);
		
		File file = converter(multipartFile);
		
		Map uploaderMap = null;
		
		try {
			uploaderMap = cloudinary.uploader().upload(file, specs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SuccessDataResult<Map>(uploaderMap);
		
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map deleteMap = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		
		return new SuccessDataResult<Map>(deleteMap);
	}
	
	private File converter(MultipartFile multipartFile) {
		
		File file = new File(multipartFile.getOriginalFilename());
		
		try {
			FileOutputStream stream = new FileOutputStream(file);
			stream.write(multipartFile.getBytes());
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return file;
	}

}
