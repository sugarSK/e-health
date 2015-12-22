/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.RdvEnAttente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soukaina
 */
@Repository("rdvEnAttenteDao")
public class RdvEnAttenteImpl extends AbstractDao<Integer, RdvEnAttenteDao> implements RdvEnAttenteDao{

    @Override
    public List<RdvEnAttente> findAllRdvEnattenteByIdMedecin(int id_utilisateur) {
           Criteria criteria = getSession().createCriteria(RdvEnAttente.class);
           criteria.add(Restrictions.eq("id_utilisateur",id_utilisateur));
        return (List<RdvEnAttente>) criteria.list();
    }

    @Override
    public RdvEnAttente findRdvEnAttenteById(int id_rdv_attente) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(RdvEnAttente.class);
        criteria.add(Restrictions.eq("id_rdv_attente",id_rdv_attente));
        RdvEnAttente rd = (RdvEnAttente) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return rd;
    }

    @Override
    public RdvEnAttente findRdvEnAttenteByDateHeure(String date, String heure) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(RdvEnAttente.class);
        criteria.add(Restrictions.eq("date",date));
        criteria.add(Restrictions.eq("heure",heure));
        RdvEnAttente rd = (RdvEnAttente) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return rd;
    }
    
}
