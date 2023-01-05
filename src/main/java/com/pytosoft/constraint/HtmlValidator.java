package com.pytosoft.constraint;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;


public class HtmlValidator implements ConstraintValidator<NotHtml, String>
{

	public final static String TAG_START = "\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)\\>";

	public final static String TAG_END = "\\</\\w+\\>";

	public final static String TAG_SELF_CLOSING = "\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)/\\>";

	public final static String HTML_ENTITY = "&[a-zA-Z][a-zA-Z0-9]+;";

	public final static Pattern HTML_PATTERN = compilePattern();

	@Override
	public void initialize(NotHtml constraintAnnotation)
	{

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context)
	{
		if (StringUtils.isBlank(value))
		{
			return true;
		}
		boolean found = HTML_PATTERN.matcher(value).find();
		// if html found than return invalid else return valid
		return found ? false : true;
	}

	private static Pattern compilePattern()
	{
		return Pattern.compile("(" + TAG_START + ".*" + TAG_END + ")|(" + TAG_SELF_CLOSING + ")|(" + HTML_ENTITY + ")",
				Pattern.DOTALL);
	}

}
