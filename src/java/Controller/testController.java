/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminDao;
import Metier.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PC
 */
@Controller
public class testController {
    
    @Autowired
    private AdminDao service ;
    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public String test()
    {
        Admin admin = new Admin();
        admin.setId_admin(1);
        admin.setLogin("admin");
        admin.setPassword("admin");
        
        service.saveUtilisateur(admin);
        return admin.toString();
    }
}
