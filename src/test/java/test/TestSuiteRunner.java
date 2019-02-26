package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CreateAccountTestSuite.class, LoginTestSuite.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println();
		System.out.println("All tests pass y/n?:\n" + result.wasSuccessful());
		System.out.println("Test time:\n" + result.getRunTime()/1000 +"s");
	}

}