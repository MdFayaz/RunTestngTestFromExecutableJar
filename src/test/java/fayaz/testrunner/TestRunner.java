package fayaz.testrunner;

import java.util.Arrays;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestRunner {
	static TestNG testng;
	
	public static void main(String[] args) {
		testng = new TestNG();
		/*
		 * testng.setTestClasses(new Class[]
		 * {fayaz.google.searchtest.GoogleSearch.class}); testng.run();
		 */
		
		XmlClass xmlClass = new XmlClass();
		 xmlClass.setName("fayaz.google.searchtest.GoogleSearch");
		 //        xmlClass.setClass(GalenParallelMain.class);
		/*
		 * Map<String, String> parameters = new HashMap<String, String>();
		 * parameters.put("runtype", "mobile"); parameters.put("browser", "na");
		 */		
		 XmlSuite xmlSuite = new XmlSuite();
		 xmlSuite.setName("RunTestNGFromJarSuite");
		 xmlSuite.setVerbose(5);
		 xmlSuite.setParallel("tests");
		 XmlTest xmlTest = new XmlTest(xmlSuite);
		 xmlTest.setName("RunTestNGFromJarTest");
		 xmlTest.setParallel("tests");
//		 xmlTest.setParameters(parameters);
		 xmlTest.setClasses(Arrays.asList(xmlClass));
		 // the XML you requested
		 System.out.println(xmlSuite.toXml());
		 testng.setXmlSuites(Arrays.asList(xmlSuite));
		 testng.run();
	}

}

