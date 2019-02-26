package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateAccountParametisedTest.class, CreateAccountNoNameParaTest.class, CreateAccountNoEmailParaTest.class,
		CreateAccountNoPassParaTest.class, CreateAccountNoConfirmParaTest.class, CreateAccountNoInputParaTest.class })
public class CreateAccountTestSuite {

}
