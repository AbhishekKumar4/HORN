package com.horn.seed.upload.repository;

import java.io.InputStream;

/**
 * @author Abhishek
 *
 */

public interface UploadImageRepository {

	public String saveImage(InputStream inputStream, String fileName);
}
