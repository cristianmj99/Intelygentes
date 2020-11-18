<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css" />
  </head>


<body>
        <nav class="navBar">
        
            <a class="boton botonIzquierdo" href="IndexServlet.do"> Inicio </a>
            <a class="boton botonIzquierdo" href="TiendasServlet.do" title="Locales disponibles">Locales disponibles</a>		
			<a class="boton botonIzquierdo" href="CarritoServlet.do" title="Carrito ">Carrito</a>
			<a class="boton botonIzquierdo" href="ContactoServlet.do" title="Contacto ">Contacto</a>
			
        </nav>
</body>
</html>