/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Medecin;
import Metier.Rdv;
import Metier.RdvEnAttente;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface RdvEnAttenteDao {
    
      List<RdvEnAttente> findAllRdvEnattenteByMedecin(Medecin medecin);
      RdvEnAttente findRdvEnAttenteById(int id_rdv_attente);
      RdvEnAttente findRdvEnAttenteByDateHeure(String date,String heure);
      void deleteRdvEnAttente(RdvEnAttente rdv);
    
}