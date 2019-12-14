<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="index.jsp">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
    	<a class="nav-item nav-link active" href="index.jsp">Index <span class="sr-only">(current)</span></a>
    	<a class="nav-item nav-link" href="registro.jsp">Registrarse</a>
    	<a class="nav-item nav-link" href="perros">Perros</a>
      	<a class="nav-item nav-link" href="perros2">Perros con JSTL</a>
      	<a class="nav-item nav-link" href="formulario.jsp">Formulario de deportes</a>
      	<a class="nav-item nav-link" href="producto">Productos</a>
      	<a class="nav-item nav-link" href="productos/formulario.jsp">Productos formulario</a>
		<span>
			Usuarios conectados ${applicationScope.numeroUsuariosConectados}
		</span>
    </div>
  </div>
  <span class="usuario">
	  	<c:choose>
		  	<c:when test="${not empty usuario}">
		 		<span> <img src="${usuario.getImagen()}" alt="" height="20px" width="20px" /> </span>
				<span> <a class="text-white" href="${usuarioSesion.getGithub()}" target="_blank"> ${usuarioSesion.getNombre()}</a> </span>
				<a class="text-white" href="logout"> Logout</a>
		  	</c:when>
		  	<c:otherwise>
		  		<a class="text-white" href="login.jsp"> Login </a>
		  	</c:otherwise>
	  	</c:choose>
	</span>
</nav>

<main class="container">
