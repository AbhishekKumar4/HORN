package com.horn.seed.upload.service;

import java.io.InputStream;

import org.springframework.data.mongodb.gridfs.GridFsResource;

/**
 * @author Abhishek
 *
 */
public interface ImageService {	
	public String uploadImage(InputStream inputStream);
	public GridFsResource getImage(String id);
}
