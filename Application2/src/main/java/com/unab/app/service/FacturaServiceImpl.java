package com.unab.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unab.app.dao.IFacturaDAO;
import com.unab.app.interfaces.IDetalleFacturaService;
import com.unab.app.interfaces.IFacturaService;
import com.unab.app.interfaces.IProductoService;
import com.unab.app.models.DetalleFactura;
import com.unab.app.models.Factura;
import com.unab.app.models.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaDAO ifacturaDao;
	
	@Autowired 
	private IProductoService iproductoService;
	
	@Autowired
	private IDetalleFacturaService idetalleFacturaService;
	
	@Override
	public void updateFactura(String nombreProducto, Long id_factura) {
		Producto producto=iproductoService.findByNombre(nombreProducto);
		List<DetalleFactura> listDetalleFactura=idetalleFacturaService.findDetalleFacturaByIdFacturaByIdProducto(id_factura, producto.getId());
						
/*Para actualizar el valor en una factura*/
		Factura factura=this.findFacturaById(id_factura);
		factura.setValorTotal(1500000L);
		ifacturaDao.save(factura);
		
		for(int x=0;x<listDetalleFactura.size();x++) {
			System.out.println("Lista con for:" +listDetalleFactura.get(x));
		}

/*Para actualizar el valor en todas las facturas		
		listDetalleFactura.forEach(t->{
			@SuppressWarnings("unused")
			Factura factura=new Factura();
			System.out.println("Lista con funcion:"+t);
			factura=this.findFacturaById(t.getFactura().getId());
			factura.setValorTotal(1500000L);
			ifacturaDao.save(factura);
		});
*/
	}
	
	@Override
	public void save(Factura factura) {
		ifacturaDao.save(factura);
	}
	
	@Override
	public List<Factura> fetchFacturByIdCliente(Long id) {
		return ifacturaDao.fetchFacturaByIDCliente(id);
	}
	@Override
	public Factura findFacturaById(Long id) {
		return ifacturaDao.findById(id).orElse(new Factura());
	}
	@Override
	public void deleteFactura(Long id) {
		ifacturaDao.deleteById(id);
	}

}
