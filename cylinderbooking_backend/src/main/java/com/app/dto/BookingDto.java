package com.app.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingDto {
	
	@NotBlank(message = "delivery date must be requerd")
	private LocalDate deliveryDate;
	
	@NotBlank(message = "booking annount must be requerd")
	private double ammount;
	
	@NotBlank(message = "payment mode must be requerd")
	private String paymentType;

}
