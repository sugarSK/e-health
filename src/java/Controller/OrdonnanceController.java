/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soukaina
 */
@Controller
public class OrdonnanceController {
    
    @Autowired
    ServletContext context;

    public void setContext(ServletContext context) {
        this.context = context;
    }

    @RequestMapping(value = "/ordonnance/{id_seance}",method = RequestMethod.GET)
    public void ShowOrdonnance(@PathVariable("id_seance") int num_seance,
           HttpSession session,HttpServletResponse response){
        try{
            Map m=new HashMap();
            m.put("num_seance", num_seance); //Parameters to be sent to report
            //m.put("spID", 37); //Parameter to be sent to report
            System.out.println(context.getContextPath());
            JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream("/users/said/NetBeansProjects/e-health/web/vues/ordonance_soukaina.jrxml"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/e-health", "root", "root");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, m, con);
            JasperExportManager.exportReportToPdfFile(jasperPrint,"/users/said/NetBeansProjects/e-health/web/vues/ordonance_soukaina.pdf");
            //JasperViewer.viewReport(jasperPrint);
            response.setContentType("application/download");
            response.setHeader("Content-Disposition",  "inline; filename=\"ordonnance.pdf\"");
            InputStream in = new FileInputStream("/users/said/NetBeansProjects/e-health/web/vues/ordonance_soukaina.pdf");
            int lire=0;
            byte[] bytes = new byte[1024];
            while((lire=in.read(bytes))!=-1)
                    response.getOutputStream().write(bytes, 0, lire);

            response.getOutputStream().flush();
            response.getOutputStream().close();
        }catch(Exception e){e.printStackTrace();}
                    System.err.println(context.getRealPath("vues/ordonance_soukaina.pdf"));

        //return "listSeance";
    }
}
