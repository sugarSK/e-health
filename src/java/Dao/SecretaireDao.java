/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Secretaire;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface SecretaireDao {
    void saveSecretaire(Secretaire secretaire);
    List<Secretaire> findAllSecretaire( );
    void updateSecretaire(Secretaire secretaire);
    void deleteSecretaire(Secretaire secretaire);
    Secretaire findSecretaireById(int id_utilisateur);
    
}
