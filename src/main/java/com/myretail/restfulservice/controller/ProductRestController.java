package com.myretail.restfulservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.restfulservice.exception.NotFoundException;
import com.myretail.restfulservice.model.Products;
import com.myretail.restfulservice.service.IProductService;

import lombok.extern.slf4j.Slf4j;

/**
 * class ProductRestController.
 *
 * @author Aswini
 */
@RestController
/** The Constant log. */
@Slf4j
public class ProductRestController {

	/** The product service. */
	@Autowired
	private IProductService productService;

	/**
	 * Save product details.
	 *
	 * @param products the products
	 * @param id       the id
	 * @return the response entity
	 */
	@PutMapping(path = "products/{id}")
	public ResponseEntity<String> saveProductDetails(@RequestBody(required = true) Products products,
			@PathVariable(name = "id") Integer id) {
		if (id.intValue() != products.getProductId().intValue()) {
			log.error("Id should be same");
		}
		Products resProducts = productService.saveProductDetails(products);
		return ResponseEntity.ok().body("Succesfully saved/updated " + resProducts.getProductId());

	}

	/**
	 * Gets the product details.
	 *
	 * @param id the id
	 * @return the product details
	 * @throws NotFoundException
	 * @throws IOException
	 */
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Products> getProductDetails(@PathVariable(name = "id", required = true) Integer id)
			throws IOException, NotFoundException {
		Products resProducts = productService.getProductDetails(id);
		String productName = productService.getProductName("productName", id);
		resProducts.setName(productName);
		return ResponseEntity.ok().body(resProducts);

	}

	/**
	 * Gets the product name.
	 *
	 * @param productId the product id
	 * @return the product name
	 * @throws IOException       Signals that an I/O exception has occurred.
	 * @throws NotFoundException the not found exception
	 */
	@GetMapping(path = "productName/{id}")
	public ResponseEntity<String> getProductName(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok().body("The Big Lebowski (Blu-ray) (Widescreen)");

	}

}
