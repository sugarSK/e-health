/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Patient;

/**
 *
 * @author soukaina
 */
public interface PatientDao {
    
        Patient findPatientById(int id_utilisateur);

        void savePatient(Patient patient);
     
        void updatePatient(Patient patient);
     
       void deletePatient(Patient patient);
     
    
    

    
}
