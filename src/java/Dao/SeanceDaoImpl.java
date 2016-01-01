/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Fiche;
import Metier.Seance;
import Metier.Secretaire;
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
@Repository("seanceDao")
public class SeanceDaoImpl extends AbstractDao<Integer, Seance> implements SeanceDao{
  


    @Override
    public void SaveCompteRenduSeance(Seance seance) {
        Session s = getSession();
        s.beginTransaction();
        s.save(seance);
        s.getTransaction().commit();
        s.close();

    }

    @Override
    public void UpdateCompteRenduSeance(Seance seance) {
        Session s = getSession();
        s.beginTransaction();
        s.update(seance);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Seance> fndAllCompteRenduSeanceByIdFiche(Fiche ficheIN) {
        Criteria criteria = getSession().createCriteria(Seance.class);
        criteria.add(Restrictions.eq("fiche",ficheIN));
        
        return (List<Seance>) criteria.list();
    }
    @Override
    public List<Seance> fndAllCompteRenduSeance() {
        Criteria criteria = getSession().createCriteria(Seance.class);
        return (List<Seance>) criteria.list();
    }
        
}
