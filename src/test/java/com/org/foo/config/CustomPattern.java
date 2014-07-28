package com.org.foo.config;

import org.sikuli.script.Pattern;

public class CustomPattern extends Pattern {
	private static String rootPath;

	public static String getRootPath() {
		return rootPath;
	}

	public static void setRootPath(String rootPath) {
		CustomPattern.rootPath = rootPath;
	}

	public CustomPattern(String rootPath) {
		setRootPath(rootPath);
	}
	@Override
	public Pattern setFilename(String imgURL_) {
		return super.setFilename(getRootPath() + imgURL_);
	}
	
	

}
