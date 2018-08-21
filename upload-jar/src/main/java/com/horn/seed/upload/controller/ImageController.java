package com.horn.seed.upload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.horn.seed.upload.service.ImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Abhishek
 *
 */
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
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		String id = imageService.uploadImage(multipartFile.getInputStream());
		return new ResponseEntity<String>(id ,HttpStatus.OK);
	}
	
	@ApiOperation(value = "To Get Image")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully uploaded"),
			@ApiResponse(code = 401, message = "Not authorized to access the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource is not found") })
	@GetMapping(value = "/getImage" , consumes = {
	"multipart/form-data" }, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<InputStreamResource> getImage(@RequestParam("id") String id) throws IOException {
		GridFsResource gridFsResource = imageService.getImage(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(gridFsResource.getContentType())).contentLength(gridFsResource.contentLength()).body(gridFsResource);
	}
}
