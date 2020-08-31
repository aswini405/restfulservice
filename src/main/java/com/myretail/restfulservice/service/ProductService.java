package com.myretail.restfulservice.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.myretail.restfulservice.exception.NotFoundException;
import com.myretail.restfulservice.model.Products;
import com.myretail.restfulservice.repository.IProductRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class ProductService.
 */
@Service
@Slf4j
public class ProductService implements IProductService {

	/** The product repo. */
	@Autowired
	private IProductRepo productRepo;

	/** The service url. */
	@Value("${SERVICE_URL}")
	private String serviceUrl;

	/**
	 * Save product details.
	 *
	 * @param products the products
	 * @return the products
	 */
	@Override
	public Products saveProductDetails(Products products) {
		return productRepo.save(products);
	}

	/**
	 * Gets the product details.
	 *
	 * @param id the id
	 * @return the product details
	 */
	@Override
	public Products getProductDetails(Integer id) {
		return productRepo.findByProductId(id);
	}

	/**
	 * Gets the product name.
	 *
	 * @param productId the product id
	 * @return the product name
	 * @throws IOException       Signals that an I/O exception has occurred.
	 * @throws NotFoundException the not found exception
	 */
	@Override
	public String getProductName(String action, Integer productId) throws IOException, NotFoundException {
		serviceUrl = serviceUrl.concat("productName/" + productId.toString());
		URL url = new URL(serviceUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(true);

		log.info("Request URL for GET method: " + url);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer response = new StringBuffer();

		try {
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} finally {
			in.close();
		}
		log.info("Response " + response.toString());
		if (response.toString().contains("404")) {
			throw new NotFoundException("Data not found for given params");
		}
		return response.toString();
	}
}
