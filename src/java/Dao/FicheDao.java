/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Fiche;
import Metier.Medecin;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface FicheDao {
    Fiche findFicheById(int id_fiche) ;
    Fiche findFicheByIdMedecinAndIdPatient(Metier.Medecin medecinIN,Metier.Patient patientIN);
    List<Fiche>  fndAllFichesByMedecin(Medecin medecinIN);
    void saveFiche(Fiche fiche);
     
    void updateFiche(Fiche fiche);
     
    void deleteFiche(Fiche fiche);
  
}
