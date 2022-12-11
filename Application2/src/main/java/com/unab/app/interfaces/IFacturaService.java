package com.unab.app.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.unab.app.models.Factura;

public interface IFacturaService {

	public void save(Factura factura);
	
	public void updateFactura(Long idFactura, Long idProducto);
	
	public List<Factura> fetchFacturaByIdCliente(Long id);
	
	public Factura findFacturaById(Long id);
	
	public void deleteFactura(Long Id);
	
	public ResponseEntity<String> delete(Long id);
}
