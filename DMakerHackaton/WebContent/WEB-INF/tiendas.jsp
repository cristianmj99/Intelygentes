<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<HTML lang="es">

    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloGrupal.css" />
	
	 <title> Locales disponibles </title>
	
	</head>
	
	<body>
			<%@ include file="header.jsp" %>
            <h2>Locales disponibles</h2>
			<form action="TiendasServlet.do" method="post">
				<div class="form-group input-group">
				<input type="text" name="buscar" id="Buscador de locales" class="form-control" placeholder="Puedes buscar un local por ciudad (ej: Badajoz), empresa (ej: Mercadona) o empresa-ciudad (ej: Mercadona-Badajoz)">
				<div class="input-group-btn">
				<input class="btn btn-default get_map" type="submit" value="Buscar"/>  
        	</form>
        	
        	<c:forEach var="tienda" items="${lTiendas}">
      			<fieldset>
	       		 <h3>${tienda.nombre_tienda}</h3>        
	       		 <p>${tienda.calle}</p> 
	       		 <p>${tienda.municipio} (${tienda.provincia})</p> 
	       		 <p>${tienda.cp}</p>
	       		 <p>Aforo en este momento: ${tienda.aforo}/${tienda.aforomaximo}</p>    
	       		 <c:choose>
    				<c:when test="${tienda.casos=='s'}">
      				  <p> Ha habido casos de covid en los últimos días en esta tienda </p> 
  				    </c:when>    
   				    <c:otherwise>
       			      <p> No ha habido casos de covid en los últimos días en esta tienda </p> 
   					</c:otherwise>
				 </c:choose>
				 <form method="post" action="VerTiendaServlet.do?id=${tienda.id_tienda}">
				 	  <input class="tiendaID" name="id_tienda" type="hidden" value="${tienda.id_tienda}">
				 	  <input class="vertienda" type="submit" id="tienda" value="Ver tienda"/>
				 </form>
	      	 	</fieldset>
	       	</c:forEach>
    </div>
</div>

	</body>
	
</HTML>