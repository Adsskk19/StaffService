package com.flmhospitals.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDetails {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long staffId;

	  
	    private String name;

	   
	    @Column(unique = true)
	    private String email;

	    
	    @Column(unique = true)
	    private String phoneNumber;

	
	    private String role; // e.g., Nurse, Doctor, Admin

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
	    private StaffAddress address;

	    @Column(nullable = false)
	    private boolean isActive = true;

	    @Column(updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();

	    private LocalDateTime updatedAt = LocalDateTime.now();


}
