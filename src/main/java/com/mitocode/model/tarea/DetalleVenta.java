package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleVenta;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_detalle"))
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_producto"))
	private Producto producto;


	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Consulta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta= venta;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto= producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(Int cantidad) {
		this.cantidad= cantidad;
	}

}
