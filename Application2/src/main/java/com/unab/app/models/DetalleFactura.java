package com.unab.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleFactura")
public class DetalleFactura implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@Column(name="id_detalleFactura")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@ManyToOne()
	@JoinColumn(name="id_factura_fk", referencedColumnName="id_factura")
	private Factura factura;
	
	@ManyToOne()
	@JoinColumn(name="id_producto_fk", referencedColumnName="id_producto")
	private Producto producto;

	public DetalleFactura() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DetalleFactura(Long id, Integer cantidad, Factura factura, Producto producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.factura = factura;
		this.producto = producto;
	}
		
}
