package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ComplainDto {
	
	@NotBlank(message = "complain topic must be reqire")
	private String complainTopic;

	@NotBlank(message = "description must be require")
	private String description;
	

}
