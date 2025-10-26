package com.flmhospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDetailsDto {
	
	private String staffDetailsId;
	
	private String email;
	
	private String password;
	
	private StaffAddressDto staffAddressDto;

}
