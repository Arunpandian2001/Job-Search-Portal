package runner;

import com.util.getvalues.InputCheck;

import customexception.CustomException;
import data.Applicant;
import data.Company;
import data.Qualifications;
import login.LoginLayer;
import storage.Storage;

public class JobPortalRunner {
	private static int idCount=1;
	private static InputCheck input=new InputCheck();
	private static JobPortalRunner runner=new JobPortalRunner();
	 
	public static void main(String[] args) {
		LoginLayer login=new LoginLayer();
		Storage.VALUES.loadApplicantDetails();
		Storage.VALUES.loadUserDetails();
		
		boolean loginLoop=true;
		while(loginLoop) {
			boolean choiceLoop=true;
			int option = 0;
			while(choiceLoop) {
				System.out.println("If existing user press 1 \nTo create account press 2 \nTo exit press 3");
				try {
					option = input.isInteger();
				} catch (CustomException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(option<=3 && option>0)
					choiceLoop=false;
				
				else
					System.err.println("Enter valid choice");
					
			}
			if(option==1) {
				String id="";
				String password="";
				boolean idLoop=true;
				while(idLoop) {
					System.out.println("Enter user id");
					id=input.getString();
					try {
						if(login.isIdAvailable(id)) {
							idLoop=false;
							continue;
						}
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				boolean passLoop=true;
				while(passLoop) {
					System.out.println("Enter password");
					password=input.getString();
					try {
						if(login.isPasswordCorrect(id,password)) {
							passLoop=false;
							continue;
						}
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("Password is invalid");
				}
				
				if(Storage.VALUES.getUserDetails().get(id).getRole().equals("Applicant")) {
					ApplicantRunner applicant=new ApplicantRunner(id);
					try {
						applicant.applicantOption();
						loginLoop=false;
						System.out.println("Shutting down");
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					CompanyRunner company=new CompanyRunner(id);
					try {
						company.companyOption();
						loginLoop=false;
						System.out.println("Shutting down");
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else if(option==2){
				boolean createLoop=true;
				while(createLoop) {
					System.out.println("For Students/Professionals press 1 \nFor organizations press 2");
					int userOption=0;
					try {
						userOption=input.isInteger();
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					switch(userOption) {
						case 1:{
							try {
								runner.createApplicant();
								System.out.println("Account created successfully");
							} catch (CustomException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							createLoop=false;
							break;
						}
						case 2:{
							try {
								runner.createCompany();
								System.out.println("Account created successfully");
							} catch (CustomException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							createLoop=false;
							break;
						}
						default:{
							System.err.println("Select valid choice");
							break;
						}
					}
				}
			}else {
				loginLoop=false;
				System.out.println("Shutting down");
			}
		}
	}

	private void createCompany() throws CustomException {
		// TODO Auto-generated method stub
		Company company=new Company();
		company.setRole("Company");
		company.setId("A"+idCount++);
		System.out.println("Enter company's name :: ");
		company.setCompanyName(input.getString());
		System.out.println("Enter the Company's establishment year ::");
		company.setEstablishedYear(input.isInteger());
		String category="";
		boolean categoryLoop=true;
		while(categoryLoop) {
			System.out.println("Enter the Industry category ::");
			System.out.println("1)IT \n2)Production \n3)Manufacturing");
			int option=input.isInteger();
			switch(option) {
				case 1:{
					category="IT";
					categoryLoop=false;
					break;
				}
				case 2:{
					category="Production";
					categoryLoop=false;
					break;
				}
				case 3:{
					category="Manufacturing";
					categoryLoop=false;
					break;
				}
				default:{
					System.err.println("Enter valid option");
					break;
				}
			}
		}
		company.setIndustryType(category);
		System.out.println("Enter the user name ::");
		company.setName(input.getString());
		company.setPassword(passwordCheck());
		
	}

	private  void createApplicant() throws CustomException {
		// TODO Auto-generated method stub
		Applicant applicant=new Applicant();
		System.out.println("Enter name::");
		applicant.setName(input.getString());
		System.out.println("Enter age :: ");
		applicant.setAge(input.isInteger());
		System.out.println("Enter  DOB ::");
		applicant.setDob(input.getString());
		int genderOption=0;
		String gender="";
		boolean genderLoop=true;
		while(genderLoop) {
			System.out.println("Gender 1-Male 2-Female 3-Transgender");
			genderOption=input.isInteger();
			switch(genderOption) {
				case 1:{
					gender="Male";
					genderLoop=false;
					break;
				}
				case 2:{
					gender="Female";
					genderLoop=false;
					break;
				}
				case 3:{
					gender="TransGender";
					genderLoop=false;
					break;
				}
				default:{
					System.err.println("Select valid option");
					break;
				}
			}
		}
		applicant.setGender(gender);
		applicant.setPassword(passwordCheck());
		applicant.setRole("Applicant");
		applicant.setId("A"+idCount++);
		
		Qualifications qualifications =new Qualifications();
		applicant.setQualification(runner.setQualification(qualifications));
	}

	private Qualifications setQualification(Qualifications qualifications) throws CustomException {
		// TODO Auto-generated method stub
		
		Qualifications qualification=new Qualifications();
		System.out.println("Name of the Study");
		qualification.setName(input.getString());
		System.out.println("Enter the Institution name::");
		qualification.setInstitutionName(input.getString());
		System.out.println("Enter the passedout year :: ");
		qualification.setPassedOutYear(input.isInteger());
		System.out.println("Enter the Total marks/CGPA :: ");
		qualification.setTotalMarks(input.isInteger());
		System.out.println("Enter the Obtained marks/CGPA :: ");
		qualification.setMarks(input.isFloat());
		return qualification;
	}
	
	
	private String passwordCheck() {
		boolean passLoop=true;
		String pass1="";
		String pass2="";
		while(passLoop) {
			System.out.println("Enter password");
			pass1=input.getString();
			System.out.println("Reenter password");
			pass2=input.getString();
			if(pass1.equals(pass2)) {
				passLoop=false;continue;
			}
			System.err.println("Reenter correct password");
		}
		return pass1;
	}
}
