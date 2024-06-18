package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_Doctor")
public class DoctorDto extends BaseDTO {

	@Column(name = "Name", length = 20)
	private String name;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "mobileNo", length = 20)
	private String mobileNo;

	@Column(name = "Experties", length = 20)
	private String experties;

	@Column(name = "Name", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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
	public String getValue() {
		// TODO Auto-generated method stub
		return experties;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "mobileNo";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return mobileNo;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "mobileNo";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

		map.put("name", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("mobileNo", mobileNo);
		return map;
	}

}
