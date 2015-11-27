/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Patient;
import Metier.Utilisateur;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author soukaina
 */
public class PatientDaoImpl extends AbstractDao<Integer, Patient> implements PatientDao {

    @Override
    public Patient findPatientById(String id_utilisateur) {
           Session s = getSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Patient.class);
        criteria.add(Restrictions.eq("id_utilisateur",id_utilisateur));
        Patient patient = (Patient) criteria.uniqueResult();
        s.getTransaction().commit();
        s.close();
        return patient;
    }

  

    @Override
    public void savePatient(Patient patient) {
          persist(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
         getSession().update(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
             Query query = getSession().createSQLQuery("delete from Patient where id_utilisateur = :identifiant")
            .setParameter("identifiant", patient.getId_utilisateur());
        query.executeUpdate();
    }
    
}
