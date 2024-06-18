package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DoctorDto;

public class DoctorForm extends BaseForm {

	@NotEmpty(message = "Name Is Reqquired")
	private String name;

	//@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Dose Not Match The Formate")
	@Pattern(regexp = "(19\\d{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])", message = "Dose Not Match The Formate")
	@NotNull(message = "Date Is Reqquired")
	private String dob;

	@NotEmpty(message = "MobileNo Is Reqquired")
	private String mobileNo;

	@NotEmpty(message = "experties Is Reqquired")
	private String experties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getExperties() {
		return experties;
	}

	public void setExperties(String experties) {
		this.experties = experties;
	}

	@Override
	public BaseDTO getDto() {
		DoctorDto dto = initDTO(new DoctorDto());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dto.setName(name);
		try {
			dto.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setMobileNo(mobileNo);
		dto.setExperties(experties);

		return dto;
	}

}
