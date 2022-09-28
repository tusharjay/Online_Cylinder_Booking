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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private int customerId;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Column(name = "mob_number", nullable = false, unique = true)
	private String mobileNumber;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(name = "aadhar_card", unique = true)
	private String aadharCard;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String city;

	@Column(name = "connection_status", nullable = false)
	private String connectionStatus;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cylinder_type_id", referencedColumnName = "cylinder_type_id", nullable = false)
	private Cylinder cylinder;

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private Set<Booking> bookings;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Login login_tbl;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
