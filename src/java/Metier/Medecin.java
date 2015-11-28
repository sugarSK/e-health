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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author soukaina
 */
@Entity
@Table(name="medecin")
    public class Medecin extends Utilisateur implements Serializable{
    private Specialite specialite;
    private List<Seance> seances;
    private List<Fiche> fiches;
    private List<Secretaire> secretaires;
    private Admin admin;
     
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_specialite")  
    @LazyCollection(LazyCollectionOption.FALSE)
    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
    @OneToMany(mappedBy ="medecin", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="id_admin")
    public Admin getAdmin() {
        return admin;
    }

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    @OneToMany(mappedBy = "medecin",cascade = CascadeType.ALL)   
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Secretaire> getSecretaires() {
        return secretaires;
    }

    public void setSecretaires(List<Secretaire> secretaires) {
        this.secretaires = secretaires;
    }

    @Override
    public String toString() {
        return "Medecin{" + "specialite=" + specialite + ", seances=" + seances + ", fiches=" + fiches + ", secretaires=" + secretaires + ", admin=" + admin + '}';
    } 
}
