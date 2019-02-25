package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import main.Constant;
import main.CreateAccountEntry;
import main.CreateAccountResult;

@RunWith(Parameterized.class)
public class CreateAccountNoInputParaTest {
	
	@Parameters
	public static Collection<Object[]> inputData() throws IOException {
		FileInputStream file = new FileInputStream(Constant.FILELOCATION);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(5);

		Object[][] obj = new Object[sheet.getPhysicalNumberOfRows() - 1][2];

		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {

			obj[rowNum - 1][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue();
			obj[rowNum - 1][1] = rowNum;
		}
		workbook.close();
		return Arrays.asList(obj);

	}

	private String expected;
	private int rowNum;
	private WebDriver driver;

	public CreateAccountNoInputParaTest(String expected, int rowNum) {
		this.expected = expected;
		this.rowNum = rowNum;
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVERLOCATION);
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--headless");
		driver = new ChromeDriver(chromeoptions);
	}

	@Test
	public void addAccountAttempt() throws IOException, InterruptedException {

		driver.get(Constant.ADDACCOUNTPAGE);
		CreateAccountEntry addAccountPage = PageFactory.initElements(driver, CreateAccountEntry.class);
		addAccountPage.addAccountNoInput();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		CreateAccountResult addAccountResult = PageFactory.initElements(driver, CreateAccountResult.class);

		FileInputStream file = new FileInputStream(Constant.FILELOCATION);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(5);

		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell;
		cell = row.getCell(1);
		if (cell == null) {
			cell = row.createCell(1);
		}

		cell.setCellValue(addAccountResult.createAccountAttemptText());

		try {
			assertEquals("Test failure.", expected, addAccountResult.createAccountAttemptText());
			cell = row.getCell(2);
			if (cell == null) {
				cell = row.createCell(2);
			}
			cell.setCellValue("PASS");
		} catch (AssertionError fail) {
			cell = row.getCell(2);
			if (cell == null) {
				cell = row.createCell(2);
			}
			cell.setCellValue("FAIL");
			fail("test failure");
		} finally {

			FileOutputStream fileOut = new FileOutputStream(Constant.FILELOCATION);

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();

			workbook.close();
			file.close();
		}

	}

	@After
	public void teardown() {
		driver.quit();
	}

}
