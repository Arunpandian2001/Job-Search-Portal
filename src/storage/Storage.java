package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Applicant;
import data.Company;
import data.Qualifications;
import data.User;
import data.Vacancy;

public enum Storage {

	VALUES;
	Map<String,User> userDetails=new HashMap<>();
	Map<String,Applicant> applicantDetails=new HashMap<>();
	Map<String,Company> companyDetails=new HashMap<>();
	Map<String,List<Vacancy>> vacancyDetails=new HashMap<>();
	
	
	
	
	public Map<String, List<Vacancy>> getVacancyDetails() {
		return vacancyDetails;
	}
	public void setVacancyDetails(Map<String, List<Vacancy>> vacancyDetails) {
		this.vacancyDetails = vacancyDetails;
	}
	public Map<String, User> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Map<String, User> userDetails) {
		this.userDetails = userDetails;
	}
	public Map<String, Applicant> getApplicantDetails() {
		return applicantDetails;
	}
	public void setApplicantDetails(Map<String, Applicant> applicantDetails) {
		this.applicantDetails = applicantDetails;
	}
	public Map<String, Company> getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanyDetails(Map<String, Company> companyDetails) {
		this.companyDetails = companyDetails;
	}
	
	public void loadUserDetails() {
		Map<String, User> map = this.userDetails;
		User user=new User();
		user.setId("A1");
		user.setName("Arun");
		user.setPassword("arun@123");
		user.setRole("Applicant");
		map.put(user.getId(), user);
		User user2=new User();
		user2.setId("A2");
		user2.setName("AP Logistics");
		user2.setPassword("mani@123");
		user2.setRole("Company");
		map.put(user2.getId(), user2);
		this.userDetails=map;
	}
	
	public void loadApplicantDetails() {
		Map<String, Applicant> map = this.applicantDetails;
		Applicant user=new Applicant();
		user.setId("A1");
		user.setName("Arun");
		user.setPassword("arun@123");
		user.setAge(21);
		user.setDob("25-03-2001");
		user.setGender("M");
		user.setExperience(0);
		Qualifications qualification =new Qualifications();
		qualification.setInstitutionName("Sethu instittute of technology");
		qualification.setMarks((float) 8.7);
		qualification.setName("B.E");
		qualification.setPassedOutYear(2022);
		qualification.setTotalMarks(10);
		
		user.setQualification(qualification);
		map.put(user.getId(), user);
		
		this.applicantDetails=map;
	}
	
	public void loadVacancyDetails() {
		Map<String,List<Vacancy>>  map=this.vacancyDetails;
		List<Vacancy> list=new ArrayList<>();
		Vacancy vacancy=new Vacancy();
		vacancy.setLocation("Madurai");
		vacancy.setPassOutFrom(2021);
		vacancy.setPassOutTo(2022);
		vacancy.setPost("Embedded C Programmer");
		vacancy.setQualification("B.E");
		vacancy.setSalary("50k");
		List<Vacancy> list2=new ArrayList<>();
		Vacancy vacancy1=new Vacancy();
		vacancy1.setLocation("Chennai");
		vacancy1.setPassOutFrom(2021);
		vacancy1.setPassOutTo(2022);
		vacancy1.setPost("Full-Stack Deveoper");
		vacancy1.setQualification("B.E");
		vacancy1.setSalary("60k");
		List<Vacancy> list3=new ArrayList<>();
		Vacancy vacancy2=new Vacancy();
		vacancy2.setLocation("Chennai");
		vacancy2.setExperience(3);
		vacancy2.setPost("Auto-CAD Designer");
		vacancy2.setQualification("B.E");
		vacancy2.setSalary("80k");
		List<Vacancy> list4=new ArrayList<>();
		Vacancy vacancy3=new Vacancy();
		vacancy3.setLocation("Madurai");
		vacancy3.setPassOutFrom(2021);
		vacancy3.setPassOutTo(2022);
		vacancy3.setPost("Fashion designer");
		vacancy3.setQualification("B.E");
		vacancy3.setSalary("30k");
		list.add(vacancy);list2.add(vacancy3);list3.add(vacancy2);list4.add(vacancy1);
		map.put(vacancy1.getPost(), list4);
		map.put(vacancy2.getPost(), list3);
		map.put(vacancy3.getPost(), list2);
		map.put(vacancy.getPost(), list);
		
	}
	
}
