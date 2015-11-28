/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Medecin;
import Metier.Specialite;
import org.hibernate.Session;
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
    
}
