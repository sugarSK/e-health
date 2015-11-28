/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Utilisateur;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soukaina
 */
@Repository("utilisateurDao")
public class UtilisateurDaoImpl  extends AbstractDao<Integer, Utilisateur> implements UtilisateurDao {

      @Override
    public void updateUtilisateur(Utilisateur Utilisateur){
        Session s = getSession();
        s.beginTransaction();
        s.update(Utilisateur);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void saveUtilisateur(Utilisateur Utilisateur) {
        Session s = getSession();
        s.beginTransaction();
        s.persist(Utilisateur);
        s.getTransaction().commit();
        s.close();
    }
 
  
    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) {
               Session s = getSession();
        s.beginTransaction();
        s.delete(utilisateur);
        s.getTransaction().commit();
        s.close();

    }

    @Override
    public Utilisateur findByCompte(String login, String passsword) {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("login",login));
        criteria.add(Restrictions.eq("password", passsword));
        Utilisateur user = (Utilisateur) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return user;
    }

    @Override
    public Utilisateur findUtilisateurById(String id_utilisateur)
    {
        Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("id_utilisateur",id_utilisateur));
        Utilisateur user = (Utilisateur) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return user;
    }
    
    
    
}
