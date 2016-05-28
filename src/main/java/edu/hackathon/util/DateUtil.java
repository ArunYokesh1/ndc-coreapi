package edu.hackathon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DateUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	private static SimpleDateFormat smf = new SimpleDateFormat("ddMMMyyyy");

	public static Date parseDate(String date, String pattern) {
		SimpleDateFormat smf = new SimpleDateFormat(pattern);
		try {
			return new Date(smf.parse(date).getTime());
		} catch (ParseException e) {
			LOGGER.error("Exception in parsing date");
			return null;
		}
	}

	public static Date parseDate(String date) {
		try {
			return new Date(smf.parse(date).getTime());
		} catch (ParseException e) {
			LOGGER.error("Exception in parsing date");
			return null;
		}
	}
}
