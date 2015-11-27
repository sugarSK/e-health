/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.io.Serializable;
import java.util.Date;
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
 */@Entity
   @Table(name="rdv")
public class Rdv implements Serializable {
    private int id_rdv;
    private Date date;
    private String heure;
    private String cause;
    private Patient patient;
    private Medecin medecin;
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_rdv" ,unique = true,nullable = false)
   public int getId_rdv() {
        return id_rdv;
    }

    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }
    @Column(name="date")
    public Date getDate() {
        return date;
    }

    

    public void setDate(Date date) {
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
        return "Rdv{" + "id_rdv=" + id_rdv + ", date=" + date + ", heure=" + heure + ", cause=" + cause + ", patient=" + patient + ", medecin=" + medecin + '}';
    }


    
    
}
