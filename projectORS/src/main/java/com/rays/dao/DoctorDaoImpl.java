package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.DoctorDto;

@Repository
public class DoctorDaoImpl extends BaseDAOImpl<DoctorDto> implements DoctorDaoInt {

	@Override
	protected List<Predicate> getWhereClause(DoctorDto dto, CriteriaBuilder builder, Root<DoctorDto> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (isNotNull(dto.getDob())) {
			whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}
		if (!isEmptyString(dto.getMobileNo())) {
			whereCondition.add(builder.like(qRoot.get("mobileNo"), dto.getMobileNo() + "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<DoctorDto> getDTOClass() {
		
		return DoctorDto.class;
	}

}
