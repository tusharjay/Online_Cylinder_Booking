package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.app.pojos.Login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class CustomerDto {
	
	@NotBlank(message = "name must be req")
	private String fullName;
	
	@NotBlank(message = "user name must be requerd")
	private String userName;
	
	
	@NotBlank(message = "password must be reqired")
	private String password;
	
	@NotBlank(message = "mob number must be requerd")
	private String mobileNumber;
	
	@NotBlank(message = "email must be requerd")
	@Email
	private String email;
	
	@NotBlank(message = "aadhar card must be requerd")
	private String aadharCard;
	
	@NotBlank(message = "address must be requerd")
	private String address;
	
	@NotBlank(message = "city must be requerd")
	private String city;
	
	@Pattern(regexp = "(domestic|industrial" ,message = "Option must be domestic or industrial")
	private String cylinderType;
	
	private Login login;
	

}
