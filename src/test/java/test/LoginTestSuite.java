package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LoginParametisedTest.class, LoginNoEmailParaTest.class, LoginNoPassParaTest.class, LoginNoInputParaTest.class})
public class LoginTestSuite {

}
