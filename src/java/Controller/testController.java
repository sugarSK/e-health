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
        Admin admin_1 = new Admin();
        admin_1.setLogin("ROOT");
        admin_1.setPassword("ROOT");
        
        Admin admin_2 = new Admin();
        admin_2.setLogin("admin");
        admin_2.setPassword("kjhkjhkjhkh");
        
        service.saveAdmin(admin_1);
        service.saveAdmin(admin_2);
        
        admin_2.setPassword("admin");
        service.updateAdmin(admin_2);
        
        service.deleteAdmin(admin_1);
        
        return admin_1.toString();
    }
}
