package com.ou.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class GenerateFileCVName {
	private static final String DATE_FORMAT_NOW = "yyyy-MM-dd";

	public static String generateFileName() {
		String result = UUID.randomUUID().toString();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);
		String curentTime = dateFormat.format(calendar.getTime());
		for (String str : curentTime.split("\\s")) {
			result += str;
		}
		return result;
	}

	public static String getExtentionFile(MultipartFile multipartFile) {
		String[] fileFrags = multipartFile.getOriginalFilename().split("\\.");
		String extension = fileFrags[fileFrags.length - 1];
		
		return extension;
	}

}
