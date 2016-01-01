/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminDao;
import Dao.MedecinDao;
import Dao.SecretaireDao;
import Dao.SpecialiteDao;
import Dao.UtilisateurDao;
import Metier.Admin;
import Metier.Medecin;
import Metier.Secretaire;
import Metier.Specialite;
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
public class AuthetificationAdminController {
@Autowired
private AdminDao serviceAdmin;
@Autowired
private MedecinDao serviceMedecin;
@Autowired
private SpecialiteDao serviceSpecialite;
@Autowired
private SecretaireDao serviceSecretaire;

@RequestMapping(value = "/Admin")
public String showIndexAdmin()
{
    return "indexAdmin";
}
@RequestMapping(value = "/doLoginAdmin")
public String dologinAdmin(@RequestParam ("login") String login,
        @RequestParam("password") String password,
        HttpSession session)
{
    Admin admin=serviceAdmin.findAdminByCompte(login, password);
    if(admin != null)
    {
          session.setAttribute("admin", admin);
          List<Medecin> listMedecins = serviceMedecin.findAllMedecin();
          List<Specialite> listSpecialites = serviceSpecialite.fndAllSpecialite();
          List<Secretaire> listSecretaires = serviceSecretaire.findAllSecretaire();
          session.setAttribute("listMedecins", listMedecins);
          session.setAttribute("listSpecialites", listSpecialites);
          session.setAttribute("listSecretaires", listSecretaires);
          
          return "accueilAdmin";
    }else if(login.isEmpty()|| password.isEmpty()) 
    {
        session.setAttribute("messageAdmin","resaisie Pasword or mot de passe ");
        return "indexAdmin";
    } else
    {
        return "indexAdmin";
    }
   
}
@RequestMapping(value = "/modifierSecretaire/{id_utilisateur}",method = RequestMethod.GET)
public String modifierSecretaire(@PathVariable("id_utilisateur") int id_utilisateur,
           HttpSession session)
{ 
    Secretaire sec=serviceSecretaire.findSecretaireById(id_utilisateur);
    session.setAttribute("sec", sec);
    return "AdminModifierSecretaire";
}
@RequestMapping(value = "/modifierSecretaire/modifierSec",method = RequestMethod.POST)
public String modifierS(@RequestParam("id_utilisateur") int id_utilisateur,@RequestParam("nom") String nom,
    @RequestParam("prenom") String prenom,@RequestParam("date_naissance") String date_naissance,
    @RequestParam("adresse") String adresse,@RequestParam("numero_telephone") String numero_telephone,
    @RequestParam("id_utilisateur_medecin") int id_utilisateur_medecin,
    @RequestParam("login") String login,@RequestParam("password") String password,HttpSession session)
{
    Secretaire secre=serviceSecretaire.findSecretaireById(id_utilisateur);
   // Medecin med=serviceMedecin.findMedecinById(id_utilisateur_medecin);
    secre.setAdresse(adresse);
    secre.setDate_naissance(date_naissance);
    secre.setLogin(login);
    secre.setNom(nom);
    secre.setNumero_telephone(numero_telephone);
    secre.setPassword(password);
    secre.setPrenom(prenom);
   // secre.setMedecin(med);
    serviceSecretaire.updateSecretaire(secre);
    List<Secretaire> listSecretaires=serviceSecretaire.findAllSecretaire();
    session.setAttribute("listSecretaires", listSecretaires);
    return "accueilAdmin";
}
@RequestMapping(value = "/modifierMedecin/{id_utilisateur}",method = RequestMethod.GET)
public String modifierMedecin(@PathVariable("id_utilisateur") int id_utilisateur,
           HttpSession session)
{ 
    Medecin mede=serviceMedecin.findMedecinById(id_utilisateur);
    session.setAttribute("mede", mede);
    return "AdminModifierMedecin";
}
@RequestMapping(value = "/modifierMedecin/modifierMed",method = RequestMethod.POST)
public String modifierMed(@RequestParam("id_utilisateur") int id_utilisateur,@RequestParam("nom") String nom,
    @RequestParam("prenom") String prenom,@RequestParam("date_naissance") String date_naissance,
    @RequestParam("adresse") String adresse,@RequestParam("numero_telephone") String numero_telephone,
    @RequestParam("login") String login,@RequestParam("password") String password,HttpSession session)
{
  
    Medecin medc=serviceMedecin.findMedecinById(id_utilisateur);
    medc.setAdresse(adresse);
    medc.setDate_naissance(date_naissance);
    medc.setLogin(login);
    medc.setNom(nom);
    medc.setNumero_telephone(numero_telephone);
    medc.setPassword(password);
    medc.setPrenom(prenom);
    serviceMedecin.updateMedecin(medc);
    List<Medecin> listMedecins=serviceMedecin.findAllMedecin();
    session.setAttribute("listMedecins", listMedecins);
    return "accueilAdmin";
}
}