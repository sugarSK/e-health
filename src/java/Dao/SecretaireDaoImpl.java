/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Rdv;
import Metier.Seance;
import Metier.Secretaire;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author soukaina
 */
public class SecretaireDaoImpl extends AbstractDao<Integer, Secretaire> implements SecretaireDao{

    @Override
    public void saveSecretaire(Secretaire secretaire) {
        Session s = getSession();
        s.beginTransaction();
        s.save(secretaire);
        s.getTransaction().commit();
        s.close();

    }

    @Override
    public void updateSecretaire(Secretaire secretaire) {
         Session s = getSession();
        s.beginTransaction();
        s.update(secretaire);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void deleteSecretaire(Secretaire secretaire) {
        Session s = getSession();
        s.beginTransaction();
        s.delete(secretaire);
        s.getTransaction().commit();
        s.close();
    }

   

  
    
}
