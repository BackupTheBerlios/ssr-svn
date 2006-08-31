package de.berlios.ssr.core.model.impl;

import java.io.File;
import java.util.Collection;
import java.util.List;

import de.berlios.ssr.core.model.Filter;

public class SsrFileSelector {
	
	private List <File> selectedFiles;

	private static SsrFileSelector instance;

	public static SsrFileSelector instance() {
		if (instance == null)
			instance = new SsrFileSelector();
		return instance;
	}

	public void select(File dir, Filter filter) {
		// TODO Auto-generated method stub
		
	}

	public Collection<? extends File> getSelectedFiles() {
		return selectedFiles;
	}

}
