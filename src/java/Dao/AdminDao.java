/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Metier.Admin;
/**
 *
 * @author PC
 */
public interface AdminDao {
    void saveUtilisateur(Admin admin);
     
    void updateUtilisateur(Admin admin);
     
    void deleteUtilisateur(Admin admin);

}
