/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExcelReadFile;
import Dao.AdminDao;
import Dao.SpecialiteDaoImpl;
import Metier.Admin;
import Metier.Specialite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author soukaina
 */
public class ExcellReadSpecialite {
    
        @Autowired
        private AdminDao serviceAdmin;

    	public List<Specialite> readBooksFromExcelFile(String excelFilePath) throws IOException {
		List<Specialite> listSpecialite = new ArrayList<>();
		FileInputStream file = new FileInputStream(new File(excelFilePath));

		//Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Specialite sp = new Specialite();
                        Admin admin=new Admin();
			
			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				
				switch (columnIndex) {
				case 0:
					sp.setIntitule((String) getCellValue(nextCell));
					break;
				
				}
				
				
			}
			listSpecialite.add(sp);
			
		}
		
		file.close();
	
		
		return listSpecialite;
	}
	
	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
			
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case (int)Cell.CELL_TYPE_NUMERIC:
			return (int)Math.round(cell.getNumericCellValue());
		}
		

		return null;
	}

	public static void main(String[] args) throws IOException {
   
                        
                                
                        String excelFilePath = "specialite.xlsx";
			ExcellReadSpecialite reader = new ExcellReadSpecialite();
                        List<Specialite> listSpecialite = reader.readBooksFromExcelFile(excelFilePath);
                        SpecialiteDaoImpl serviceSpe=new SpecialiteDaoImpl();
                        for( Specialite s : listSpecialite){
                        try {
                            
                           serviceSpe.saveSpecialite(s);
                           System.out.println("Specialite :"+s.getIntitule()+"\t");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }}
		
	}

}
