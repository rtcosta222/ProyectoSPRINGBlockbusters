<%-- 
    Document   : peliculas22carritocompra
    Created on : 22-mar-2021, 1:51:38
    Author     : lscar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BLOCKBUSTER22</title>
    </head>
    <body>
        <h1>PRODUCTOS</h1>
        <a href="peliculas22.htm">Volver</a>
        <h2 style="color: blue"> Valor total: <c:out value="${VALORTOTAL}"/>$$</h2><br>
        <table border="1">
            <thead style="background-color: red">
                <tr>
                    <th>TITULO</th>
                    <th>PRECIO</th>
                    <th>CARTEL</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${CARRODECOMPRA != null}">
                <c:forEach items="${CARRODECOMPRA}" var="cc">
                    <tr>
                        <td><c:out value="${cc.titulo}"/></td>
                        <td><c:out value="${cc.precio}"/></td>
                        <td><img src="images/${cc.foto}" width="80" height="auto"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </body>
</html>
