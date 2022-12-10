package com.unab.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unab.app.dao.IDetalleFacturaDAO;
import com.unab.app.interfaces.IDetalleFacturaService;
import com.unab.app.models.DetalleFactura;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService {

	@Autowired
	private IDetalleFacturaDAO idetalleFacturaDao;
	
	@Override
	public void save(DetalleFactura detalleFactura) {
		idetalleFacturaDao.save(detalleFactura);
	}
	@Override
	public List<DetalleFactura> findDetalleFacturaByIdFacturaByIdProducto(Long id_factura, Long id_producto) {
		return idetalleFacturaDao.findDetalleFacturaByIdFacturaByIdProducto(id_factura, id_producto);
	}

}
