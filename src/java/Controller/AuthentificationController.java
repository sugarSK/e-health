/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.FicheDao;
import Dao.MedecinDao;
import Dao.PatientDao;
import Dao.RdvDao;
import Dao.RdvDaoImpl;
import Dao.RdvEnAttenteDao;
import Dao.SecretaireDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Dao.UtilisateurDao;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
import Metier.RdvEnAttente;
import Metier.Secretaire;
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
    private SecretaireDao serviceSecretaire;
    @Autowired
    private RdvDao serviceRdv;
    @Autowired
    private RdvEnAttenteDao serviceRdvEnAttente;  
  
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
        Secretaire secretaire=serviceSecretaire.findSecretaireById(serviceUtilisateur.findByCompte(login, password).getId_utilisateur());
        if(medecin != null)
        {
            session.setAttribute("medecin", medecin);
            session.setAttribute("listef", medecin.getFiches());

            List<Rdv> listRdvs = serviceRdv.findAllRdvByIdMedecin(serviceUtilisateur.findByCompte(login, password).getId_utilisateur());
            session.setAttribute("listRdvs", listRdvs);
            //List<Fiche> listFiches =serviceFiche.fndAllFichesByMedecin(medecin);
            //session.setAttribute("listFiches", listFiches);
            return "accueilMedecin";
        } else if (secretaire !=null)
                {     
                      session.setAttribute("secretaire", secretaire);
                      Medecin med=secretaire.getMedecin();
                      session.setAttribute("listFiches", med.getFiches());
                      int id=med.getId_utilisateur();
                      List<Rdv> rd=serviceRdv.findAllRdvByIdMedecin(id);
                      List<RdvEnAttente> rdAttente=serviceRdvEnAttente.findAllRdvEnattenteByIdMedecin(id);
                      session.setAttribute("rd", rd);
                      session.setAttribute("rdAttente", rdAttente);
                     
                             return "accueilSecretaire";
                }
        else{
                        return "index";
                       }
        
            
  
            
            
           
        
    }
    
}
