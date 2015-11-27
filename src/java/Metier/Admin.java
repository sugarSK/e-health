/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author soukaina
 */
@Entity
@Table(name="admin")
public class Admin implements Serializable {
     
    private int id_admin;
    private String login;
    private String password;
    
   
   @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_admin" ,unique = true,nullable = false)
    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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
        return "Admin{" + "id_admin=" + id_admin + ", login=" + login + ", password=" + password + '}';
    }

  
    
    
}
