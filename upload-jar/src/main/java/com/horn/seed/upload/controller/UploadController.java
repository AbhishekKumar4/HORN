package com.horn.seed.upload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.horn.seed.upload.service.UploadImageService;

import io.swagger.annotations.Api;

/**
 * @author Abhishek
 *
 */
@RestController
public class UploadController {

	@Autowired
	private UploadImageService uploadImageService;

	
	@PostMapping(value = "/upload" /* , headers = ("Content-Type=image/*") */)
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		String id = uploadImageService.uploadImage(multipartFile.getInputStream());
		return new ResponseEntity<String>(id ,HttpStatus.OK);
	}
}
