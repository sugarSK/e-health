/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Specialite;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface SpecialiteDao {
    void saveSpecialite(Specialite specialite);
    void updateSpecialite(Specialite specialite);
    void deleteSpecialite(Specialite specialite);
    Specialite findSpecialiteById(int id_specialite);
    List<Specialite> fndAllSpecialite();
    List<Specialite> fndAllSpecialiteById(int id_specialite);
}
