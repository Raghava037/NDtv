package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains reusable methods to perform operation on excel workbook
 * @author Monikrish
 *
 */
public class ExcelUtility 
{
	private Workbook wb;
	/**
	 * this method is used to initialize  excel workbook
	 * @param execelpath
	 */
	public void excelInitialization(String execelpath)
	{
		FileInputStream fis=null;
		try 
		{
			fis=new FileInputStream(execelpath);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			wb=WorkbookFactory.create(fis);
		} 
		catch (EncryptedDocumentException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch single data from excel
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 */
	public String fetchDataFromExcel(String sheetName,int rownum,int cellnum)
	{
			return wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	/**
	 * this method is used to fetch multiple data from excel
	 * @param sheetName
	 * @return
	 */
	
	
	
	public List<String> fetchDataFromExcel(String sheetName)
	{
		List<String> dataList=new ArrayList<>();
		Sheet sheet=wb.getSheet(sheetName);
		for (int i = 0; i <4; i++) 
		{
			String data =sheet.getRow(i).getCell(1).getStringCellValue();
			dataList.add(data);
		}
		return dataList;
	}
	/**
	 * this method is used to close 
	 */
	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
