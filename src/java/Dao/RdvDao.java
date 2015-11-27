/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Metier.Rdv;
import java.util.List;

/**
 *
 * @author soukaina
 */
public interface RdvDao  {
        List<Rdv> findAllRdv();
        
    
}
