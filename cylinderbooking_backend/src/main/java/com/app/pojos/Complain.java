package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "complain")
public class Complain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "complain_id")
	private int complintId;
	
	@Column(name = "complain_date")
	private LocalDate complaintDate;

	@Column(name = "complain_topic")
	private String complainTopic;

	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid" ,referencedColumnName = "cus_id")
	private Customer customer=new Customer();

}
