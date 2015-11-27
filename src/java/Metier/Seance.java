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
 */
@Entity
@Table(name="seance")
public class Seance implements Serializable{
    private int id_seance;
    private String date;
    private String compte_rendu;
    private String medicament;
    private Fiche fiche;
    private Medecin medecin;
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_seance" ,unique = true,nullable = false)
    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }
@Column(name="date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
@Column(name="compte_rendu")

    public String getCompte_rendu() {
        return compte_rendu;
    }

    public void setCompte_rendu(String compte_rendu) {
        this.compte_rendu = compte_rendu;
    }
@Column(name="medicament")

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }
 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name="id_fiche")  
    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }
 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name="id_utilisateur") 
    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return "Seance{" + "id_seance=" + id_seance + ", date=" + date + ", compte_rendu=" + compte_rendu + ", medicament=" + medicament + ", fiche=" + fiche + ", medecin=" + medecin + '}';
    }
    
    
}
