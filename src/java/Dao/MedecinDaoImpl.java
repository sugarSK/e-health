/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Medecin;
import Metier.Rdv;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soukaina
 */
@Repository("medecinDao")
public class MedecinDaoImpl extends AbstractDao<Integer, Medecin> implements MedecinDao{

    @Override
    public Medecin findMedecinById(int id_utilisateur) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Medecin.class);
        criteria.add(Restrictions.eq("id_utilisateur",id_utilisateur));
        Medecin medecin = (Medecin) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return medecin;
    }

    @Override
    public void saveMedecin(Medecin medecin) {
        Session s = getSession();
        s.beginTransaction();
        s.save(medecin);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateMedecin(Medecin medecin) {
        Session s = getSession();
        s.beginTransaction();
        s.update(medecin);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void deleteMedecin(Medecin Medecin) {
        Session s = getSession();
        s.beginTransaction();
        s.delete(Medecin);
        s.getTransaction().commit();
        s.close();
    }
    @Override
    public List<Medecin> findAllMedecin( ) {
           Criteria criteria = getSession().createCriteria(Medecin.class);
        return (List<Medecin>) criteria.list();
    }
       
}
