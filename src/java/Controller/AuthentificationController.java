/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Dao.UtilisateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import Metier.Utilisateur;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
/**
 *
 * @author PC
 */
@Controller
public class AuthentificationController {
    
    @Autowired
    private UtilisateurDao serviceUtilisateur;
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String showLogin()
    {
        return "index";
    }
    
    @RequestMapping(value="/doLogin",method=RequestMethod.POST)
    public String doLogin
        (@RequestParam("login") String login,
            @RequestParam("password") String password,
            HttpSession session)
    {
        Utilisateur user = serviceUtilisateur.findByCompte(login, password);
        if(user != null)
        {
            session.setAttribute("user", user);
            return "accueil";
        }else{
            return "index";
        }
    }
    
}
