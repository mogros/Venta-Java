package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.VentaDTO;
import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;


@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService{

	@Autowired
	private IVentaRepo repo;
	
	//@Autowired
	//private IVentaRepo vRepo;
	
	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	
	public Venta registrarTransaccional(VentaDTO dto) throws Exception {
		dto.getVenta().getDetalleVenta().forEach(det -> det.setVenta(dto.getVenta()));
		repo.save(dto.getVenta());
		
		return dto.getVenta();
		
	}	
	
}
