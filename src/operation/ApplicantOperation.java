package operation;

import java.util.List;

import data.Applicant;
import data.Vacancy;

public class ApplicantOperation {

	public boolean applyJob(Applicant applicant, int choice, List<Vacancy> list) {
		// TODO Auto-generated method stub
		Vacancy vacancy=list.get(choice-1);
		if(applicant.getExperience()>=vacancy.getExperience()) {
			if(applicant.getQualification().getName().equals(vacancy.getQualification())) {
				return true;
			}
		}
		return false;
	}

	
}
