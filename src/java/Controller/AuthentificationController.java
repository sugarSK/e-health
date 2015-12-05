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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Dao.UtilisateurDao;
import Metier.Fiche;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import Metier.Utilisateur;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
/**
 *
 * @author PC
 */
@Controller
public class AuthentificationController {
    
    @Autowired
    private MedecinDao serviceMedecin;
    @Autowired
    private UtilisateurDao serviceUtilisateur;
    @Autowired
    private FicheDao serviceFiche;
    @Autowired
    private PatientDao servicePatient;
    @Autowired
     private RdvDaoImpl serviceRdv;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public String showLogin()
    {
        return "index";
    }
    
    @RequestMapping(value="/doLogin",method=RequestMethod.POST)
    public String doLogin
        (@RequestParam("login") String login,
            @RequestParam("password") String password,
            HttpSession session)
    {
        Medecin medecin = serviceMedecin.findMedecinById(serviceUtilisateur.findByCompte(login, password).getId_utilisateur());
        if(medecin != null)
        {
            session.setAttribute("medecin", medecin);
            session.setAttribute("listFiches", medecin.getFiches());
            Patient patient = servicePatient.findPatientById(1);
            Fiche fiche_patient = serviceFiche.findFicheByIdMedecinAndIdPatient(medecin, patient);
//            for (Iterator<Fiche> iterator = list_fiches.iterator(); iterator.hasNext();) {
//                Fiche next = iterator.next();
//                if(next.getPatient().getNom().equals("Ouassmine"))
//                {
//                    session.setAttribute("Fiche_amine",next);
//                }
//            }
            List<Rdv> listRdvs = serviceRdv.findAllRdvByIdMedecin(serviceUtilisateur.findByCompte(login, password).getId_utilisateur());
            session.setAttribute("listRdvs", listRdvs);
            session.setAttribute("fiche_patient", fiche_patient);
            return "accueil";
        }else{
            return "index";
        }
    }
    
}
