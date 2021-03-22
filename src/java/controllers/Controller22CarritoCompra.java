/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
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
public class Controller22CarritoCompra implements Controller {

    Repository22Peliculas repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("peliculas22carritocompra");
        
        String idpelicula = hsr.getParameter("idpelicula");
        ArrayList<String> listaproductos;
        if(hsr.getSession().getAttribute("listaids") != null){
            listaproductos = (ArrayList<String>)hsr.getSession().getAttribute("listaids");
        } else{
            listaproductos = new ArrayList<>();
        }

        if(listaproductos.contains(idpelicula)){
            boolean iddup = true;
            mv.addObject("IDDUPLICADA", iddup);
        } else{
            listaproductos.add(idpelicula);
            hsr.getSession().setAttribute("listaids", listaproductos);
        }

        this.repo = (Repository22Peliculas)this.getBean("repo22peliculas", hsr.getServletContext());
        List<Peliculas> peliculas = this.repo.getCarroCompra(listaproductos);
        mv.addObject("CARRODECOMPRA", peliculas);
        
        int valortotaldecompra = 0;
        for(Peliculas p: peliculas){
            valortotaldecompra += p.getPrecio();
        }        
        mv.addObject("VALORTOTAL", valortotaldecompra);
        
        return mv;
    }
    
}
