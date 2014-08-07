package com.accenture.mobility.swv.sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class CustomScreen extends Screen {

	
	private static String rootPath;

	public static String getRootPath() {
		return rootPath;
	}

	public static void setRootPath(String rootPath) {
		CustomScreen.rootPath = rootPath;
	}
	public CustomScreen(String rootPath) {
		setRootPath(rootPath);
	}
	@Override
	public <PatternOrString> Match find(PatternOrString arg0) throws FindFailed {
		return super.find(getRootPath() + arg0);
	}
}
