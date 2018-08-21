package com.horn.seed.upload.repository;

import java.io.InputStream;

import org.springframework.data.mongodb.gridfs.GridFsResource;

/**
 * @author Abhishek
 *
 */

public interface ImageRepository {
	public String saveImage(InputStream inputStream, String fileName);
	public GridFsResource getImage(String id);
}
