package com.horn.seed.upload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.horn.seed.upload.service.UploadImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Abhishek
 *
 */
@RestController
@Api(value = "Upload", description = "Operations related to annotations handling")
public class UploadController {

	@Autowired
	private UploadImageService uploadImageService;

	@ApiOperation(value = "To upload image")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully uploaded"),
			@ApiResponse(code = 401, message = "Not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource is not found") })
	@PostMapping(value = "/upload" /* , headers = ("Content-Type=image/*") */ , consumes = {
	"multipart/form-data" }, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		String id = uploadImageService.uploadImage(multipartFile.getInputStream());
		return new ResponseEntity<String>(id ,HttpStatus.OK);
	}
}
