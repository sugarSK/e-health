/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Seance;
import Metier.Utilisateur;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author soukaina
 */
public class SeanceDaoImpl extends AbstractDao<Integer, Seance> implements SeanceDao{

    @Override
    public void SaveCompteRenduSeance(Seance seance) {
                persist(seance);

    }

    @Override
    public void UpdateCompteRenduSeance(Seance seance) {
                getSession().update(seance);

    }

    @Override
    public List<Seance> fndAllCompteRenduSeanceByIdFiche(int id_fiche) {
                   Criteria criteria = getSession().createCriteria(Seance.class);
        return (List<Seance>) criteria.list();
    }
    
}
