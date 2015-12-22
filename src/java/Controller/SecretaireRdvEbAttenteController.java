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
import java.util.List;
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
 @RequestMapping(value = "/vues")
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
       List<Rdv> rd=serviceRdv.findAllRdvByMedecin(ra.getMedecin());
       
       if(rdv != null)
       {
         session.setAttribute("mess"," Rdv Confirmer");
       } else{session.setAttribute("mess"," Rdv non Confirmer");}
       
       return  "SecretaireRdvEnAttente";
   }
    @RequestMapping(value = "/findRdv",method=RequestMethod.POST)
    public String FindRdv(@RequestParam("date") String date,@RequestParam("heure")  String heure,
           HttpSession session)
        {
         Rdv rdvss= serviceRdv.findRdvByDateHeure(date,heure);
         //mky reccuperech men formulaire date et heure je ne sais pas pourquoi fach jerebt dert en param 11h..
         //ktkhem methode wla mchiti l secretairerdvenattente atl9ani dyra  <c:out value="${rdvss1.id_rdv}"/><c:out value="${date}"/> mora button search rdvss1.id_rdv at2afficher num d id w date la
                                                   
         Rdv rdvss1= serviceRdv.findRdvByDateHeure("20-12-2015","11h");
         session.setAttribute("rdvss", rdvss);
         session.setAttribute("rdvss1", rdvss1);
          session.setAttribute("date", date);
          if(rdvss != null)
         {   
            session.setAttribute("mess", "Rendez-vous pris!");        
         } else {
             session.setAttribute("mess", "Rendez-vous libre!");
        }
         return "SecretaireRdvEnAttente";
        }
    
   @RequestMapping(value = "/DeleteRdvAttente/{id_rdv_attente}",method=RequestMethod.GET)
   public String  DeleteRdv(@PathVariable("id_rdv_attente") int id_rdv_attente,
       HttpSession session){
       RdvEnAttente r1=serviceRdvAttente.findRdvEnAttenteById(id_rdv_attente);
   //Apres avoir confirmer un rdv(ajouter a table rdv) khassni nsuprimih mn rdv en attente
     
       serviceRdvAttente.deleteRdvEnAttente(r1);
       Secretaire se=(Secretaire)session.getAttribute("secretaire");
       
       List<RdvEnAttente> rds=serviceRdvAttente.findAllRdvEnattenteByMedecin(se.getMedecin());
       
       
       return  "SecretaireRdvEnAttente";
   }
}

