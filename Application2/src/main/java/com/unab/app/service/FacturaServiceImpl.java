package com.unab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.unab.app.dao.IFacturaDAO;
import com.unab.app.interfaces.IFacturaService;
import com.unab.app.models.Factura;

public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaDAO ifacturaDao;
	
	@Override
	public void save(Factura factura) {
	}
	@Override
	public void updateFactura(String nombeProducto, Long id) {
	}
	@Override
	public List<Factura> fetchFacturByIdCliente(Long id) {
		return null;
	}
	@Override
	public Factura findFacturaById(Long id) {
		return null;
	}
	@Override
	public void deleteFactura(Long Id) {
	
	}

}
