package de.berlios.ssr.core.model.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SsrFileCopier {

	private static SsrFileCopier instance;

	private List<File> sourceFiles;

	private File targetDir;

	public static SsrFileCopier instance() {
		if (instance == null)
			instance = new SsrFileCopier();
		return instance;
	}

	private SsrFileCopier() {
		sourceFiles = new ArrayList<File>();
	}

	public void add(File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				this.add(f);
			}
		} else {
			sourceFiles.add(file);
		}
	}

	/**
	 * TODO
	 * 
	 * @param sfl
	 */
	public void add(SsrFileSelector sfl) {
		this.sourceFiles.addAll(sfl.getSelectedFiles());
	}

	public void copyAll() throws IllegalArgumentException, IOException {
		for (File f : sourceFiles) {
			copy(f, targetDir);
		}
	}

	public File getTargetDir() {
		return targetDir;
	}

	public void setTargetDir(File targetDir) {
		this.targetDir = targetDir;
	}

	public void setTargetDir(String path) {
		this.setTargetDir(new File(path));
	}

	public List<File> getSourceFiles() {
		return sourceFiles;
	}

	public List<String> getSourceFileNames() {
		List<String> sfp = new ArrayList<String>();

		for (File f : sourceFiles) {
			sfp.add(f.getName());
		}

		return sfp;
	}

	/**
	 * Copia il File source nella directory destDir. Il nuovo file ha lo stesso
	 * nome dell'originale
	 * <p />
	 * TODO: bufferizzare lettura e scrittura, ora legge e scrive un byte alla
	 * volta!
	 * <p />
	 * TODO: si può usare un ProgressMonitorInputStream? (v. <a
	 * href="http://java.sun.com/docs/books/tutorial/uiswing/components/progress.html">How
	 * To Monitor Progress</a>)
	 * 
	 * @param source
	 *            il File da copiare
	 * @param destDir
	 *            la cartella in cui copiare il File source
	 * @throws IllegalArgumentException
	 *             se destDir non è una directory
	 * @throws IOException
	 *             se la copia fallisce
	 */
	private static void copy(File source, File destDir)
			throws IllegalArgumentException, IOException {

		if (!destDir.isDirectory())
			throw new IllegalArgumentException("Destination is not a directory");

		InputStream in = new FileInputStream(source);
		OutputStream out = new FileOutputStream(destDir.getPath()
				+ File.separator + source.getName());

		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
	}
}
