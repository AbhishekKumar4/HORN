package com.horn.seed.upload.repository.impl;

import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.horn.seed.upload.repository.ImageRepository;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;

/**
 * @author Abhishek
 *
 */

@Repository
public class ImageRepositoryImpl implements ImageRepository {

	@Autowired
	private GridFsTemplate gridFsTemplate;
	@Autowired
	private MongoDbFactory mongoDbFactory;
		
	@Override
	public String saveImage(InputStream inputStream, String fileName) {
		ObjectId objectId = gridFsTemplate.store(inputStream, fileName);
		return objectId.toHexString();
	}

	@Override
	public GridFsResource getImage(String id) {
		GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDbFactory.getDb());
		return new GridFsResource(gridFSFile, gridFSBucket.openDownloadStream(gridFSFile.getObjectId()));
	}

}
