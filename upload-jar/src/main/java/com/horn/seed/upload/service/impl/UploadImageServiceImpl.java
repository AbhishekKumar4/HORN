package com.horn.seed.upload.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horn.seed.upload.repository.UploadImageRepository;
import com.horn.seed.upload.service.UploadImageService;
import com.horn.seed.upload.utility.FileNameGenerator;

/**
 * @author Abhishek
 *
 */

@Service
public class UploadImageServiceImpl implements UploadImageService {

	@Autowired
	private UploadImageRepository uploadImageRepository;

	@Override
	public String uploadImage(InputStream inputStream) {
		String fileName = FileNameGenerator.generateFileName();
		/* Store fileName to database */
		//Removing this way of saving file and using mongoDB's GridFs
		/*String filePath = GenerateFilePath.generatePathFromFileName(fileName);
		try {
			String fullFilePath = String.format("E:\\%s.%s", filePath, "jpeg");
			FileUtils.writeByteArrayToFile(new File(fullFilePath), inputStream);
			System.out.println(String.format("File uploaded to path : %s", fullFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return uploadImageRepository.saveImage(inputStream, fileName);
	}
}
