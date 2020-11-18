<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<HTML lang="es">

    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloGrupal.css" />
	
	 <title>   </title>
	
	</head>
	
	<body>
				<%@ include file="header.jsp" %>
				 <h2>TIENDA</h2>
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
				 
				 <form action="VerTiendaServlet.do" method="get">
					<div class="form-group input-group">
					<input type="text" name="buscado" id="Buscador de locales" class="form-control" placeholder="Nombre total o parcial de un producto para consultar su información o añadirlo a la lista de la compra">
					<input class="tiendaID" name="id_tienda" type="hidden" value="${tienda.id_tienda}">
					<div class="input-group-btn">
					<input class="btn btn-default get_map" type="submit" value="Buscar producto"/>  
        		</form>
        		<h2> Productos de esta tienda</h2> 
        		<c:forEach var="producto" items="${lProductos}">
      			<fieldset>
	       		 <h3>${producto.nombreProducto}</h3>        
	       		 <p>${producto.descripcion}</p> 
	       		 <p>Ubicación: ${producto.ubicacionEnTienda}</p> 
	       		 <p>Unidades restantes: ${producto.unidadesRestantes}</p>
	         	 <p>Precio: ${producto.precio}</p>

				 <form method="post" action="AddProductoServlet.do?id=${producto.id_producto}">
				 	  <input class="unidades"  name="cantidad" type="number" min="1" max="10" id="tienda" value="1"/>
				 	  <input class="tiendaID" name="id_producto" type="hidden" value="${producto.id_producto}"/>
				 	  <input class="vertienda" type="submit" id="tienda" value="Añadir al carrito"/>
				 </form>
	      	 	</fieldset>
	       	</c:forEach>
	</body>
</html>