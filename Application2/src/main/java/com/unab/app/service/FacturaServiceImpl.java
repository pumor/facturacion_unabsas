
package com.unab.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unab.app.dao.IFacturaDAO;
import com.unab.app.dao.IProductoDAO;
import com.unab.app.interfaces.IDetalleFacturaService;
import com.unab.app.interfaces.IFacturaService;
import com.unab.app.models.DetalleFactura;
import com.unab.app.models.Factura;
import com.unab.app.models.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaDAO facturaDao;
	
	@Autowired 
	private IProductoDAO productoDao;
	
	@Autowired
	private IDetalleFacturaService detalleFacturaService;
	
	@Override
	public void updateFactura(Long idFactura, Long idProducto) {
		Producto producto=productoDao.findProductoById(idProducto);
		System.out.println("Producto a actualizar "+producto.getNombre());
		List<DetalleFactura> listDetalleFactura=detalleFacturaService.findDetalleFacturaByIdFacturaByIdProducto(idFactura, idProducto);
				
//Para actualizar el valor en una factura
		Factura factura=this.findFacturaById(idFactura);
		factura.setValorTotal(1_500_000L);
		facturaDao.save(factura);
		
		for(int x=0;x<listDetalleFactura.size();x++) {
			System.out.println("Lista con for:" +listDetalleFactura.get(x));
		}

		listDetalleFactura.forEach(t->{
			t.setCantidad(15);
			Integer cantidad=t.getCantidad();
			Long precio=t.getProducto().getPrecio();
			Long newValor=cantidad*precio;
			factura.setValorTotal(newValor);
			facturaDao.save(factura);
		});

	
	for(DetalleFactura d: listDetalleFactura) {
		System.out.println("Lista for 1:"+d);
		}
	}
	
	@Override
	public void save(Factura factura) {
		facturaDao.save(factura);
	}
	@Override
	public List<Factura> fetchFacturaByIDCliente(Long id) {
		return facturaDao.fetchFacturaByIDCliente(id);
	}
	@Override
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(new Factura());
	}
	@Override
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);
	}

}
