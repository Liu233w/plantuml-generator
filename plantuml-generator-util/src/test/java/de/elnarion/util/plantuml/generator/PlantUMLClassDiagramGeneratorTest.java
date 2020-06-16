package de.elnarion.util.plantuml.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import de.elnarion.test.domain.t0021.package2.ClassB;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import de.elnarion.util.plantuml.generator.classdiagram.ClassifierType;
import de.elnarion.util.plantuml.generator.classdiagram.VisibilityType;
import de.elnarion.util.plantuml.generator.config.PlantUMLConfig;
import de.elnarion.util.plantuml.generator.config.PlantUMLConfigBuilder;

/**
 * The Class PlantUMLClassDiagramGeneratorTest tests the
 * {@link PlantUMLClassDiagramGenerator}.
 */
public class PlantUMLClassDiagramGeneratorTest {

	/**
	 * Test generate diagram with a normal test case with different linked classes
	 * and compares the result with the text of the file 0001_general_diagram.txt.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0001GenerateDiagram() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0001");
		List<String> hideClasses = new ArrayList<>();
		hideClasses.add("de.elnarion.test.domain.ChildB");
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, false, false);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
				.toString(this.getClass().getClassLoader().getResource("0001_general_diagram.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test 0002 with different class types.
	 *
	 * @throws IOException            Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0002ClassTypes() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0002");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, false, false);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
				.toString(this.getClass().getClassLoader().getResource("0002_class_types.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test 0003 test different class relationships.
	 *
	 * @throws IOException            Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0003ClassRelationships() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0003");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, false, false);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
				.toString(this.getClass().getClassLoader().getResource("0003_class_relationships.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test 0004 test different field variations.
	 *
	 * @throws IOException            Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0004ClassFields() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0004");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, false, false);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
				.toString(this.getClass().getClassLoader().getResource("0004_class_fields.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test 0005 test different class method variations.
	 *
	 * @throws IOException            Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0005ClassMethods() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0005");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, false, false);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
				.toString(this.getClass().getClassLoader().getResource("0005_class_methods.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test 0006 test different packages as scan list.
	 *
	 * @throws IOException            Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0006DifferentPackages() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0006.pck1");
		scanpackages.add("de.elnarion.test.domain.t0006.pck2");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, false, false);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
				.toString(this.getClass().getClassLoader().getResource("0006_different_packages.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test 0007 test hide toggles.
	 *
	 * @throws IOException            Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0007HideParameters() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0007");
		List<String> hideClasses = new ArrayList<>();
		hideClasses.add("de.elnarion.test.domain.t0007.ClassB");
		hideClasses.add("de.elnarion.test.domain.t0007.ClassC");
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, true, true);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
				.toString(this.getClass().getClassLoader().getResource("0007_hide_parameters.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test 0010 test parameterized aggregation type.
	 *
	 * @throws IOException            Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test0010ParameterizedAggregationType() throws IOException, ClassNotFoundException {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0010");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, true, true);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(
				this.getClass().getClassLoader().getResource("0010_parameterized_aggregation_type.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test custom classloader.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testClassloader() throws Exception {
		String filename = "0008_classloader_test.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.maven.plugin.plantuml.generator.test.domain.ChildA");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.maven.plugin.plantuml.generator.test.domain");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(classLoader, scanpackages, null,
				hideClasses, true, true);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test classes contained in a package in a jar.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testJarPackage() throws Exception {
		String filename = "0009_jar_test.txt";
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("org.apache.commons.io.monitor");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, null, hideClasses, true, true);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test classes contained in a package in a jar.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testJarPackageWithBlacklist() throws Exception {
		String filename = "0011_jar_test_blacklist.txt";
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("org.apache.commons.io.monitor");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				scanpackages, ".*FileEn.*", hideClasses, true, true);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	/**
	 * Test classes contained in a package in a jar.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testJarPackageWithWithelist() throws Exception {
		String filename = "0012_jar_whitelist.txt";
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("org.apache.commons.io.monitor");
		List<String> hideClasses = new ArrayList<>();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(this.getClass().getClassLoader(),
				".*FileAl.*", hideClasses, true, true,null);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	@Test
	public void test0013MaxVisibilityFields() throws Exception{
		String filename = "0013_max_visibility_fields_public.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0013.Testclass");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0013");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumFieldVisibility(VisibilityType.PUBLIC).build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
		config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumFieldVisibility(VisibilityType.PROTECTED).build();
		generator = new PlantUMLClassDiagramGenerator(config);
		result = generator.generateDiagramText();
		filename = "0013_max_visibility_fields_protected.txt";
		expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
		config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumFieldVisibility(VisibilityType.PACKAGE_PRIVATE).build();
		generator = new PlantUMLClassDiagramGenerator(config);
		result = generator.generateDiagramText();
		filename = "0013_max_visibility_fields_package_private.txt";
		expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
		config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumFieldVisibility(VisibilityType.PRIVATE).build();
		generator = new PlantUMLClassDiagramGenerator(config);
		result = generator.generateDiagramText();
		filename = "0013_max_visibility_fields_private.txt";
		expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	@Test
	public void test0014MaxVisibilityMethods() throws Exception{
		String filename = "0014_max_visibility_methods_public.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0014.Testclass");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0014");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumMethodVisibility(VisibilityType.PUBLIC).build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
		config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumMethodVisibility(VisibilityType.PROTECTED).build();
		generator = new PlantUMLClassDiagramGenerator(config);
		result = generator.generateDiagramText();
		filename = "0014_max_visibility_methods_protected.txt";
		expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
		config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumMethodVisibility(VisibilityType.PACKAGE_PRIVATE).build();
		generator = new PlantUMLClassDiagramGenerator(config);
		result = generator.generateDiagramText();
		filename = "0014_max_visibility_methods_package_private.txt";
		expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
		config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMaximumMethodVisibility(VisibilityType.PRIVATE).build();
		generator = new PlantUMLClassDiagramGenerator(config);
		result = generator.generateDiagramText();
		filename = "0014_max_visibility_methods_private.txt";
		expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}	

	@Test
	public void test0015RemoveMethods() throws Exception{
		String filename = "0015_remove_methods.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0015.Testclass1");
		classLoader.loadClass("de.elnarion.test.domain.t0015.Testclass2");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0015");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withRemoveMethods(true).build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}		

	@Test
	public void test0016RemoveFields() throws Exception{
		String filename = "0016_remove_fields.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0016.Testclass1");
		classLoader.loadClass("de.elnarion.test.domain.t0016.Testclass2");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0016");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withRemoveFields(true).build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}		

	@Test
	public void test0017BlacklistMethods() throws Exception{
		String filename = "0017_blacklist_methods.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0017.Testclass1");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0017");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withMethodBlacklistRegexp(".*doSomething1.*").build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}		

	@Test
	public void test0018BlacklistFields() throws Exception{
		String filename = "0018_blacklist_fields.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0018.Testclass1");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0018");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).withFieldBlacklistRegexp("test1").build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}		

	@Test
	public void test0019IgnoreClassifierFields() throws Exception{
		String filename = "0019_ignore_classifier_fields.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0019.Testclass");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0019");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).addFieldClassifierToIgnore(ClassifierType.STATIC).build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}		

	@Test
	public void test0020IgnoreClassifierMethods() throws Exception{
		String filename = "0020_ignore_classifier_methods.txt";
		URL testResourceURL = this.getClass().getClassLoader().getResource(filename);
		String testResourceURLString = testResourceURL.toString();
		String testClassPath = testResourceURLString.substring(0, testResourceURLString.length() - filename.length())
				+ "../../src/test/classes/";
		URL[] classesURLs = new URL[] { new URL(testClassPath) };
		URLClassLoader classLoader = new URLClassLoader(classesURLs);
		classLoader.loadClass("de.elnarion.test.domain.t0020.Testclass");
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0020");
		PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages).withClassLoader(classLoader).addMethodClassifierToIgnore(ClassifierType.STATIC).build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils.toString(this.getClass().getClassLoader().getResource(filename), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}

	@Test
	public void test0021AdditionalClass() throws Exception {
		List<String> scanpackages = new ArrayList<>();
		scanpackages.add("de.elnarion.test.domain.t0021.package1");
		final PlantUMLConfig config = new PlantUMLConfigBuilder(scanpackages)
			.withClassLoader(this.getClass().getClassLoader())
			.withAdditionalClasses(ClassB.class)
			.build();
		PlantUMLClassDiagramGenerator generator = new PlantUMLClassDiagramGenerator(config);
		String result = generator.generateDiagramText();
		String expectedDiagramText = IOUtils
			.toString(this.getClass().getClassLoader().getResource("0021_additional_class.txt"), "utf-8");
		assertNotNull(result);
		assertNotNull(expectedDiagramText);
		assertEquals(expectedDiagramText.replaceAll("\\s+", ""), result.replaceAll("\\s+", ""));
	}
}
