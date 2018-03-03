package com.luog.onlinemusic.helpers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageHelper {

	
	public static String saveImage(ServletContext servletContext, MultipartFile image) {
		try {
			File file = new File(
					servletContext.getRealPath("/") + "/assets/images/" + image.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			return image.getOriginalFilename();
		} catch (IOException e) {
			return null;
		}
	}

	public static boolean validateImage(MultipartFile image) {
		return image.getContentType().equals("image/jpeg") || image.getContentType().equals("image/jpg")
				|| image.getContentType().equals("image/gif") || image.getContentType().equals("image/png");
	}
}
