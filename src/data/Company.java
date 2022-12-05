package data;

public class Company extends User {

	private String industryType;
	private int establishedYear;
	private String companyName;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public int getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}
	
}
