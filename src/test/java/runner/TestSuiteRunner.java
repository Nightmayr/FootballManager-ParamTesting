package runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import createTest.CreateAccountTestSuite;
import joinTest.ListTestSuite;
import loginTest.LoginTestSuite;
import navbarTest.NavbarTestSuite;

public class TestSuiteRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CreateAccountTestSuite.class, LoginTestSuite.class, ListTestSuite.class, NavbarTestSuite.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println();
		System.out.println("All tests pass y/n?:\n" + result.wasSuccessful());
		System.out.println("Test time:\n" + result.getRunTime() / 1000 + "s");
	}

}