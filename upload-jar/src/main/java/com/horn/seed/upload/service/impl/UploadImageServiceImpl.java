package com.horn.seed.upload.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.horn.seed.upload.service.UploadImageService;
import com.horn.seed.upload.utility.FileNameGenerator;
import com.horn.seed.upload.utility.GenerateFilePath;

/**
 * @author Abhishek
 *
 */

@Service
public class UploadImageServiceImpl implements UploadImageService {

	@Override
	public void uploadImage(byte[] inputStream) {
		String fileName = FileNameGenerator.generateFileName();
		/* Store fileName to database */
		String filePath = GenerateFilePath.generatePathFromFileName(fileName);
		try {
			String fullFilePath = String.format("E:\\%s.%s", filePath, "jpeg");
			FileUtils.writeByteArrayToFile(new File(fullFilePath), inputStream);
			System.out.println(String.format("File uploaded to path : %s", fullFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
