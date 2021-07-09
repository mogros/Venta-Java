package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Producto Model")
@Entity 
//@Table(name = "tbl_paciente", schema = "mi_esquema") 
public class Producto{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@Schema(description = "nombre de producto")
	@Size(min = 3, message = "{nombres.size}")
	@Column(name = "nombres", nullable = false ,length = 70)	
	private String nombres;
	
	@Schema(description = "marca producto")
	@Size(min = 3, message = "{marca.size}")
	@Column(name = "marca", nullable = false ,length = 70)
	private String marca;
	
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto= idProducto;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca= marca;
	}

	
}
