/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Dao.AbstractDao;
import Metier.Admin;
import Metier.Medecin;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
/**
 *
 * @author PC
 */
@Repository("adminDao")
public class AdminDaoImpl extends AbstractDao<Integer, Admin> implements AdminDao{

    @Override
    public void saveAdmin(Admin admin) {
        Session s = getSession();
        s.beginTransaction();
        s.save(admin);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateAdmin(Admin admin) {
        Session s = getSession();
        s.beginTransaction();
        s.update(admin);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void deleteAdmin(Admin admin) {
        Session s = getSession();
        s.beginTransaction();
        s.delete(admin);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public Admin findAdminById(int id_admin) {
             Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Medecin.class);
        criteria.add(Restrictions.eq("id_admin",id_admin));
        Admin admin = (Admin) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return admin;
    
}
}
