/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Rdv;
import Metier.Utilisateur;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soukaina
 */
@Repository("rdvDao")
public class RdvDaoImpl extends AbstractDao<Integer, Rdv> implements RdvDao{

    @Override
    public List<Rdv> findAllRdvByIdMedecin(int id_utilisateur) {
           Criteria criteria = getSession().createCriteria(Rdv.class);
           //criteria.add(Restrictions.eq("id_utilisateur",id_utilisateur));
        return (List<Rdv>) criteria.list();
    }
       
    @Override
    public Rdv findRdvById(int id_rdv) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Rdv.class);
        criteria.add(Restrictions.eq("id_rdv",id_rdv));
        Rdv medecin = (Rdv) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return medecin;
    }
    
    @Override
    public void SaveRdv(Rdv rdv) {
        Session s = getSession();
        s.beginTransaction();
        s.save(rdv);
        s.getTransaction().commit();
        s.close();

    }
    @Override
    public Rdv findRdvByDateHeure(String date, String heure) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Rdv.class);
        criteria.add(Restrictions.eq("date",date));
        criteria.add(Restrictions.eq("heure",heure));
        Rdv rd = (Rdv) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return rd;
    }
}
