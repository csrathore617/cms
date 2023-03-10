package com.pytosoft.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.pytosoft.constants.DatePattern;

@Component
public class JsonDateTimeDeserializer extends JsonDeserializer<Date>
{
	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException,
			JsonProcessingException
	{
		SimpleDateFormat format = new SimpleDateFormat(DatePattern.INDIAN_DATE_TIME.getPattern());
		String date = jsonparser.getText();
		try
		{
			return format.parse(date);
		} catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
	}

}
