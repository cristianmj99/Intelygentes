<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<HTML lang="es">

    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloGrupal.css" />
		
        <title> D_MAKER </title>
        
    </head>
 
            <div id="Arriba"></div>
    
    <body>
		<%@ include file="header.jsp" %>       
        <header>
            <h1>D_MAKER</h1>
        </header>
        
        <section>
            <p> Compañía <strong>D_MAKER</strong>. <br> </p>
            <img class="foto" src=" https://cdn.pixabay.com/photo/2016/09/30/19/10/ecommerce-1706103__340.png"
                 alt="Foto de nuestra compañía"
                 width="250"
                 height="250">
        </section>
        
        <nav>
            <h2>Información </h2>
            
            <p>Somos una compañía que buscamos ayudar a la gente en estos tiempos de Covid-19 <br> Nuestro propósito es poder evitar aglomeraciones dentro de los establecimientos y disminuir la movilidad dentro de estos para evitar el riesgo de contagio. <br> ¡ESPERAMOS AYUDAROS!  </p>
            
        </nav>
            

        
    </body>
    
      <footer class="container">
    <div class="row">
      <div class="col-sm">
        &copy; <a target="_blank">D_MAKER</a>
      </div>
    </div>
  </footer>

</HTML>