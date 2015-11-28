/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.Utilisateur;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="patient")
public class Patient extends Utilisateur implements Serializable{
    private String maladie;
    
    @Column(name="maladie")
    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }


    @Override
    public String toString() {
        return "Patient{" + "maladie=" + maladie +  '}';
    }    
}
