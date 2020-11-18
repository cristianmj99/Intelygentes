<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>    
     
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloGrupal.css" />
	
	 <title> Contacto </title>
	
	</head>
	
	<body>
		<%@ include file="header.jsp" %>  

            <a id="Contacto"></a>
            <h2>Contacto</h2>
            <ul class = "contacto">
				<p>Contacta con nosotros si has tenido alguna incidencia o alguna consulta.</p>
				<p>Nos pondremos en contacto con usted de inmediato</p>
                <p class="anotacion">Los datos requeridos son de carácter obligatorio.</p>

                <form class= "formContacto" action="ContactoServlet.do" method="post" enctype="text/plain">

                    <li class="listaInvisible"> <p class="cabecera">Nombre </p>        
                        <input    required="true"   type="text" name="nombre" size="30" maxlength="30" placeholder="Nombre y apellidos"   name="nombre" S>     
                    </li>

                    <li class="listaInvisible"> <p class="cabecera">Email </p>         
                        <input    required="true"   type="text" size="30" maxlength="30" placeholder="XXXX@gmail.com" name="email"    pattern=".+@gmail.com">      
                    </li>


                    <li class="listaInvisible"> <p class="cabecera">Mensaje </p>       
                        <textarea required="true"   name="mensaje"  rows="10" cols="40" placeholder="Escribe aquí tu mensaje"></textarea>             
                    </li>
					
                    <li class="listaInvisible elementoBoton"> <input class="boton" type="submit"   value="Enviar formulario">  </li>
                    <li class="listaInvisible elementoBoton"> <input class="boton" type="reset"    value="Reiniciar valores">  </li>

                </form>
				<p><u>Datos de contacto:</u><br>
    Cristian Martín. 
    <a href= "mailto:crmartinj@alumnos.unex.es">crmartinj@alumnos.unex.es<br></a>
    Sergio Chamorro.
    <a href= "mailto:schamorrg@alumnos.unex.es">schamorrg@alumnos.unex.es<br></a>
    Juanma Roldán.
    <a href= "mailto:juroldanc@alumnos.unex.es">juroldanc@alumnos.unex.es<br></a>
    Cristian Román.
    <a href= "mailto:cromanro@alumnos.unex.es">cromanro@alumnos.unex.es<br></a>
    Luis Jesús Martín.
    <a href="mailto:lmartinfp@alumnos.unex.es">lmartinfp@alumnos.unex.es<br></a>
    </p>

            </ul> 

  <footer class="container">
    <div class="row">
      <div class="col-sm">
        &copy; <a target="_blank">D_MAKER</a>
      </div>
    </div>
  </footer>
	</body>
	
</HTML>