package com.horn.seed.upload.repository;

import java.io.InputStream;
import java.util.List;

import org.springframework.data.mongodb.gridfs.GridFsResource;

import com.mongodb.client.gridfs.model.GridFSFile;

/**
 * @author Abhishek
 *
 */

public interface ImageRepository {
	public String saveImage(InputStream inputStream, String fileName);
	public GridFsResource getImage(String id);
	public List<GridFSFile> getAllImages();
}
