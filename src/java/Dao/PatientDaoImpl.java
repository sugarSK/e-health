/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Medecin;
import Metier.Patient;
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
@Repository("patientDao")
public class PatientDaoImpl extends AbstractDao<Integer, Patient> implements PatientDao {

    @Override
    public Patient findPatientById(int id_utilisateur) {
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
        Session s = getSession();
        s.beginTransaction();
        s.save(patient);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updatePatient(Patient patient) {
        Session s = getSession();
        s.beginTransaction();
        s.update(patient);
        s.getTransaction().commit();
        s.close();    
    }

    @Override
    public void deletePatient(Patient patient) {
        Session s = getSession();
        s.beginTransaction();
        s.delete(patient);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Patient> findAllPatient() {
         Criteria criteria = getSession().createCriteria(Patient.class);
        return (List<Patient>) criteria.list();
    }
    
}
