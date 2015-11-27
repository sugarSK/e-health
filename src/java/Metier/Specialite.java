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
@Table(name="specialite")
public class Specialite  implements Serializable {
    
    private int id_specialite;
    private String intitule;
    private List<Medecin> medecins;
    private Admin admin;
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_specialite" ,unique = true,nullable = false)
    public int getId_specialite() {
        return id_specialite;
    }

    public void setId_specialite(int id_specialite) {
        this.id_specialite = id_specialite;
    }
    @Column(name="intitule")

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
@OneToMany(mappedBy = "specialite")
    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name="id_admin")
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Specialite{" + "id_specialite=" + id_specialite + ", intitule=" + intitule + ", medecins=" + medecins + ", admin=" + admin + '}';
    }
    
    
    
}
