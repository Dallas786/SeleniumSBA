package tests;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import util.ExcelUtil;

public class HomeTest extends BaseTest{
     
	HomePage homePage;
	
	@Test(dataProvider = "getDataFromExcel")
	public void searchValues(String searchString){
		homePage = new HomePage(driver);
		homePage.search(searchString);
		takeScreenShot("After Searching "+ searchString);
	}
    @DataProvider
    public Object[][] getDataFromExcel(){
    	Sheet sheet = ExcelUtil.getSheet("Sheet1"); //Sheet Name Book1.xlsx sheet1 create excel C:\selenium\Projects\WordPress\SeleniumSBA 
	    int rowCount = sheet.getPhysicalNumberOfRows()-1; //-1 to remove the column name
	    Object[][] data = new Object[rowCount][];
	    
	    for(int i=0;i<rowCount;i++){
	      String searchVal = sheet.getRow(i+1).getCell(0).getStringCellValue();//to read the first column value
	      data[i] = new Object[]{searchVal};
	    	
	    }
	    
	    return data;
}
		
}
