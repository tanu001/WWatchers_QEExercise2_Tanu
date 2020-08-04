
import java.io.IOException;

import question2.Utilis.DoesFileExist;



public class Answer1 {
	public static void main(String[] args) throws IOException 
	{
		
			DoesFileExist file = new DoesFileExist(System.getProperty("user.dir")+"/src/test/java/com/testData/ReadData.xlsx" );
			//no of rows  in the XL data sheet
			System.out.println("============Printing all rows of a specific column ============");
			int rows=file.getRowCount(0);
			for(int row=1; row<rows; row++) {
			
				System.out.println(file.getData(0, row, 0));
				}
			
	}	
}
	

