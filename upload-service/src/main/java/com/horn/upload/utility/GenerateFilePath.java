package com.horn.upload.utility;

/**
 * @author Abhishek
 *
 */

public final class GenerateFilePath {

	private GenerateFilePath() {
		// private constructor
	}

	public static String generatePathFromFileName(String fileName) {
		/* Have to improve this way to generating file path */
		return fileName.replaceAll("-|:", "\\\\");
	}
}
