package com.unab.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.unab.app.dao.IProductoDAO;
import com.unab.app.interfaces.IProductoService;
import com.unab.app.models.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO iproductoDao;
	
	@Override
	public Producto findProductoById(Long id) {
		return iproductoDao.findById(id).orElse(new Producto());
	}
	@Override
	public void save(Producto producto) {
		iproductoDao.save(producto);
	}
	@Override
	public Page<Producto> findAll(Pageable pageable) {
		return iproductoDao.findAll(pageable);
	}
	@Override
	public Producto findByNombre(String nombre) {
		return null;
	}
}
