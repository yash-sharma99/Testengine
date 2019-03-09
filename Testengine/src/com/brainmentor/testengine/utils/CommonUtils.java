package com.brainmentor.testengine.utils;

import java.io.File;

public interface CommonUtils {
	public static String getFileName(String path ) {
		System.out.println("Path is "+path);
		int index = path.lastIndexOf("\\");

		System.out.println("Index is "+index);
	
		return path.substring(index);

	}

}
