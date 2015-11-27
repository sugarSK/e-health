/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Fiche;

/**
 *
 * @author soukaina
 */
public interface FicheDao {
    Fiche findFicheByIdMedecinAndIdPatient(int id_utilisateur_medecin,int id_utilisateur_patient);
    
    
}
