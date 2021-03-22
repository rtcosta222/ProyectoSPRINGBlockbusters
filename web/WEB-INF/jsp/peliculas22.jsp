<%-- 
    Document   : blockbuster22
    Created on : 18-mar-2021, 19:18:20
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blockbusters!!!</title>
    </head>
    <body>
        <h1>Listado de Películas</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>TITULO</th>
                    <th>PRECIO</th>
                    <th>FOTO</th>
                    <th>VER DETALLES</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${PELICULAS != null}">
                    <c:forEach items="${PELICULAS}" var="peli">
                        <tr>
                            <td><c:out value="${peli.titulo}"/></td>
                            <td><c:out value="${peli.precio}"/>$</td>
                            <td><img src="images/${peli.foto}" width="80" height="auto"/></td>
                            <td><a href="peliculas22detalle.htm?idpelicula=${peli.idPelicula}">Detalles</a></td>
                        </tr>    
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <c:if test="${MENU != null}">
            <c:out value="${MENU}" escapeXml="false"/>
        </c:if>
    </body>
</html>
