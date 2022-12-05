package data;

public class Applicant extends User{

	private int age;
	private String dob;
	private String gender;
	private Qualifications qualification;
	private int experience;
	
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Qualifications getQualification() {
		return qualification;
	}
	public void setQualification(Qualifications qualification) {
		this.qualification = qualification;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
