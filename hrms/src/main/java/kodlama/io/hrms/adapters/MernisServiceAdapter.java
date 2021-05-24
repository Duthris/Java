package kodlama.io.hrms.adapters;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CandidateCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result = true;
		
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")), Integer.parseInt(candidate.getBirthYear()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
