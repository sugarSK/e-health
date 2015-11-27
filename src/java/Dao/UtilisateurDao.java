/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Utilisateur;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface UtilisateurDao {
 
    void saveUtilisateur(Utilisateur utilisateur);
     
    void updateUtilisateur(Utilisateur utilisateur);
     
    void deleteUtilisateur(Utilisateur utilisateur);
     
    Utilisateur findByCompte(String login,String passsword);
    
    Utilisateur findById(String id_utilisateur);
    
}
