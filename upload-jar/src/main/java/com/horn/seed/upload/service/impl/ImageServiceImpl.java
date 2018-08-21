package com.horn.seed.upload.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;

import com.horn.seed.upload.repository.ImageRepository;
import com.horn.seed.upload.service.ImageService;
import com.horn.seed.upload.utility.FileNameGenerator;

/**
 * @author Abhishek
 *
 */

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	


	@Override
	public String uploadImage(InputStream inputStream) {
		String fileName = FileNameGenerator.generateFileName();
		return imageRepository.saveImage(inputStream, fileName);
	}

	@Override
	public GridFsResource getImage(String id) {
		return imageRepository.getImage(id);
	}
}
