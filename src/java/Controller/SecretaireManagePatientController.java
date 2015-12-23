/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.FicheDao;
import Dao.PatientDao;
import Dao.RdvDao;
import Metier.Fiche;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
import Metier.Secretaire;
import Metier.Utilisateur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author soukaina
 */
@Controller
 
public class SecretaireManagePatientController {
    
    @Autowired
    PatientDao servicePatient;
    @Autowired
    FicheDao serviceFiche;  
    @Autowired
    RdvDao serviceRdv;  

    @RequestMapping(value = "/find",method=RequestMethod.POST)
    public String doFind(@RequestParam("id_utilisateur") int id_utilisateur,HttpSession session)
    {   
        Fiche pat= serviceFiche.findFicheById(id_utilisateur);
        if(pat != null){   
            session.setAttribute("message", "Patient existant!");        
        }else{
            session.setAttribute("message", "1ere rendez vous!");
        }
        return "accueilSecretaire";
    }
    
   @RequestMapping(value = "/addPatient/{id_rdv}",method=RequestMethod.GET)
   public String  addPatient(@PathVariable("id_rdv") int id_rdv,
           HttpSession session){
       Rdv r=serviceRdv.findRdvById(id_rdv);
       Patient p= r.getPatient();
       Secretaire s =(Secretaire)session.getAttribute("secretaire");
       Medecin m= s.getMedecin();
       Fiche fic=new Fiche();
       fic.setPatient(p);
       fic.setMedecin(m);
       try{
           serviceFiche.saveFiche(fic);
       }catch(Exception e){
           e.printStackTrace();
           session.setAttribute("msg", "Fiche Existante !");
           return  "accueilSecretaire";
       }
           List<Fiche> f=m.getFiches();
           session.getAttribute("listFiches");
           return  "secretaireAllFichesPatient";
       
   }

    
}
