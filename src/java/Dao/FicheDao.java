/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Fiche;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface FicheDao {
    Fiche findFicheByIdMedecinAndIdPatient(Metier.Medecin medecinIN,Metier.Patient patientIN);
    void saveFiche(Fiche fiche);
     
    void updateFiche(Fiche fiche);
     
    void deleteFiche(Fiche fiche);
  
}
