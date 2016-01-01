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
import Dao.SeanceDao;
import Dao.SecretaireDao;
import Dao.SpecialiteDao;
import Dao.SpecialiteDaoImpl;
import ExcelReadFile.ExcellReadSpecialite;
import Metier.Admin;
import Metier.Fiche;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
import Metier.Seance;
import Metier.Secretaire;
import Metier.Specialite;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Soukaina
 */
@Controller
public class testController {
    
    @Autowired
    private AdminDao service ;
    @Autowired
    private PatientDao servicePatient;
    @Autowired 
    private MedecinDao serviceMedecin;
    @Autowired
    private SpecialiteDao serviceSpecialite;
    @Autowired
    private SecretaireDao serviceSecretaire;
    @Autowired
    private RdvDao serviceRdv;
    @Autowired
    private FicheDao serviceFiche;
    @Autowired
    private SeanceDao serviceSEance;
    @Autowired
    private AdminDao serviceAdmine;
    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public String test() throws IOException
    {
      /*  Admin admin_1 = new Admin();
        admin_1.setLogin("ROOT");
        admin_1.setPassword("ROOT");
        
        Admin admin_2 = new Admin();
        admin_2.setLogin("admin");
        admin_2.setPassword("kjhkjhkjhkh");
        
        service.saveAdmin(admin_1);
        service.saveAdmin(admin_2);
        
       admin_2.setPassword("admin");
        service.updateAdmin(admin_2);
        
        service.deleteAdmin(admin_1);
        Patient patient = new Patient();
        patient.setNom("Ouassmine");
        patient.setPrenom("Med amine");
        patient.setAdresse("berrchid");
        patient.setDate_naissance("03-12-1992");
        patient.setLogin("amine");
        patient.setPassword("amine");
        patient.setNumero_telephone("098765456");
        patient.setMaladie("fievre");
        servicePatient.savePatient(patient);
        patient.setMaladie("jalousie");
        servicePatient.updatePatient(patient);
        
        Patient patient2 = new Patient();
        patient2.setNom("soukaina");
        patient2.setPrenom("soukaina");
        patient2.setAdresse("bm");
        patient2.setDate_naissance("03-12-1992");
        patient2.setLogin("souka");
        patient2.setPassword("souka");
        patient2.setNumero_telephone("098765456");
        patient2.setMaladie("fievre");
        servicePatient.savePatient(patient2);
        servicePatient.deletePatient(patient2);
        Patient patient3=servicePatient.findPatientById(1);
         Admin adm = service.findAdminById(4);
         

        Specialite specialite = new Specialite();
        specialite.setAdmin(adm);
        specialite.setIntitule("pediatre");
        serviceSpecialite.saveSpecialite(specialite);
        
        Medecin medecin = new Medecin();
        medecin.setAdmin(adm);
        medecin.setSpecialite(specialite);
        medecin.setAdresse("casa");
        medecin.setDate_naissance("09-04-1980");
        medecin.setLogin("medecin");
        medecin.setPassword("medecin");
        medecin.setNom("mazzir");
        medecin.setPrenom("soukaina");
        medecin.setNumero_telephone("34567679");
        serviceMedecin.saveMedecin(medecin);

        
        
        
        
        Secretaire secretaire = new Secretaire();
        secretaire.setNom("fatine");
        secretaire.setPrenom("lyla");
        secretaire.setAdresse("casa");
        secretaire.setDate_naissance("03-06-1990");
        secretaire.setNumero_telephone("3456789");
        secretaire.setLogin("secretaire");
        secretaire.setPassword("secretaire");
        secretaire.setAdmin(adm);
        secretaire.setMedecin(medecin);
        serviceSecretaire.saveSecretaire(secretaire);
        List<Rdv> rdvs=serviceRdv.findAllRdvByIdMedecin(2);
                 for(Rdv r : rdvs){
                     System.out.println(r.getCause());
                 }
    Medecin medecin = serviceMedecin.findMedecinById(2);
      Patient patient=servicePatient.findPatientById(1);
    
        Fiche fiche=new Fiche();
        fiche.setMedecin(medecin);
        fiche.setPatient(patient);
        serviceFiche.saveFiche(fiche);
        
        Seance seance = new Seance();
        seance.setCompte_rendu("compte");
        seance.setDate("03-09-1993");
        seance.setFiche(fiche);
        seance.setMedecin(medecin);
        seance.setMedicament("omnivite");
        serviceSEance.SaveCompteRenduSeance(seance);
        
        seance.setCompte_rendu("bla bla");
        serviceSEance.UpdateCompteRenduSeance(seance);
        
        Fiche fiche1=new Fiche();
        fiche1.setMedecin(medecin);
        fiche1.setPatient(patient);
        serviceFiche.deleteFiche(fiche1);
//        
//        Patient patient2 = new Patient();
//        patient2.setNom("mazzi");
//        patient2.setPrenom("meryem");
//        patient2.setAdresse("khribga");
//        patient2.setDate_naissance("03-12-1992");
//        patient2.setLogin("mimi");
//        patient2.setPassword("mimi");
//        patient2.setNumero_telephone("098765456");
//        patient2.setMaladie("deperssion");
//        servicePatient.savePatient(patient2);

        Medecin medecin = serviceMedecin.findMedecinById(2);
        Patient p = servicePatient.findPatientById(1);
        Fiche fiche2 = serviceFiche.findFicheByIdMedecinAndIdPatient(medecin,p);
        Seance seance = new Seance();
        seance.setCompte_rendu("compte");
        seance.setDate("03-09-1993");
        seance.setFiche(fiche2);
        seance.setMedicament("doliprane");
        serviceSEance.SaveCompteRenduSeance(seance);
          
        List<Seance> scs=serviceSEance.fndAllCompteRenduSeanceByIdFiche(fiche2.getId_fiche());
            for(Seance r : scs){
                System.out.println(r.getMedicament());
            }
            
        
        */
         Secretaire m=serviceSecretaire.findSecretaireById(3);
           m.setPrenom("Fatine");
           serviceSecretaire.updateSecretaire(m);
        return m.toString();
            
    }
}
