package functional;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import TestNGBasic.class1;

public class TestRunner {
	
	public TestRunner() {
		triggerTestCase("./testngImpli.xml");
	}
	
	void triggerTestCase(String testCase){
//		class1 c = new class1();
		TestNG testNG = new TestNG();
		List<String> suites = new ArrayList<String>();
//		Class[] clas = new Class[1];      //{c.getClass()};
//		"./src/test/java/TestNGBasic/class1.java";
		
//		clas[0]= (c.getClass());
	
		
		suites.add(testCase);
		suites.add("./testng.xml");
		
//		testNG.setTestClasses(clas);

		testNG.setTestSuites(suites);
		testNG.run();
		
	}
	
}
