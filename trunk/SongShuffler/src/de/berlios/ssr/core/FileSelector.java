package de.berlios.ssr.core;

import java.io.File;
import java.util.ArrayList;

/**
 * @author jack
 * 
 */
public class FileSelector {
	private ArrayList<File> source;

	private ArrayList<File> recursiveSource;

	private File target;

	/**
	 * I file sono cercati nelle directory impostate da setSource e
	 * setRecursiveSource: nelle prime vengono scelti i file contenuti
	 * direttamente nella directory, nelle seconde anche i file contenuti nelle
	 * sottodirectory fino al massimo livello di profondità.
	 * 
	 * @return un ArrayList di File contenuti nelle directory sorgente.
	 */
	public ArrayList<File> getFiles() {
		return null;
	}

	private void addSourceDirectory(File source, ArrayList<File> what)
			throws IllegalArgumentException {
		if (source.isDirectory())
			this.source.add(source);
		else
			throw new IllegalArgumentException("not a directory");
	}

	public void addSource(File source) throws IllegalArgumentException {
		this.addSourceDirectory(source, this.source);
	}

	public void addRecursiveSource(File source) throws IllegalArgumentException {
		this.addSourceDirectory(source, this.recursiveSource);
	}

	public File getTarget() {
		return target;
	}

	public void setTarget(File target) throws IllegalArgumentException {
		if (target.isDirectory())
			this.target = target;
		else
			throw new IllegalArgumentException("not a directory");
	}
}
