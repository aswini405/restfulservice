package com.myretail.restfulservice.service;

import java.io.IOException;

import com.myretail.restfulservice.exception.NotFoundException;
import com.myretail.restfulservice.model.Products;

public interface IProductService {

	Products saveProductDetails(Products products);

	Products getProductDetails(Integer id);

	String getProductName(String action, Integer productId) throws IOException, NotFoundException;

}
