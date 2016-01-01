/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Medecin;
import Metier.Specialite;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soukaina
 */
@Repository("specialiteDao")
public class SpecialiteDaoImpl extends AbstractDao<Integer, Specialite> implements SpecialiteDao{

   
    @Override
    public void saveSpecialite(Specialite specialite) {
        Session s = getSession();
        s.beginTransaction();
        s.save(specialite);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateSpecialite(Specialite specialite) {
        Session s = getSession();
        s.beginTransaction();
        s.update(specialite);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void deleteSpecialite(Specialite specialite) {
        Session s = getSession();
        s.beginTransaction();
        s.delete(specialite);
        s.getTransaction().commit();
        s.close();
    }
           
    @Override
    public Specialite findSpecialiteById(int id_specialite) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Specialite.class);
        criteria.add(Restrictions.eq("id_specialite",id_specialite));
        Specialite sp = (Specialite) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return sp;
    }
    @Override
    public List<Specialite> fndAllSpecialite() {
        Criteria criteria = getSession().createCriteria(Specialite.class);
        return (List<Specialite>) criteria.list();
    }
    @Override
    public List<Specialite> fndAllSpecialiteById(int id_specialite) {
        Criteria criteria = getSession().createCriteria(Specialite.class);
        criteria.add(Restrictions.eq("id_specialite",id_specialite));
        return (List<Specialite>) criteria.list();
    }
}
