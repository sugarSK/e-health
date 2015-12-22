/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.RdvDao;
import Dao.RdvEnAttenteDao;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
import Metier.RdvEnAttente;
import Metier.Secretaire;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author soukaina
 */
@Controller
public class SecretaireRdvEbAttenteController {
    @Autowired
    private RdvEnAttenteDao serviceRdvAttente;
    @Autowired
    private RdvDao serviceRdv;
    @RequestMapping(value = "/ConfirmerRdvAttente/{id_rdv_attente}",method=RequestMethod.GET)
   public String  ConfirmeRdv(@PathVariable("id_rdv_attente") int id_rdv_attente,
       HttpSession session){
       RdvEnAttente ra=serviceRdvAttente.findRdvEnAttenteById(id_rdv_attente);
       Rdv rdv=new Rdv();
       rdv.setCause(ra.getCause());
       rdv.setDate(ra.getDate());
       rdv.setHeure(ra.getHeure());
       rdv.setMedecin(ra.getMedecin());
       rdv.setPatient(ra.getPatient());
       serviceRdv.SaveRdv(rdv);
       if(rdv != null)
       {
         session.setAttribute("mess"," Rdv Confirmer");
       } else{session.setAttribute("mess"," Rdv non Confirmer");}
       
       return  "SecretaireRdvEnAttente";
   }
    @RequestMapping(value = "/findRdv",method=RequestMethod.POST)
    public String doFind(@RequestParam("date") String date,@RequestParam("heure")  String heure,
           HttpSession session)
        {
         Rdv rd= serviceRdv.findRdvByDateHeure(date, heure);
          if(rd != null)
         {   
            session.setAttribute("mess", "Rendez-vous pris!");        
         } else {
             session.setAttribute("mess", "Rendez-vous libre!");
        }
         return "SecretaireRdvEnAttente";
        }
}

