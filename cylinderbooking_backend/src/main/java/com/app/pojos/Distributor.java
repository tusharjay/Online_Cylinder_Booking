package com.app.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "distributor")
public class Distributor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distributor_id")
	private int distributorId;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "user_name")
	private String userName;
	
	private String password;
	
	private String email;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	private String address;
	
	private String city;
	
	@Column(name = "aadhar_card")
	private String aadharCard;
	
	@Column(name = "license_number")
	private String licenseNumber;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Login login_tbl;
	

}
