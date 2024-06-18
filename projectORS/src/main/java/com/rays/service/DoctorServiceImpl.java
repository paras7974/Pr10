package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DoctorDaoInt;
import com.rays.dto.DoctorDto;

@Service
@Transactional
public class DoctorServiceImpl extends BaseServiceImpl<DoctorDto, DoctorDaoInt> implements DoctorServiceInt {

}
