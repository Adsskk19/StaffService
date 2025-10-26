package com.flmhospitals.dto;

import com.flmhospitals.enums.Specialization;
import com.flmhospitals.enums.StaffType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDetailsDto {
	
	private String staffId;
	
	private String firstName;
	
	private String lastName;
	
	private long phoneNumber;
	
	private String role;
	
	private String gender;
	
	private String experienceInYears;
	
	private String email;
	
	private Specialization specialization;
	
	private StaffType staffType;
	
	private StaffAddressDto staffAddressDto;
	

}
