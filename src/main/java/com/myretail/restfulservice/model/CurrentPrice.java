package com.myretail.restfulservice.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@UserDefinedType(value = "current_price")
public class CurrentPrice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(value = "value")
	private Float value;

	@Column(value = "currency_code")
	@JsonProperty(value = "currency_code")
	private String currencyCode;

}
