package com.horn.upload.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Abhishek
 *
 */

public final class CurrentDateTimeUtility {

	private CurrentDateTimeUtility() {
		// private constructor
	}

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");

	public static String getCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		return dateTimeFormatter.format(now);
	}
}
