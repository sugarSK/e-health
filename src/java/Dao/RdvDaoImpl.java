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

/**
 *
 * @author soukaina
 */
public class RdvDaoImpl extends AbstractDao<Integer, Utilisateur> implements RdvDao{

    @Override
    public List<Rdv> findAllRdv() {
           Criteria criteria = getSession().createCriteria(Utilisateur.class);
        return (List<Rdv>) criteria.list();
    }
    
    
}
