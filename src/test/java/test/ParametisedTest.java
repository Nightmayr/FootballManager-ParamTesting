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
import org.openqa.selenium.support.PageFactory;

import main.AddUserEntry;
import main.AddUserResult;
import main.Constant;

@RunWith(Parameterized.class)
public class ParametisedTest {
	
	@Parameters
	public static Collection<Object[]> inputData() throws IOException {
		FileInputStream file = new FileInputStream(Constant.FILELOCATION);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Object[][] obj = new Object[sheet.getPhysicalNumberOfRows()-1][4];
		
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
				obj[rowNum-1][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue();
				obj[rowNum-1][1] = sheet.getRow(rowNum).getCell(1).getStringCellValue();
				obj[rowNum-1][2] = sheet.getRow(rowNum).getCell(2).getStringCellValue();
				obj[rowNum-1][3] = rowNum;
			}
		workbook.close();
		return Arrays.asList(obj);
		
		}
	
	private String username;
	private String password;
	private String expected;
	private int rowNum;
	private WebDriver driver;
	
	public ParametisedTest(String username, String password, String expected, int rowNum) {
		this.username = username;
		this.password = password;
		this.expected = expected;
		this.rowNum = rowNum;
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVERLOCATION);
		driver = new ChromeDriver();
	}
	
	@Test
	public void addUserAttempt() throws IOException, InterruptedException {

		driver.get(Constant.ADDUSERPAGE);
		AddUserEntry addUserPage = PageFactory.initElements(driver, AddUserEntry.class);
		addUserPage.addUser(username, password);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		AddUserResult addUserResult = PageFactory.initElements(driver, AddUserResult.class);
		
		FileInputStream file = new FileInputStream(Constant.FILELOCATION);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell;
		cell = row.getCell(3);
		if (cell == null) {
			cell = row.createCell(3);
		}
		
		
		cell.setCellValue(addUserResult.addUserAttemptText());
		
		try {
			assertEquals("User not added.", expected, addUserResult.addUserAttemptText());
			cell = row.getCell(4);
			if (cell == null) {
				cell = row.createCell(4);
			}
			cell.setCellValue("PASS");
		} catch (AssertionError fail) {
			cell = row.getCell(4);
			if (cell == null) {
				cell = row.createCell(4); 
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
