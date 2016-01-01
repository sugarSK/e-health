/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExcelReadFile;

import Dao.AdminDao;
import Dao.MedecinDaoImpl;
import Dao.SpecialiteDao;
import Dao.SpecialiteDaoImpl;
import Metier.Admin;
import Metier.Medecin;
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
public class ExcelReadMedecin {

    @Autowired
    private SpecialiteDao serviceSpecialite;
    @Autowired
    private AdminDao serviceAdmin;

    public void setServiceSpecialite(SpecialiteDao serviceSpecialite) {
        this.serviceSpecialite = serviceSpecialite;
    }

    public void setServiceAdmin(AdminDao serviceAdmin) {
        this.serviceAdmin = serviceAdmin;
    }

    public List<Medecin> readBooksFromExcelFile(String excelFilePath) {
        List<Medecin> listMed=null;
        try {
            listMed = new ArrayList<>();
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
                Medecin med = new Medecin();
                Specialite s = new Specialite();
                Admin ad = new Admin();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            ad.setId_admin(((Integer) getCellValue(nextCell)));
                            med.setAdmin(serviceAdmin.findAdminById(ad.getId_admin()));
                            break;
                        case 1:
                            s.setId_specialite((((Integer) getCellValue(nextCell)).intValue()));

                            med.setSpecialite(serviceSpecialite.findSpecialiteById(s.getId_specialite()));
                            break;
                        case 2:
                            med.setAdresse((String) getCellValue(nextCell));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listMed;
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return (int) Math.round(cell.getNumericCellValue());
        }

        return null;
    }

}
