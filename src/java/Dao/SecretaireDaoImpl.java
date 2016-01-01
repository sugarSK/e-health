/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Admin;
import Metier.Medecin;
import Metier.Rdv;
import Metier.Seance;
import Metier.Secretaire;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soukaina
 */
@Repository("secretaireDao")
public class SecretaireDaoImpl extends AbstractDao<Integer, Secretaire> implements SecretaireDao{

    @Override
    public Secretaire findSecretaireById(int id_utilisateur) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Secretaire.class);
        criteria.add(Restrictions.eq("id_utilisateur",id_utilisateur));
        Secretaire secretaire = (Secretaire) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return secretaire;
    }

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

  
     @Override
    public List<Secretaire> findAllSecretaire( ) {
           Criteria criteria = getSession().createCriteria(Secretaire.class);
        return (List<Secretaire>) criteria.list();
    }
}
