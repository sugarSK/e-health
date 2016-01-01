/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MedecinDao;
import Dao.SecretaireDao;
import Dao.SpecialiteDao;
import ExcelReadFile.ExcelReadMedecin;
import ExcelReadFile.ExcelReadSecretaire;
import ExcelReadFile.ExcellReadSpecialite;
import Metier.Medecin;
import Metier.Secretaire;
import Metier.Specialite;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author soukaina
 */
@Controller
public class ReadExcelFileController {

    @Autowired 
    private SpecialiteDao serviceSpecialite;
    @Autowired 
    private SecretaireDao serviceSec;
    @Autowired 
    private MedecinDao serviceMed;
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
             
     String doUploadSpecialite(@RequestParam("excelFilePath") MultipartFile excelFilePath,
        HttpSession session) throws IOException{
         
        if(!excelFilePath.isEmpty()) 
        {
            byte[] bytes = excelFilePath.getBytes();
            String chaine="/users/said/NetBeansProjects/e-health/web/vues/fichier.xlsx";
            try(BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(chaine)))
            {
                stream.write(bytes);
            }
        
        }
         
	ExcellReadSpecialite reader = new ExcellReadSpecialite();
	List<Specialite> listSpecialite = reader.readBooksFromExcelFile("/users/said/NetBeansProjects/e-health/web/vues/fichier.xlsx");
        for( Specialite s : listSpecialite){
        try {
           serviceSpecialite.saveSpecialite(s);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Deja ajouté");
        }}
        
        List<Specialite> listSpecialites = serviceSpecialite.fndAllSpecialite();
        session.setAttribute("listSpecialites", listSpecialites);
        return "accueilAdmin";
        

       
     }

    
    @RequestMapping(value = "/doUploadSecretaire", method = RequestMethod.POST)
             
     String doUploadSecretaire(@RequestParam("excelFilePath") MultipartFile excelFilePath,
        HttpSession session) throws IOException{
         
        if(!excelFilePath.isEmpty()) 
        {
            byte[] bytes = excelFilePath.getBytes();
            String chaine="/users/said/NetBeansProjects/e-health/web/vues/fichierSecretaire.xlsx";
            try(BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(chaine)))
            {
                stream.write(bytes);
            }
        
        }
	ExcelReadSecretaire reader = new ExcelReadSecretaire();
	List<Secretaire>listS = reader.readBooksFromExcelFile("/users/said/NetBeansProjects/e-health/web/vues/fichierSecretaire.xlsx");
        for( Secretaire s : listS){
        try {
           serviceSec.saveSecretaire(s);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Deja ajouté");
        }}
        
        List<Secretaire> listSecretaires = serviceSec.findAllSecretaire();
        session.setAttribute("listSecretaires", listSecretaires);
        return "accueilAdmin";
        

       
     }    
 
    @RequestMapping(value = "/doUploadMedecin", method = RequestMethod.POST)
     String doUploadMedecin(@RequestParam("excelFilePath") MultipartFile excelFilePath,
        HttpSession session) throws IOException{
         
        if(!excelFilePath.isEmpty()) 
        {
            byte[] bytes = excelFilePath.getBytes();
            String chaine="/users/said/NetBeansProjects/e-health/web/vues/fichierMedecin.xlsx";
            try(BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(chaine)))
            {
                stream.write(bytes);
            }
        
        }
	ExcelReadMedecin reader = new ExcelReadMedecin();
	List<Medecin> listmed = reader.readBooksFromExcelFile("/users/said/NetBeansProjects/e-health/web/vues/fichierMedecin.xlsx");
        for( Medecin med : listmed){
        try {
           serviceMed.saveMedecin(med);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Deja ajouté");
        }}
        
        List<Medecin> listMedecins = serviceMed.findAllMedecin();	
        session.setAttribute("listMedecins", listMedecins);
        return "accueilAdmin";
        

       
     }
    
}
