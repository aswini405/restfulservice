package com.myretail.restfulservice.controller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.myretail.restfulservice.model.Products;
import com.myretail.restfulservice.service.IProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductRestControllerTest {

	@InjectMocks
	private ProductRestController productRestController;

	@Mock
	private IProductService productService;
	private Products products;

	@Before
	public void setup()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		products = new Products();
		products.setProductId(123);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveProductDetails() throws Exception {
		when(productService.saveProductDetails(products)).thenReturn(products);
		productRestController.saveProductDetails(products, 123);
	}
	
	@Test
	public void testSaveProductDetailsMismatch() throws Exception {
		when(productService.saveProductDetails(products)).thenReturn(products);
		productRestController.saveProductDetails(products, 12);
	}

	@Test
	public void testGetProductDetails() throws Exception {
		when(productService.getProductDetails(123)).thenReturn(products);
		productRestController.getProductDetails(123);
	}

}
