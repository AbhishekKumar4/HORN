package com.horn.upload.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.horn.upload.model.AllImageUrls;
import com.horn.upload.model.ImageUpload;
import com.horn.upload.service.ImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Abhishek
 *
 */
@CrossOrigin
@RestController
@Api(value = "Upload", description = "Operations related to post image handling")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@ApiOperation(value = "To upload image")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully uploaded"),
			@ApiResponse(code = 401, message = "Not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource is not found") })
	@PostMapping(value = "/upload" /* , headers = ("Content-Type=image/*") */ , consumes = {
			"multipart/form-data" }, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageUpload> uploadImage(@RequestParam("file") MultipartFile multipartFile)
			throws IOException {
		String id = imageService.uploadImage(multipartFile.getInputStream());
		ImageUpload imageUpload = new ImageUpload();
		imageUpload.setId(id);
		return new ResponseEntity<ImageUpload>(imageUpload, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Image")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully uploaded"),
			@ApiResponse(code = 401, message = "Not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource is not found") })
	@GetMapping(value = "/getImage")
	public ResponseEntity<byte[]> getImage(@RequestParam("id") String id) throws IOException {
		GridFsResource gridFsResource = imageService.getImage(id);

		byte[] media = IOUtils.toByteArray(gridFsResource.getInputStream());
		return new ResponseEntity<byte[]>(media, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get All Images")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully uploaded"),
			@ApiResponse(code = 401, message = "Not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource is not found") })
	@GetMapping(value = "/getAllImages")
	public ResponseEntity<AllImageUrls> getAllImages(HttpServletRequest request) throws IOException {
		AllImageUrls allImageUrls = new AllImageUrls();
		allImageUrls.setUrls(imageService.getAllImages(request));
		return new ResponseEntity<AllImageUrls>(allImageUrls, HttpStatus.OK);
	}

}
