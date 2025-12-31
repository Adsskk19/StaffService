package com.flmhospitals.builder;

import org.springframework.beans.BeanUtils;
import com.flmhospitals.dto.RegisterStaffDto;
import com.flmhospitals.dto.StaffAddressDto;
import com.flmhospitals.model.Staff;
import com.flmhospitals.model.StaffAddress;
import com.flmhospitals.model.StaffDetails;

public class StaffBuilder {

	public static Staff buildStaffFromRegisterStaffDto(RegisterStaffDto registerStaffDto){
		
		 Staff staff = Staff.builder()

		.firstName(registerStaffDto.getFirstName())
		.lastName(registerStaffDto.getLastName())
		.phoneNumber(String.valueOf(registerStaffDto.getPhoneNumber()))
		.gender(registerStaffDto.getGender())
		.dateOfJoining(registerStaffDto.getDateOfJoining())
		.staffType(registerStaffDto.getStaffType())
		.specialization(registerStaffDto.getSpecialization())
		.experienceInYears(registerStaffDto.getExperienceInYears())
		.staffAddress(buildStaffAdddressFromStaffAddressDto(registerStaffDto.getStaffAddressDto()))
		.staffDetails(buildStaffDetailsFromStaffDetailsDto(registerStaffDto.getEmail()))
		.build();

		 System.out.println(staff);
		 
		 return staff;
	}
	
	public static StaffAddress buildStaffAdddressFromStaffAddressDto(StaffAddressDto staffAddressDto) {
		

		StaffAddress staffAddress = new StaffAddress();
		
		System.out.println(staffAddressDto);
		
		 BeanUtils.copyProperties(staffAddressDto, staffAddress);
		
		 System.out.println(staffAddress);
		 
		return staffAddress;

	}
	
	public static StaffDetails buildStaffDetailsFromStaffDetailsDto(String email) {
		
		return StaffDetails.builder()
				.email(email)
				.build();
	}
}
