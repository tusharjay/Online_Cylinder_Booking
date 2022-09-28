package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ForgotPasswordDto {
	
	private String userName;
	private String mobileNumber;
	private String newPassword;

}
