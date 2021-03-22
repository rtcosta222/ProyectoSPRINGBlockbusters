<%-- 
    Document   : pelicula22detalle
    Created on : 18-mar-2021, 21:11:19
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blockbusters</title>
    </head>
    <body>
        <h1>Detalles de Película</h1>
        <table border="1" width="400">
            <tbody>
                <c:if test="${PELICULA != null}">
                    <tr>
                        <td colspan="2" style="text-align:center"><b><c:out value="${PELICULA.titulo}"/></b></td>
                    </tr>    
                    <tr>
                        <td rowspan="2"><img src="images/${PELICULA.foto}" width="100" height="auto"/></td>
                        <td style="text-align:center"><b>ACTORES</b></td>
                    </tr>
                    <tr>
                        <td><c:out value="${PELICULA.actores}"/></td>
                    </tr> 
                    <tr>
                        <td colspan="2" style="text-align:center"><b>Argumento</b></td>
                    </tr>
                    <tr>
                        <td colspan="2"><c:out value="${PELICULA.argumento}"/></td>
                    </tr> 
                    <tr>
                        <td><a href="peliculas22carritocompra.htm?idpelicula=${PELICULA.idPelicula}"><b>Comprar</b></a></td>
                        <td><a href="peliculas22.htm"><b>Volver</b></a></td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </body>
</html>
