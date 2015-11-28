/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Medecin;

/**
 *
 * @author soukaina
 */
public interface MedecinDao {
        
        Medecin findMedecinById(int id_utilisateur);
        void saveMedecin(Medecin medecin);
     
        void updateMedecin(Medecin medecin);
     
       void deleteMedecin(Medecin Medecin);

    
}
