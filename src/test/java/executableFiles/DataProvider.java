package executableFiles;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class DataProvider 
{
	@org.testng.annotations.DataProvider
	public String[][] readData() throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("./datadriven.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("datadriven");
		
		int lastRowNum = sheet.getLastRowNum(); //0-4
		int lastCellNum = sheet.getRow(0).getLastCellNum(); //1-2
		
		String[][] obj = new String[lastRowNum+1][lastCellNum];
		//System.out.println(obj.length);
		
		for (int i = 0; i < lastCellNum; i++) 
		{
			for (int j = 0; j < lastRowNum+1; j++) 
			{
				obj[j][i]=sheet.getRow(j).getCell(i).toString();
				//System.out.println(i+" "+j);
			}
		}
		return obj;
	}
	
	
}
