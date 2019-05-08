package com.aig.test.report;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

public class TestReporter implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> iSuites, String directory) {
		/*System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  REPORTS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		printXmlSuite(xmlSuites);
		printISuite(iSuites);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  REPORTS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");*/
	}

	private void printISuite(List<ISuite> iSuites) {
		
		for (ISuite suite : iSuites) {
            //Following code gets the suite name
            String suiteName = suite.getName();
		    //Getting the results for the said suite
		    Map suiteResults = suite.getResults();
		    Collection results = suiteResults.values();
		    Iterator iterator = results.iterator();
		    
		    for(int i=0;i<results.size();i++){
		    	ISuiteResult sr = (ISuiteResult) iterator.next();
		        ITestContext tc = sr.getTestContext();
		        
		        System.out.println("Test context name " + tc.getName());
		        
		        ITestNGMethod[] methods = tc.getAllTestMethods();
		        for(ITestNGMethod method : methods){
		        	System.out.println("method = " + method.getMethodName() + " desc =  " + method.getDescription() + " class = " + method.getTestClass());
		        }
		        
		        System.out.println("Passed tests for suite '" + suiteName +
		             "' is:" + tc.getPassedTests().getAllResults().size());
		        System.out.println("Failed tests for suite '" + suiteName +
		             "' is:" + 
		             tc.getFailedTests().getAllResults().size());
		        System.out.println("Skipped tests for suite '" + suiteName +
		             "' is:" + 
		             tc.getSkippedTests().getAllResults().size());
	      }
        }
		
	}

	private void printXmlSuite(List<XmlSuite> xmlSuites) {
		for(XmlSuite xmlSuite : xmlSuites){
			System.out.println(xmlSuite.getName());
			printXmlSuite(xmlSuite.getChildSuites());
		}
		
		
	}

}
