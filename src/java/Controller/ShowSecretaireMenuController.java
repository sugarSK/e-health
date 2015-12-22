/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soukaina
 */
@Controller 
        
public class ShowSecretaireMenuController {
    @RequestMapping(value="/accueilSecretaire",method=RequestMethod.GET)
    public String showAccueilSecretaire()
    {
        return "accueilSecretaire";
    }
    @RequestMapping(value="/SecretaireRdvEnAttente",method=RequestMethod.GET)
    public String showSecretaireRdvEnAttente()
    {
        return "SecretaireRdvEnAttente";
    }
    @RequestMapping(value="/secretaireAllFichesPatient",method=RequestMethod.GET)
    public String showSecretaireAllFichesPatien()
    {
        return "secretaireAllFichesPatient";
    }
}
