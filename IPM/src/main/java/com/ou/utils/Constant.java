package com.ou.utils;

import java.io.File;

public interface Constant {
	interface ROLE {
		int ADMIN = 1;
		int HR = 2;
		int INTERVIEWER = 3;
	}
	
	String FOLDER_UPLOAD = "upload" + File.separator;
	
	int PAGE_SIZE = 10;
}
