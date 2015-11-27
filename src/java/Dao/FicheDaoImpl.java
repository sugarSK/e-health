/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Fiche;
import Metier.Rdv;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author soukaina
 */
public class FicheDaoImpl extends AbstractDao<Integer, Fiche> implements FicheDao {

    @Override
    public Fiche findFicheByIdMedecinAndIdPatient(int id_utilisateur_medecin, int id_utilisateur_patient) {
          Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Fiche.class);
        criteria.add(Restrictions.eq("id_utilisateur_medecin",id_utilisateur_medecin));
        criteria.add(Restrictions.eq("id_utilisateur_patient",id_utilisateur_patient));
        Fiche fiche = (Fiche) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return fiche;
    }
    
}
