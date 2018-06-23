package com.horn.seed.upload.utility;

import java.util.UUID;

/**
 * @author Abhishek
 *
 */
public final class FileNameGenerator {

	private FileNameGenerator() {
		// private constructor
	}

	public static String generateFileName() {
		UUID uuid = UUID.randomUUID();
		return String.format("%s-%s", CurrentDateTimeUtility.getCurrentDateTime(), uuid.toString());
	}
}
