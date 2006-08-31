package de.berlios.ssr.test;

import java.io.File;

import org.junit.After;
import org.junit.Before;

import de.berlios.ssr.core.model.Filter;
import de.berlios.ssr.core.model.impl.SsrFileSelector;

public class SsrFileSelectorTest {

	SsrFileSelector fileSelector;

	File dir;

	Filter filter;

	@Before
	public void setUp() throws Exception {
		fileSelector = SsrFileSelector.instance();

		fileSelector.select(dir, filter);
	}

	@After
	public void tearDown() throws Exception {
	}

}
