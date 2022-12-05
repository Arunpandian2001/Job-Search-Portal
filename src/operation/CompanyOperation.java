package operation;

import java.util.List;
import java.util.Map;

import data.Vacancy;
import storage.Storage;

public class CompanyOperation {

	public void addVacancy(Vacancy vacancy) {
		
		if(Storage.VALUES.getVacancyDetails().containsKey(vacancy.getPost())) {
			Map<String,List<Vacancy>> map=Storage.VALUES.getVacancyDetails();
			List<Vacancy> list=map.get(vacancy.getPost());
			list.add(vacancy);map.put(vacancy.getPost(), list);
			Storage.VALUES.setVacancyDetails(map);
		}
	}

	public void editVacancy(Vacancy vacancy, int choice) {
		// TODO Auto-generated method stub
		Map<String,List<Vacancy>> map=Storage.VALUES.getVacancyDetails();
		List<Vacancy> list=map.get(vacancy.getPost());
		list.remove(choice-1);
		list.add(choice-1, vacancy);
		map.put(vacancy.getPost(), list);
		Storage.VALUES.setVacancyDetails(map);
	}
	
	public void deleteVacancy(Vacancy vacancy,int choice) {
		Map<String,List<Vacancy>> map=Storage.VALUES.getVacancyDetails();
		List<Vacancy> list=map.get(vacancy.getPost());
		list.remove(choice-1);
		map.put(vacancy.getPost(), list);
		Storage.VALUES.setVacancyDetails(map);
	}
}
