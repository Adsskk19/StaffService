package com.flmhospitals.builder;

import com.flmhospitals.dto.RegisterStaffDto;
import com.flmhospitals.dto.StaffAddressDto;
import com.flmhospitals.model.Staff;
import com.flmhospitals.model.StaffAddress;

public class StaffBuilder {

	public static Staff buildStaffFromRegisterStaffDto(RegisterStaffDto registerStaffDto){
		
		return Staff.builder()
		.firstName(registerStaffDto.getFirstName())
		.lastName(registerStaffDto.getLastName())
		.phoneNumber(String.valueOf(registerStaffDto.getPhoneNumber()))
		.role(registerStaffDto.getRole())
		.staffType(registerStaffDto.getStaffType())
		.specialization(registerStaffDto.getSpecialization())
		.experienceInYears(Integer.parseInt(registerStaffDto.getExperienceInYears()))
		.staffAddress(buildStaffAdddressFromStaffAddressDto(registerStaffDto.getStaffAddressDto()))
		
		.build();
		
		
	}
	
	public static StaffAddress buildStaffAdddressFromStaffAddressDto(StaffAddressDto staffAddressDto) {
		
		return StaffAddress.builder()
				.street(staffAddressDto.getLandMark())
				.city(staffAddressDto.getCity())
				.state(staffAddressDto.getState())
				.pinCode(String.valueOf(staffAddressDto.getPinCode()))
				.build();
				
				
	}
}
