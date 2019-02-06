package com.horn.seed.upload.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;

import com.horn.seed.upload.repository.ImageRepository;
import com.horn.seed.upload.service.ImageService;
import com.horn.seed.upload.utility.FileNameGenerator;
import com.mongodb.client.gridfs.model.GridFSFile;

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

	@Override
	public List<String> getAllImages() {
		List<String> listofIds = new ArrayList<String>();
		List<GridFSFile> gridFSFileList = imageRepository.getAllImages();
		gridFSFileList.forEach(gridfsfile -> {
			String id = gridfsfile.getId().toString();
			listofIds.add(id);
		});
		return listofIds;
	}
}
