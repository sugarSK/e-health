/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author soukaina
 */
@Controller
public class ShowAdminMenuController {
    
    @RequestMapping(value = "/accueilAdmin")
    public String showAccueilAdmin(){
        return "accueilAdmin";
    }
    @RequestMapping(value = "/AdminAjouterMedecin")
    public String showAjouterMedecin(){
        return "AdminAjouterMedecin";
    }  
    @RequestMapping(value = "/AdminAjouterSecretaire")
    public String showAjouterSecretaire(){
        return "AdminAjouterSecretaire";
    }  
    @RequestMapping(value = "/AdminAjouterSpecialite")
    public String showAjouterSpetialite(){
        return "AdminAjouterSpecialite";
    }  
    
}
