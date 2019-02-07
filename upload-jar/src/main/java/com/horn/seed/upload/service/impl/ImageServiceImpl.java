package com.horn.seed.upload.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public List<String> getAllImages(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		String serverPort = Integer.toString(request.getServerPort());
		String url = scheme + "://" + serverName + ":" + serverPort + contextPath + "/getImage?id=";
		System.out.println("Print Url ::" + url);
		List<String> listofUrls = new ArrayList<String>();
		List<GridFSFile> gridFSFileList = imageRepository.getAllImages();
		gridFSFileList.forEach(gridfsfile -> {
			String id = gridfsfile.getObjectId().toHexString();
			String imageUrl = url + id;
			listofUrls.add(imageUrl);
		});
		return listofUrls;
	}
}
