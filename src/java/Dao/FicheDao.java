/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Fiche;
import Metier.Medecin;
import Metier.Patient;

/**
 *
 * @author soukaina
 */
public interface FicheDao {
    Fiche findFicheByIdMedecinAndIdPatient(Medecin medecin,Patient patient);
       void saveFiche(Fiche fiche);
     
    void updateFiche(Fiche fiche);
     
    void deleteFiche(Fiche fiche);
  
}
