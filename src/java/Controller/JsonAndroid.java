/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminDao;
import Dao.FicheDao;
import Dao.MedecinDao;
import Dao.PatientDao;
import Dao.RdvDao;
import Dao.RdvEnAttenteDao;
import Dao.SeanceDao;
import Dao.SecretaireDao;
import Dao.SpecialiteDao;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
import Metier.RdvEnAttente;
import Metier.Seance;
import Metier.Specialite;
import Metier.Utilisateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author soukaina
 */
@Controller
public class JsonAndroid {
    @Autowired
    private AdminDao service ;
    @Autowired
    private PatientDao servicePatient;
    @Autowired 
    private MedecinDao serviceMedecin;
    @Autowired
    private SpecialiteDao serviceSpecialite;
    @Autowired 
    private SeanceDao serviceSEance;
    @Autowired
    private RdvDao serviceRdv;
    @Autowired
    private RdvEnAttenteDao serviceRdvEnattente;

    
    @RequestMapping(value="json/AllPatients",method = RequestMethod.GET)
    @ResponseBody
    public List<Patient> getAllPatients()
    {
        List<Patient> listPatient = servicePatient.findAllPatient();
        if(listPatient!=null)
        {
            for (Patient next : listPatient) {
                next.getDate_naissance();
                next.getAdresse();
                next.getId_utilisateur();
                next.getLogin();
                next.getMaladie();
                next.getNom();
                next.getNumero_telephone();
                next.getPassword();
                next.getPrenom();
               
            }
        }
        return listPatient;
    }
    @RequestMapping(value="json/AllMedecins",method = RequestMethod.GET)
    @ResponseBody
    public List<Medecin> getAllMedecins()
    {
        List<Medecin> listMedecins = serviceMedecin.findAllMedecin();
        if(listMedecins!=null)
        {
            for (Medecin next : listMedecins) {
                next.getDate_naissance();
                next.getAdresse();
                next.getId_utilisateur();
                next.getLogin();           
                next.getNom();
                next.getNumero_telephone();
                next.getPassword();
                next.getPrenom();
                next.getAdmin().getId_admin();
                next.getSpecialite().getId_specialite();
                next.getSpecialite().getIntitule();
              
            }
        }
        return listMedecins;
    }
    @RequestMapping(value="json/AllSpecialites",method = RequestMethod.GET)
    @ResponseBody
    public List<Specialite> getAllSpecialites()
    {
        List<Specialite> listSpecialites = serviceSpecialite.fndAllSpecialite();
        if(listSpecialites!=null)
        {
            for (Specialite next : listSpecialites) {
                next.getId_specialite();
                next.getIntitule();
    
            }
        }
        return listSpecialites;
    }
    @RequestMapping(value="json/AllRdvs",method = RequestMethod.GET)
    @ResponseBody
    public List<Rdv> getAllRdvs()
    {
        List<Rdv> listRdvs = serviceRdv.findAllRdv();
 
        if( listRdvs!=null)
        {
            for (Rdv next : listRdvs) {
                next.getCause();
                next.getDate();
                next.getHeure();
                next.getId_rdv();
                next.getMedecin().getId_utilisateur();
                next.getPatient().getId_utilisateur();
            }
        }    
        return listRdvs;
    }
    @RequestMapping(value="json/AllSeances",method = RequestMethod.GET)
    @ResponseBody
    public List<Seance> getAllSeances()
    {
        List<Seance> listSeances = serviceSEance.fndAllCompteRenduSeance();
 
        if( listSeances!=null)
        {
            for (Seance next : listSeances) {
                next.getCompte_rendu();
                next.getDate();
                next.getFiche().getId_fiche();
                next.getId_seance();
                next.getMedicament();
            }
        }    
        return listSeances;
    }   
    @RequestMapping(value="/json/AddPatient",method = RequestMethod.POST)
    @ResponseBody
    public Utilisateur AddPatient(@RequestParam("nom") String nom,
        @RequestParam("prenom") String prenom,@RequestParam("adresse") String adresse,
        @RequestParam("date_naissance") String date_naissance,@RequestParam("login") String login,
        @RequestParam("password") String password,@RequestParam("numero_telephone") String numero_telephone,
        @RequestParam("maladie") String maladie){
        
        Patient patient = new Patient();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setAdresse(adresse);
        patient.setDate_naissance(date_naissance);
        patient.setLogin(login);
        patient.setPassword(password);
        patient.setNumero_telephone(numero_telephone);
        patient.setMaladie(maladie);
        servicePatient.savePatient(patient);
        System.out.println("ca passe :"+patient);
        return patient;
    }
    @RequestMapping(value="/json/AddRdvAconfiemr",method = RequestMethod.POST)
    @ResponseBody
    public RdvEnAttente AddRdvAconfirmer(@RequestParam("cause") String cause,
        @RequestParam("date") String date,@RequestParam("heure") String heure,
        @RequestParam("id_medecin") int id_utilisateur_medecin,@RequestParam("id_patient") int id_utilisateur_patient){
        Medecin medecin=serviceMedecin.findMedecinById(id_utilisateur_medecin);
        Patient p=servicePatient.findPatientById(id_utilisateur_patient);
        RdvEnAttente rdv= new RdvEnAttente();
        rdv.setCause(cause);
        rdv.setDate(date);
        rdv.setMedecin(medecin);
        rdv.setPatient(p);
        serviceRdvEnattente .SaveRdvEnattente(rdv);
        System.out.println("ca passe :"+rdv);
        return rdv;
    }
    
}
