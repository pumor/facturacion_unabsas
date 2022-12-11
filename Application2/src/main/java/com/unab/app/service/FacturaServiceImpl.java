
package com.unab.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.unab.app.dao.IFacturaDAO;
import com.unab.app.dao.IProductoDAO;
import com.unab.app.interfaces.IDetalleFacturaService;
import com.unab.app.interfaces.IFacturaService;
//import com.unab.app.interfaces.IProductoService;
import com.unab.app.models.DetalleFactura;
import com.unab.app.models.Factura;
import com.unab.app.models.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaDAO ifacturaDao;
	
	@Autowired 
	private IProductoDAO iproductoDao;
	
	@Autowired
	private IDetalleFacturaService idetalleFacturaService;
	
	@Override
	public void updateFactura(Long idFactura, Long idProducto) {
		Producto producto=iproductoDao.findProductoById(idProducto);
		System.out.println("Producto a actualizar "+producto.getNombre());
		List<DetalleFactura> listDetalleFactura=idetalleFacturaService.findDetalleFacturaByIdFacturaByIdProducto(idFactura, idProducto);
				
//Para actualizar el valor en una factura
		Factura factura=this.findFacturaById(idFactura);
		factura.setValorTotal(1_500_000L);
		ifacturaDao.save(factura);
		
		for(int x=0;x<listDetalleFactura.size();x++) {
			System.out.println("Lista con for:" +listDetalleFactura.get(x));
		}

		listDetalleFactura.forEach(t->{
			t.setCantidad(15);
			Integer cantidad=t.getCantidad();
			Long precio=t.getProducto().getPrecio();
			Long newValor=cantidad*precio;
			factura.setValorTotal(newValor);
			ifacturaDao.save(factura);
		});

	
	for(DetalleFactura d: listDetalleFactura) {
		System.out.println("Lista for 1:"+d);
		}
	}
	
	@Override
	public void save(Factura factura) {
		ifacturaDao.save(factura);
	}
	@Override
	public List<Factura> fetchFacturaByIdCliente(Long id) {
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
	@Override
	public ResponseEntity<String> delete(Long id){
		Factura factura=ifacturaDao.findById(id).orElse(new Factura());
		if(factura.getId()!=null && factura.getId()>0) {
			ifacturaDao.deleteById(id);
			return new ResponseEntity<String>("La factura con total "+factura.getValorTotal()+" fue eliminada con éxito", HttpStatus.OK);
			
		}
		return new ResponseEntity<String> ("La factura "+factura.getValorTotal()+" no pudo ser eliminada porque no existe en la base de datos", HttpStatus.NOT_FOUND);		
	}
}
