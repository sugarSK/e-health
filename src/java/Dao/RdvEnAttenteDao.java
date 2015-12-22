/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Rdv;
import Metier.RdvEnAttente;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface RdvEnAttenteDao {
    
      List<RdvEnAttente> findAllRdvEnattenteByIdMedecin(int id_utilisateur);
      RdvEnAttente findRdvEnAttenteById(int id_rdv_attente);
      RdvEnAttente findRdvEnAttenteByDateHeure(String date,String heure);

    
}