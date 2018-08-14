package com.horn.seed.upload.repository.impl;

import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import com.horn.seed.upload.repository.UploadImageRepository;

/**
 * @author Abhishek
 *
 */

@Repository
public class UploadImageRepositoryImpl implements UploadImageRepository {

	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@Override
	public String saveImage(InputStream inputStream, String fileName) {
		ObjectId objectId = gridFsTemplate.store(inputStream, fileName);
		return objectId.toHexString();
	}

}
