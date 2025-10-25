package com.flmhospitals.model;

import java.time.LocalDate;

import com.flmhospitals.enums.Specialization;
import com.flmhospitals.enums.StaffType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(unique = true, nullable = false)
	private String staffId;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(length=15,nullable = false )
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StaffType staffType;
	
	@Column(nullable = false)
	private String role;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Specialization specialization;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(nullable = false)
	private int experienceInYears;
	
	@Column(nullable = false)
	private boolean canLogin;
	
	@Column(nullable = false)
	private boolean isEmployeeActive;

	// staffDetails,
	// staffAddress

}
