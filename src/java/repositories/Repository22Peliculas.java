/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Peliculas;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author lscar
 */
public class Repository22Peliculas {
    DriverManagerDataSource datasource;

    public Repository22Peliculas(DriverManagerDataSource datasource){
        this.datasource = datasource;
    }
    
    public int getNumreg() throws SQLException {
        Connection cn = this.datasource.getConnection();
        String sql = "select count(idpelicula) as numpeli from peliculas";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int numreg = rs.getInt("numpeli");
        rs.close();
        cn.close();
        return numreg;
    }
    
    public List<Peliculas> getCarroCompra(ArrayList<String> carrocompra) throws SQLException{
        Connection cn = datasource.getConnection();
        
        String datos = "";
        for(String cc: carrocompra){
            datos += cc + ","; 
        }
        datos = datos.substring(0, datos.lastIndexOf(","));

        String sql = "select * from peliculas where idpelicula in(" + datos + ")";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Peliculas> carrocompradetalles = new ArrayList<>();
        while(rs.next()){
        Peliculas pelicula = new Peliculas(rs.getInt("IDPELICULA"),
                                            rs.getInt("IDDISTRIBUIDOR"),
                                            rs.getInt("IDGENERO"),
                                            rs.getString("TITULO"),
                                            rs.getInt("IDNACIONALIDAD"),
                                            rs.getString("ARGUMENTO"),
                                            rs.getString("FOTO"),
                                            rs.getString("FECHA_ESTRENO"),
                                            rs.getString("ACTORES"),
                                            rs.getString("DIRECTOR"),
                                            rs.getInt("DURACION"),
                                            rs.getInt("PRECIO"));
            carrocompradetalles.add(pelicula);
        }
        rs.close();
        cn.close();
        return carrocompradetalles;
    }
    
    public Peliculas getPelicula(int idpelicula) throws SQLException{
        Connection cn = datasource.getConnection();
        String sql = "select * from peliculas where idpelicula=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idpelicula);
        ResultSet rs = pst.executeQuery();
        rs.next();
        Peliculas pelicula = new Peliculas(rs.getInt("IDPELICULA"),
                                            rs.getInt("IDDISTRIBUIDOR"),
                                            rs.getInt("IDGENERO"),
                                            rs.getString("TITULO"),
                                            rs.getInt("IDNACIONALIDAD"),
                                            rs.getString("ARGUMENTO"),
                                            rs.getString("FOTO"),
                                            rs.getString("FECHA_ESTRENO"),
                                            rs.getString("ACTORES"),
                                            rs.getString("DIRECTOR"),
                                            rs.getInt("DURACION"),
                                            rs.getInt("PRECIO"));
        rs.close();
        cn.close();
        return pelicula;
    }
    
    public List<Peliculas> getPeliculas(int pos) throws SQLException{
        Connection cn = this.datasource.getConnection();

        String sql = "SELECT * FROM "
        + "(SELECT tablapeli.*, ROWNUM rnum FROM "
        + "(select * from peliculas order by titulo) tablapeli "
        + "WHERE ROWNUM < " + (pos + 3) + ") WHERE rnum >= " + pos;

//        String sql = "SELECT APELLIDO, SALARIO, OFICIO FROM "
//        + "(SELECT tablaemp.*, ROWNUM rnum FROM "
//        + "(SELECT APELLIDO, SALARIO, OFICIO FROM emp ORDER BY APELLIDO) tablaemp "
//        + "WHERE ROWNUM < " + (pos + 5) + ") WHERE rnum >= " + pos;

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Peliculas> peliculas = new ArrayList<>(); 
        while(rs.next()){
            Peliculas peli = new Peliculas(rs.getInt("IDPELICULA"),
                                            rs.getInt("IDDISTRIBUIDOR"),
                                            rs.getInt("IDGENERO"),
                                            rs.getString("TITULO"),
                                            rs.getInt("IDNACIONALIDAD"),
                                            rs.getString("ARGUMENTO"),
                                            rs.getString("FOTO"),
                                            rs.getString("FECHA_ESTRENO"),
                                            rs.getString("ACTORES"),
                                            rs.getString("DIRECTOR"),
                                            rs.getInt("DURACION"),
                                            rs.getInt("PRECIO"));
            peliculas.add(peli);
        }
        rs.close();
        cn.close();
        return peliculas;
    }
}
