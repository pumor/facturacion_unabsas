package com.unab.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.unab.app.models.Cliente;

public interface IClienteDAO extends PagingAndSortingRepository<Cliente, Long>{

}
