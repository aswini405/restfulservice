package com.myretail.restfulservice.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.myretail.restfulservice.model.Products;

@Repository
public interface IProductRepo extends CassandraRepository<Products, Integer> {

	Products findByProductId(Integer id);

}
