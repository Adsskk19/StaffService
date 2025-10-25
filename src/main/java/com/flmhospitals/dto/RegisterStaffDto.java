package com.flmhospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStaffDto {
	
	private String firstName;
	
	private String lastName;
	
	private long phoneNumber;
	
	private String staffType;
	
	private String role;
	
	private String gender;
	
	private String specilization;
	
	private String dateOfJoining;
	
	private String experienceInYears;
	
	private String email;
	
	private StaffAddressDto staffAddressDto;

}
