/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExcelReadFile;

import Dao.AdminDao;
import Dao.MedecinDao;
import Dao.SpecialiteDao;
import Metier.Admin;
import Metier.Medecin;
import Metier.Secretaire;
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
public class ExcelReadSecretaire {
        @Autowired
        private SpecialiteDao serviceSpecialite;
        @Autowired
        private AdminDao serviceAdmin;
        @Autowired
        private MedecinDao serviceMedecin;                
    	public List<Secretaire > readBooksFromExcelFile(String excelFilePath) throws IOException {
		List<Secretaire> listMed = new ArrayList<>();
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
			Medecin s = new Medecin();
                        Secretaire med=new Secretaire();
                        Admin ad=new Admin();
			
			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				
				switch (columnIndex) {
				case 0:
					ad.setId_admin(( ((Integer)getCellValue(nextCell)).intValue()));
                                        Admin a= serviceAdmin.findAdminById(ad.getId_admin());
                                        med.setAdmin(a);
					break;
                                case 1:
					s.setId_utilisateur((((Integer)getCellValue(nextCell)).intValue()));
                                        Medecin sa= serviceMedecin.findMedecinById(s.getId_utilisateur());
                                        med.setMedecin(sa);
					break;
                                case 2:
					med.setAdresse((String)getCellValue(nextCell));
					break;    
				
				
                                case 3:
					med.setDate_naissance((String) getCellValue(nextCell));
					break;
				
                                case 4:
					med.setLogin((String) getCellValue(nextCell));
					break;
                        
                                case 5:
					med.setNom((String) getCellValue(nextCell));
					break;
                                case 6:
					med.setNumero_telephone((String) getCellValue(nextCell));
					break;   
                                case 7:
					med.setPassword((String) getCellValue(nextCell));
					break;   
                                case 8:
					med.setPrenom((String) getCellValue(nextCell));
					break;                                    
                        }                                
			}
			listMed.add(med);
			
		}
		
		file.close();
	
		
		return listMed;
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


}
