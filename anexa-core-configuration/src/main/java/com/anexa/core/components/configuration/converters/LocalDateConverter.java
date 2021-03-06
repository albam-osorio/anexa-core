package com.anexa.core.components.configuration.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class LocalDateConverter implements Converter<String, LocalDate> {

	protected String getDefaultDateFormat() {
		return "yyyy-MM-dd";
	}
	
	@Override
	public LocalDate convert(String source) {
		LocalDate result = null;
		if (source != null) {
			result = LocalDate.parse(source, DateTimeFormatter.ofPattern(getDefaultDateFormat()));
		}
		return result;
	}
}