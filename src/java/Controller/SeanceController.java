/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.FicheDao;
import Dao.SeanceDao;
import Metier.Fiche;
import Metier.Medecin;
import Metier.Patient;
import Metier.Seance;
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

public class SeanceController {
    @Autowired
    private SeanceDao serviceSeance;
    @Autowired
    private FicheDao serviceFiche;
   
     @RequestMapping(value="/seance/{id_fiche}",method=RequestMethod.GET)
        public String seance(@PathVariable("id_fiche") int id_fiche,HttpSession session)
    {
       List<Seance> listSeance=serviceSeance.fndAllCompteRenduSeanceByIdFiche(serviceFiche.findFicheById(id_fiche));
        
        if(listSeance!= null)
        {
            session.setAttribute("seances", listSeance);
            
            return "listSeance";
        }else{
            return "fichePatient";
        }
    }
         @RequestMapping(value="/saveSeance",method=RequestMethod.POST)
        public String saveSeance(@RequestParam("date") String date,
            @RequestParam("compte_rendu") String compte_rendu,@RequestParam("medicament") String medicament,
           HttpSession session)
    { 
          
        Fiche fich=(Fiche)session.getAttribute("fiche");
        Patient patient=fich.getPatient();
        session.setAttribute("patient", patient);
        int id_fiche=fich.getId_fiche();
        Fiche fiche=serviceFiche.findFicheById(id_fiche);
        Seance seance=new Seance();
        seance.setCompte_rendu(compte_rendu);
        seance.setDate(date);
        seance.setMedicament(medicament);
        seance.setFiche(fiche);
        serviceSeance.SaveCompteRenduSeance(seance);
        List<Seance> listSeance=serviceSeance.fndAllCompteRenduSeanceByIdFiche(fiche);
        
            session.setAttribute("seances", listSeance);
            
            
            return "listSeance";
      
    }
        @RequestMapping(value = "/show")
         public String ShowFormulaire()
         {
             return "SaveSeance";
         }
   
        
}
