package com.horn.seed.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ImageDownload {

	@Getter
	@Setter
	private String url;
	
	@Getter
	@Setter
	private String uri;
}
