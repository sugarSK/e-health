/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Fiche;
import Metier.Medecin;
import java.util.List;
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
    public Fiche findFicheById(int id_fiche) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Fiche.class);
        criteria.add(Restrictions.eq("id_fiche",id_fiche));
        Fiche fiche = (Fiche) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return fiche;
    }
    @Override
    public Fiche findFicheByIdMedecinAndIdPatient(Metier.Medecin medecinIN, Metier.Patient patientIN) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Fiche.class);
        criteria.add(Restrictions.eq("medecin",medecinIN));
        criteria.add(Restrictions.eq("patient",patientIN));
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

    @Override
         public List<Fiche> fndAllFichesByMedecin(Medecin medecinIN) {
         Criteria criteria = getSession().createCriteria(Fiche.class);
         criteria.add(Restrictions.eq("medecin",medecinIN));
         return (List<Fiche>) criteria.list();
    }
    

}
