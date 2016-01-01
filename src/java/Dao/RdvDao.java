/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Medecin;
import Metier.Rdv;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface RdvDao  {
        void SaveRdv(Rdv rdv);
        List<Rdv> findAllRdvByMedecin(Medecin medecin);
        List<Rdv> findAllRdv();
        Rdv findRdvById(int id_rdv);
        Rdv findRdvByDateHeure(String date, String heure) ;
    
}
