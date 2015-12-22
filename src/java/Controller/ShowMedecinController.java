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
public class ShowMedecinController {
        @RequestMapping(value="/accueilMedecin",method=RequestMethod.GET)
    public String showAccueilSecretaire()
    {
        return "accueilMedecin";
    }
      @RequestMapping(value="/fiches",method=RequestMethod.GET)
    public String showfiches()
    {
        return "fiches";
    }
  
}
