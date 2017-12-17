package com.condigence.medicare.services;

import java.util.List;

import com.condigence.medicare.dto.CommissionDTO;

public interface CommissionService {

	public CommissionDTO findById(Long id);

	public void saveCommission(CommissionDTO commissionDTO);

	public List<CommissionDTO> findAll();
}
