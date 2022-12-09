package com.unab.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.unab.app.models.Producto;

public interface IProductoDAO extends PagingAndSortingRepository<Producto, Long>{

}
