/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Peliculas;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.Repository22Peliculas;

/**
 *
 * @author lscar
 */
public class Controller22Peliculas implements Controller{
    Repository22Peliculas repo;
    
    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("peliculas22");
        this.repo = (Repository22Peliculas)this.getBean("repo22peliculas", hsr.getServletContext());

        int pos = 1;
        if(hsr.getParameter("posicion") != null){
            pos = Integer.parseInt(hsr.getParameter("posicion"));
        }
        List<Peliculas> peliculas = this.repo.getPeliculas(pos);
        mv.addObject("PELICULAS", peliculas);

        int numreg = this.repo.getNumreg();
        String menu = "";
        int numpagina = 1;
        for (int i = 1; i <= numreg; i+=3){
            menu += "<a href='peliculas22.htm?posicion=" + i + "'>" + numpagina++ + "</a> | ";
        }
        mv.addObject("MENU", menu);        
        return mv;
    }


}
