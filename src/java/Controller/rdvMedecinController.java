   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.RdvDaoImpl;
import Metier.Rdv;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author soukaina
 */
@Controller
public class rdvMedecinController {
    
 @Autowired
 private RdvDaoImpl serviceRdvDao;
@RequestMapping(value="/fiche",method=RequestMethod.GET)
    public String fiche(@RequestParam("${listRdvs.id_rdv}") int rdv,HttpSession session)
    {
        Rdv rd= serviceRdvDao.findRdvById(rdv);
        if(rd != null)
        {
            session.setAttribute("rd", rd);
            
            return "fichePatient";
        }else{
            return "accueil";
        }
    }
    
    
}
