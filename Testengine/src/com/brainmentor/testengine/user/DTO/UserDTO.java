 
package com.brainmentor.testengine.user.DTO;

import java.util.ArrayList;

public class UserDTO {
private String UserName;
private String Password;
private String Address;
private String Gender;
private String PinCode;
private String roleName;
private String setSimpleDateFormat;
private ArrayList<RightDTO> rights = new ArrayList<>();


public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public ArrayList<RightDTO> getRights() {
	return rights;
}
public void setRights(ArrayList<RightDTO> rights) {
	this.rights = rights;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender =gender ;
}
public String getPinCode() {
	return PinCode;
}
public void setPinCode(String pinCode) {
	PinCode = pinCode;
}
//  boolean Gender;
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}

public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
//public boolean isGender() {
	//return Gender;
//}
//public void setGender(boolean gender) {
//Gender = gender;
//public void setSimpleDateFormat(String simpleDateFormat) {
	// TODO Auto-generated method stub
	
//}
//public String getSetSimpleDateFormat() {

	//return setSimpleDateFormat;
}
//public void setSetSimpleDateFormat(String setSimpleDateFormat) {
//	this.setSimpleDateFormat = setSimpleDateFormat;
//}
//}


