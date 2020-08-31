package com.myretail.restfulservice.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Products.
 *
 * @author Aswini
 */

/**
 * Gets the current price.
 *
 * @return the current price
 */
@Getter

/**
 * Sets the current price.
 *
 * @param currentPrice the new current price
 */
@Setter
@Table(value = "products")
public class Products {

	/** The product id. */
	@PrimaryKeyColumn(name = "product_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@JsonProperty(value = "id")
	private Integer productId;

	/** The name. */
	private String name;

	/** The price. */
	@Column(value = "current_price")
	@JsonProperty(value = "current_price")
	private CurrentPrice currentPrice;

}
