/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Soukaina
 */
@Entity
@Table(name="utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable{
    
    private int id_utilisateur;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String adresse;
    private String numero_telephone;
    private String login;
    private String password;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_utilisateur" ,unique = true,nullable = false)
    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    
    @Column(name="nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Column(name="prenom")
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Column(name="date_naissance")

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }
    @Column(name="adresse")

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    @Column(name="numero_telephone")

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }
    @Column(name="login")

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    @Column(name="password")

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_utilisateur=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", adresse=" + adresse + ", numero_telephone=" + numero_telephone + ", login=" + login + ", password=" + password + '}';
    }
 


   
    
    
    
}
