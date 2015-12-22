   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.FicheDao;
import Dao.MedecinDao;
import Dao.PatientDao;
import Dao.RdvDaoImpl;
import Dao.UtilisateurDao;
import Metier.Fiche;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
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
public class rdvMedecinController {
    
 @Autowired
 private RdvDaoImpl serviceRdvDao;
     @Autowired
    private MedecinDao serviceMedecin;

    @Autowired
    private FicheDao serviceFiche;
    @Autowired
    private PatientDao servicePatient;
    @RequestMapping(value="/fiche/{id_rdv}",method=RequestMethod.GET)
    public String fiche(@PathVariable("id_rdv") int rdv,HttpSession session)
    {
        Rdv rdvs= serviceRdvDao.findRdvById(rdv);
        Patient patient=rdvs.getPatient();
        Medecin medecin=rdvs.getMedecin();
        Fiche fiche=serviceFiche.findFicheByIdMedecinAndIdPatient(medecin, patient);
        if(fiche!= null)
        {
            session.setAttribute("fiche", fiche);
            
            return "fichePatient";
        }else{
            return "accueilMedecin";
        }
    }
   
    
}
