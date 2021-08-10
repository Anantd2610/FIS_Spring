package com.fis.springlearn;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Country {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	String code;
	String name;
	
	public Country()
	{
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	

	

}
