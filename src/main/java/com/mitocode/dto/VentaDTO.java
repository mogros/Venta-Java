package com.mitocode.dto;

import javax.validation.constraints.NotNull;

import com.mitocode.model.Venta;

public class VentaDTO {

	@NotNull
	private Venta venta;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
	
	
}
