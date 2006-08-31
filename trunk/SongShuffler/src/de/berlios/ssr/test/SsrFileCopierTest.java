package de.berlios.ssr.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.berlios.ssr.core.model.impl.SsrFileCopier;

/**
 * Usa la directory testFiles:
 * 
 * <pre>
 *                testFiles/
 *                 |-- geppo.txt
 *                 |-- occhio
 *                 |   |-- alle
 *                 |   |   |-- anselmo.mp4
 *                 |   |   |-- dita
 *                 |   |   |   |-- orpote.mp3
 *                 |   |   |   `-- ortensia.pdf
 *                 |   |   `-- ilare.azz
 *                 |   `-- forfait
 *                 |       `-- tumedar.bat
 *                 `-- pacco.tmp
 * </pre>
 * 
 * @author jack System.getProperty("user.dir") + File.separator + testFiles
 */
public class SsrFileCopierTest {

	private SsrFileCopier fc;

	private File testFilesDir;

	private File testFilesDirCopy;

	private String expectedFileNames[];

	private String testFilesDirPath = System.getProperty("user.dir")
			+ File.separator + "testFiles";

	private String testFilesDirCopyPath = System.getProperty("user.dir")
			+ File.separator + "testFilesCopy";

	private void setUpForAdd() {
		expectedFileNames = new String[] { "geppo.txt", "anselmo.mp4",
				"orpote.mp3", "ortensia.pdf", "ilare.azz", "tumedar.bat",
				"pacco.tmp" };

		testFilesDir = new File(testFilesDirPath);
	}

	private void setUpForCopyAll() {
		testFilesDirCopy = new File(testFilesDirCopyPath);
		testFilesDirCopy.mkdir();
	}

	@Before
	public void setUp() throws Exception {
		fc = SsrFileCopier.instance();

		setUpForAdd();
		setUpForCopyAll();
	}

	@Test
	public void add() {
		fc.add(testFilesDir);

		List fcFileNames = fc.getSourceFileNames();

		for (String fn : expectedFileNames)
			assertTrue(fn + " dovrebbe essere presente nel FileCopier",
					fcFileNames.contains(fn));
	}

	@Test
	public void copyAll() {
		fc.setTargetDir(testFilesDirCopy);

		try {
			fc.copyAll();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String fileNamesInFileCopier[] = { "Joe" };
		String copiedFileNames[] = null;

		fileNamesInFileCopier = fc.getSourceFileNames().toArray(
				fileNamesInFileCopier);
		copiedFileNames = testFilesDirCopy.list();

		Arrays.sort(fileNamesInFileCopier);
		Arrays.sort(copiedFileNames);

		assertTrue(Arrays.equals(fileNamesInFileCopier, copiedFileNames));
	}

	@After
	public void tearDown() throws Exception {
		recursiveDelete(testFilesDirCopy);
	}

	private void recursiveDelete(File file) {
		if (file.isDirectory()) {
			for (File contained : file.listFiles()) {
				recursiveDelete(contained);
			}
		}

		file.delete();
	}

}
