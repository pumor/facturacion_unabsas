package com.unab.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.unab.app.models.Factura;

public interface IFacturaDAO extends CrudRepository<Factura, Integer> {

	@Query("select f from Factura f join fetch f.cliente c where f.cliente.id=?!")
	public List<Factura> fetchFacturaByIDCliente(Long id);
}
