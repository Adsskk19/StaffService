package com.flmhospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffAddressDto {
	
	private String landMark;
	
	private String city;
	
	private String state;
	
	private long pinCode;

}
