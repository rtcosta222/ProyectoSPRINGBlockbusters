/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author lscar
 */
public class Peliculas {
    private int idPelicula;
    private int idDistribuidor;
    private int idGenero;
    private String titulo;
    private int idNacionalidad;
    private String argumento;
    private String foto;
    private String fechaEstreno;
    private String actores;
    private String director;
    private int duracion;
    private int precio;

    public Peliculas(){}
    
    public Peliculas(int idPelicula,
                     int idDistribuidor,
                     int idGenero,
                     String titulo,
                     int idNacionalidad,
                     String argumento,
                     String foto,
                     String fechaEstreno,
                     String actores,
                     String director,
                     int duracion,
                     int precio){    
        this.idPelicula = idPelicula;
        this.idDistribuidor = idDistribuidor;
        this.idGenero = idGenero;
        this.titulo = titulo;
        this.idNacionalidad = idNacionalidad;
        this.argumento = argumento;
        this.foto = foto;
        this.fechaEstreno = fechaEstreno;
        this.actores = actores;
        this.director = director;
        this.duracion = duracion;
        this.precio = precio;        
    }
    
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
