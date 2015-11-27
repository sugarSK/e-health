/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Dao.AbstractDao;
import Metier.Admin;
import org.springframework.stereotype.Repository;
/**
 *
 * @author PC
 */
@Repository("adminDao")
public class AdminDaoImpl extends AbstractDao<Integer, Admin> implements AdminDao{

    @Override
    public void saveUtilisateur(Admin admin) {
        getSession().save(admin);
    }

    @Override
    public void updateUtilisateur(Admin admin) {
        getSession().update(admin);
    }

    @Override
    public void deleteUtilisateur(Admin admin) {
        getSession().delete(admin);
    }
    
}
