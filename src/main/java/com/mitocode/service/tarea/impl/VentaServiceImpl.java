package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.model.Consulta;
import com.mitocode.repo.IConsultaExamenRepo;
import com.mitocode.repo.IConsultaRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IConsultaService;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService{

	@Autowired
	private IVentaRepo repo;
	

	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		return repo;
	}	
	
}
