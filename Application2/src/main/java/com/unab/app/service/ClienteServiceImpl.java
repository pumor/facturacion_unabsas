package com.unab.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.unab.app.dao.IClienteDAO;
import com.unab.app.interfaces.IClienteService;
import com.unab.app.models.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDAO iclienteDao;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) iclienteDao.findAll();
	}
	
	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return iclienteDao.findAll(pageable);
	}
	@Override
	public void save(Cliente cliente) {
		iclienteDao.save(cliente);
	}
	@Override
	public Cliente findOne(Long id) {
		Cliente cliente=iclienteDao.findById(id).orElse(new Cliente());
		cliente.setNombre(cliente.getNombre()+" Julia");
		iclienteDao.save(cliente);
		return cliente;
	}
	@Override
	public ResponseEntity<String> delete(Long id){
		Cliente cliente=iclienteDao.findById(id).orElse(new Cliente());
		if(cliente.getId()!=null && cliente.getId()>0) {
			iclienteDao.deleteById(id);
			return new ResponseEntity<String>("El cliente "+cliente.getNombre()+" fue eliminado con éxito", HttpStatus.OK);
			
		}
		return new ResponseEntity<String> ("El cliente "+cliente.getNombre()+" no pudo ser eliminado porque no existe en la base de datos", HttpStatus.NOT_FOUND);		
	}
}
