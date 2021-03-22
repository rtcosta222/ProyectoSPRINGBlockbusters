/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class Controller22Detalle implements Controller {

    Repository22Peliculas repo;
    
    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("peliculas22detalle");
        this.repo = (Repository22Peliculas)this.getBean("repo22peliculas", hsr.getServletContext());

        String ui = hsr.getParameter("idpelicula");
        if(ui != null){
            int idpelicula = Integer.parseInt(ui);
            Peliculas pelicula = this.repo.getPelicula(idpelicula);
            mv.addObject("PELICULA", pelicula);
        }
        return mv;
    }
}
