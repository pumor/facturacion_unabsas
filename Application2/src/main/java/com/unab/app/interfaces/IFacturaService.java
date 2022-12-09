package com.unab.app.interfaces;

import java.util.List;

import com.unab.app.models.Factura;

public interface IFacturaService {

	public void save(Factura factura);
	
	public void updateFactura(String nombeProducto,Long id);
	
	public List<Factura> fetchFacturByIdCliente(Long id);
	
	public Factura findFacturaById(Long id);
	
	public void deleteFactura(Long Id);
}
