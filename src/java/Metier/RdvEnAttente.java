/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author soukaina
 */
  @Entity
@Table(name="rdvEnAttente")
public class RdvEnAttente implements Serializable{

 
    private int id_rdv_attente;
    private String date;
    private String heure;
    private String cause;
    private Patient patient;
    private Medecin medecin;
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_rdv_attente" ,unique = true,nullable = false)
   public int getId_rdv_attente() {
        return id_rdv_attente;
    }

    public void setId_rdv_attente(int id_rdv_attente) {
        this.id_rdv_attente = id_rdv_attente;
    }
    
    @Column(name="date")
    public String getDate() {
        return date;
    }

    

    public void setDate(String date) {
        this.date = date;
    }
    @Column(name="heure")
    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
@Column(name="cause")

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="id_utilisateur_patient")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="id_utilisateur_medecin")
    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return "Rdv{" + "id_rdv_attente=" + id_rdv_attente + ", date=" + date + ", heure=" + heure + ", cause=" + cause + ", patient=" + patient + ", medecin=" + medecin + '}';
    }


    
    
}


