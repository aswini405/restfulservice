package com.myretail.restfulservice.service;

import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.myretail.restfulservice.model.Products;
import com.myretail.restfulservice.repository.IProductRepo;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService proService;

	@Mock
	private IProductRepo productRepo;
	private Products products;

	private Field url;
	Class clazz;

	@Before
	public void setup()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		products = new Products();
		products.setProductId(123);
		url = ProductService.class.getDeclaredField("serviceUrl");
		url.setAccessible(true);
		url.set(proService, "http://localhost:8080/");
//		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveProductDetails() throws Exception {
		when(productRepo.save(products)).thenReturn(products);
		proService.saveProductDetails(products);
	}

	@Test
	public void testGetProductDetails() throws Exception {
		when(productRepo.findByProductId(123)).thenReturn(products);
		proService.getProductDetails(123);
	}

	@Test
	public void testGetProductName() throws Exception {
		proService.getProductName("testaction", 123);
	}

}
