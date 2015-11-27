/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author soukaina
 */
@Entity
@Table(name="fiche")
public class Fiche implements Serializable{
    
    private int id_fiche;   
    private Patient patient;
    private Medecin medecin;
    private List<Seance> seances;
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_fiche" ,unique = true,nullable = false)
    public int getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
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

    @OneToMany(mappedBy = "fiche")
    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    @Override
    public String toString() {
        return "Fiche{" + "id_fiche=" + id_fiche + ", patient=" + patient + ", medecin=" + medecin + ", seances=" + seances + '}';
    }
    
    
    
}
