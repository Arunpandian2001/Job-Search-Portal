package login;

import com.util.getvalues.InputCheck;

import customexception.CustomException;
import storage.Storage;

public class LoginLayer {

	InputCheck input=new InputCheck();
	
	public boolean isIdAvailable(String id) throws CustomException {
		// TODO Auto-generated method stub
		if(Storage.VALUES.getUserDetails().containsKey(id))
			return true;
		else {
			throw new CustomException("Invalid user id");
		}
	}
	
	public boolean isApplicant(String id) {
		// TODO Auto-generated method stub
		if(Storage.VALUES.getUserDetails().get(id).getRole().equals("Applicant"))
			return true;
		
		return false;
	}

	public boolean isPasswordCorrect(String id,String password) throws CustomException {
		System.out.println(Storage.VALUES.getUserDetails().get(id).getPassword());
		if(Storage.VALUES.getUserDetails().get(id).getPassword().equals(password))
			return true;
		else {
			throw new CustomException("Invalid password");
		}
	}

	
	
}
