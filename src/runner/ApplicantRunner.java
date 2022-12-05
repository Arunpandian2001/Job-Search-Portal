package runner;

import java.util.List;
import java.util.Map;

import com.util.getvalues.InputCheck;

import customexception.CustomException;
import data.Applicant;
import data.Qualifications;
import data.Vacancy;
import operation.ApplicantOperation;
import storage.Storage;

public class ApplicantRunner {
	private String id;
	private static InputCheck input=new InputCheck();
	private static ApplicantOperation method=new ApplicantOperation();
	public ApplicantRunner(String id) {
		this.id=id;
	}

	public void applicantOption() throws CustomException {
		// TODO Auto-generated method stub
		boolean loop=true;
		while(loop) {
			System.out.println("1)Search job \n2)Profile \n3)Logout");
			int option =input.isInteger();
			switch(option) {
				case 1:{
					searchJob();
					break;
				}
				case 2:{
					viewProfile();
					break;
				}
				case 3:{
					loop=false;
					break;
				}
				default:{
					System.err.println("Enter valid choice");
					break;
				}
			}
		}
	}


	private void viewProfile() {
		// TODO Auto-generated method stub
		Applicant applicant=Storage.VALUES.getApplicantDetails().get(id);
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Name ::"+applicant.getName());
		System.out.println("DOB ::"+applicant.getAge());
		System.out.println("Gender ::"+applicant.getGender());
		System.out.println("Age"+applicant.getAge());
		Qualifications s=applicant.getQualification();
		System.out.println("Education name"+s.getName() );
		System.out.println("Institution name"+s.getInstitutionName());
		System.out.println("Total marks/CGPA"+s.getTotalMarks());
		System.out.println("Obtained marks/CGPA "+s.getMarks());
		System.out.println("Passout year"+s.getPassedOutYear());
		System.out.println();
	}

	private void searchJob() throws CustomException {
		// TODO Auto-generated method stub
		
		Applicant applicant=Storage.VALUES.getApplicantDetails().get(id);
		boolean searchLoop=true;
		String post="";
		while(searchLoop) {
			System.out.println("1)Embedded C Programmer \n2)Full-Stack Deveoper \n3)Auto-CAD Designer \n4)Fashion designer");
			int option=input.isInteger();
			switch(option) {
				case 1:{
					post="Embedded C Programmer";
					searchLoop=false;
					break;
				}
				case 2:{
					post="Full-Stack Deveoper";
					searchLoop=false;
					break;
				}
				case 3:{
					post="Auto-CAD Designer";
					searchLoop=false;
					break;
				}
				case 4:{
					post="Fashion designer";
					searchLoop=false;
					break;
				}
				default:{
					System.err.println("Select valid choice");
					break;
				}
			}
		}
		if(Storage.VALUES.getVacancyDetails().containsKey(post)) {
			List<Vacancy> vacancyList=Storage.VALUES.getVacancyDetails().get(post);
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
			
		}
		System.out.println("Enter choice number");
		int choice=input.isInteger();
		if(method.applyJob(applicant,choice,Storage.VALUES.getVacancyDetails().get(post))) {
			printVacancyDetails(Storage.VALUES.getVacancyDetails().get(post).get(choice-1));
			System.out.println("Applied Successfully");
			
		}else {
			System.out.println("Your qualification did not match the eleigiblity criteria");
		}
		
	}

	private void printVacancyDetails(Vacancy s) {
		System.out.println("-------------------------------------------------------------------------------------");
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
}
