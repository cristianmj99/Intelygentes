<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<HTML lang="es">

    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloGrupal.css" />
	
	 <title> Carrito de la compra </title>
	
	</head>
<body>
<%@ include file="header.jsp" %>
  <div class="container">
    <div class="row">
      <div class="col-sm-9">
        <!-- Titulo de tienda -->
        <h2>D_MAKER</h2>
      </div>
      <div class="col-sm-3">
        <!-- Carrito de compras y sus items -->
        <div class='carrito'>
        <form action = "CarritoServlet.do" method="GET">
			<c:forEach var="pedido" items="${pedidos}">
      			<fieldset>   
	       		 <p>Producto: ${pedido.id_producto} / precio: ${pedido.precio_producto} / cantidad: ${pedido.cantidad}</p> 
			    </fieldset>
		    </c:forEach>
		</form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>