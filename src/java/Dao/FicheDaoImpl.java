/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Admin;
import Metier.Fiche;
import Metier.Medecin;
import Metier.Patient;
import Metier.Rdv;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soukaina
 */
@Repository("ficheDao")
public class FicheDaoImpl extends AbstractDao<Integer, Fiche> implements FicheDao {

    @Override
    public Fiche findFicheByIdMedecinAndIdPatient(Medecin medecin,Patient patient) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Fiche.class);
        criteria.add(Restrictions.eq("medecin",medecin));
        criteria.add(Restrictions.eq("patient",patient));
        Fiche fiche = (Fiche) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return fiche;
    }

    
    
    
    @Override
    public void saveFiche(Fiche fiche) {
             Session s = getSession();
        s.beginTransaction();
        s.save(fiche);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateFiche(Fiche fiche) {
             Session s = getSession();
        s.beginTransaction();
        s.update(fiche);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void deleteFiche(Fiche fiche) {
             Session s = getSession();
        s.beginTransaction();
        s.delete(fiche);
        s.getTransaction().commit();
        s.close();
    }

     
    
}
