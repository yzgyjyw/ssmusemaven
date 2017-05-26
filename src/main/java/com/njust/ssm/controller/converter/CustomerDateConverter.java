package com.njust.ssm.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;



public class CustomerDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(source);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
