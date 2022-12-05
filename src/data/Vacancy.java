package data;

public class Vacancy {

	private String post;
	private String salary;
	private String qualification;
	private String location;
	private int passOutFrom;
	private int passOutTo;
	private int experience;
	
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getPassOutFrom() {
		return passOutFrom;
	}
	public void setPassOutFrom(int passOutFrom) {
		this.passOutFrom = passOutFrom;
	}
	public int getPassOutTo() {
		return passOutTo;
	}
	public void setPassOutTo(int passOutTo) {
		this.passOutTo = passOutTo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
}
