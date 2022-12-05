package runner;

import java.util.List;

import com.util.getvalues.InputCheck;

import customexception.CustomException;
import data.Vacancy;
import operation.CompanyOperation;
import storage.Storage;

public class CompanyRunner {

	private String id;
	private static InputCheck input=new InputCheck();
	private static CompanyOperation method=new CompanyOperation();
	public CompanyRunner(String id) {
		this.id=id;
	}
	public void companyOption() throws CustomException {
		// TODO Auto-generated method stub
		boolean loginLoop=true;
		while(loginLoop) {
			System.out.println("1)Post vacancy \n2)Edit vacancy \n3)Delete vacancy \n4)Logout");
			int choice=input.isInteger();
			switch(choice) {
				case 1:{
					postVacancy();
					break;
				}
				case 2:{
					editVacancy();
					break;
				}
				case 3:{
					deleteVacancy();
					break;
				}
				case 4:{
					System.out.println("Logging out");
					loginLoop=false;
					break;
				}
				default:{
					System.err.println("Enter valid option");
					break;
				}
			}
		}
		
	}
	private void deleteVacancy() throws CustomException {
		// TODO Auto-generated method stub
		System.out.println("Select the post to be deleted");
		String post=selectPost();
		List<Vacancy> vacancyList=Storage.VALUES.getVacancyDetails().get(post);
		int choice=getVacancy(vacancyList);
		Vacancy vacancy=vacancyList.get(choice-1);
		method.deleteVacancy(vacancy, choice);
		System.out.println("Deleted Successfully");
	}
	private void editVacancy() throws CustomException {
		// TODO Auto-generated method stub
		System.out.println("Select the post to be updated");
		String post=selectPost();
		List<Vacancy> vacancyList=Storage.VALUES.getVacancyDetails().get(post);
		int choice=getVacancy(vacancyList);
		Vacancy vacancy=vacancyList.get(choice-1);
		vacancy=setVacancy(vacancy);
		method.editVacancy(vacancy,choice);
		System.out.println("Editted Successfully");
	}
	
	private void postVacancy() throws CustomException {
		// TODO Auto-generated method stub
		Vacancy vacancy=new Vacancy();
		;
		method.addVacancy(setVacancy(vacancy));
	}
	
	private String selectPost() throws CustomException {
		String post="";
		boolean postLoop=true;
		while(postLoop) {
			System.out.println("1)Embedded C Programmer \n2)Full-Stack Deveoper \n3)Auto-CAD Designer \n4)Fashion designer");
			int option=input.isInteger();
			switch(option) {
				case 1:{
					post="Embedded C Programmer";
					postLoop=false;
					break;
				}
				case 2:{
					post="Full-Stack Deveoper";
					postLoop=false;
					break;
				}
				case 3:{
					post="Auto-CAD Designer";
					postLoop=false;
					break;
				}
				case 4:{
					post="Fashion designer";
					postLoop=false;
					break;
				}
				default:{
					System.err.println("Select valid choice");
					break;
				}
			}
		}
		return post;
	}
	
	private Vacancy setVacancy(Vacancy vacancy) throws CustomException {
		System.out.println("Enter the Job role ::");
		vacancy.setPost(selectPost());
		System.out.println("Enter the Educational qualification ::");
		vacancy.setQualification(input.getString());
		System.out.println("Enter the required experience in years ::");
		vacancy.setExperience(input.isInteger());
		System.out.println("Enter the Salary");
		vacancy.setSalary(input.isInteger()+"K");
		System.out.println("Enter the from passed out year ::");
		vacancy.setPassOutFrom(input.isInteger());
		System.out.println("Enter the to passed out year ::");
		vacancy.setPassOutTo(input.isInteger());
		
		System.out.println("Enter the Job location ::");
		vacancy.setLocation(input.getString());
		return vacancy;
	}
	
	private int getVacancy(List<Vacancy> vacancyList) throws CustomException {
		for(int i=0;i<vacancyList.size();i++) {
			Vacancy s=vacancyList.get(i);
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Choice Number:: "+i+1);
			System.out.println("Qualification ::"+s.getQualification());
			System.out.println("Role :: "+s.getPost());
			System.out.println("Salary :: "+s.getSalary());
			System.out.println("Location :: "+s.getLocation());
			if(s.getPassOutFrom()!=0 && s.getPassOutTo()!=0) {
				System.out.println("Batches from "+s.getPassOutFrom()+"- "+s.getPassOutTo());
			}else if(s.getPassOutFrom()!=0){
				System.out.println("Batches from "+s.getPassOutFrom());
			}
			if(s.getExperience()!=0) {
				if(s.getExperience()>1) {
					System.out.println("Exprience :: "+s.getExperience()+" years");
				}else
					System.out.println("Exprience :: "+s.getExperience()+" year");
			}
			System.out.println("-------------------------------------------------------------------------------------");
		}
		
		boolean choiceLoop=true;
		int choice=0;
		while(choiceLoop) {
			System.out.println("Enter choice number");
			choice=input.isInteger();
			if(choice>0 && choice<vacancyList.size()) {
				choiceLoop=false;
				
			}else {
				System.err.println("Enter valid option");
			}
		}
		return choice;
	}
}
