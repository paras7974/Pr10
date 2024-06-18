package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.DoctorDto;
import com.rays.form.DoctorForm;
import com.rays.service.DoctorServiceInt;
import com.rays.service.RoleServiceInt;

@RestController
@RequestMapping(value = "Doctor")
public class DoctorCtl extends BaseCtl<DoctorForm, DoctorDto, DoctorServiceInt> {

//	@Autowired
//	public RoleServiceInt role;
//
//	@Autowired
//	public DoctorServiceInt doctorService;
//	
//	
//	public ORSResponse save(@RequestBody @Valid DoctorForm form, BindingResult bindingResult ) {
//		
//		ORSResponse res = validate(bindingResult);
//		
//		if(res.isSuccess()) {
//			return res;
//		}
//		
//		DoctorDto dto = (DoctorDto) form.getDto();
//		
//		if(dto.getId() != null && dto.getId() > 0) {
//			doctorService.update(dto, userContext);
//			res.addMessage("Data Updated Successfully......");
//		}else {
//		  doctorService.add(dto, userContext);
//		}
//		
//		
//		
//		return null;
//		
//	}
}
