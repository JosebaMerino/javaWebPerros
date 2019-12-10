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
    	<a class="nav-item nav-link" href="perros">Perros</a>
      	<a class="nav-item nav-link" href="perros2">Perros con JSTL</a>
		<span>
			Usuarios conectados ${applicationScope.numeroUsuariosConectados}
		</span>
    </div>
  </div>
  <span class="usuario">
	<%
		Usuario usuarioSesion = (Usuario) (session.getAttribute("usuario") == null ? new Usuario() : session.getAttribute("usuario"));
		if( !"".equals(usuarioSesion.getNombre()) ) {
	%>
			<span> <img src="<%=usuarioSesion.getImagen() %>" alt="" height="20px" width="20px" /> </span>
			<span> <a class="text-white" href="<%=usuarioSesion.getGithub() %>" target="_blank"> <%=usuarioSesion.getNombre() %></a> </span>
			<a class="text-white" href="logout"> Logout</a>
	<% 	} else { %>
			<a class="text-white" href="login.jsp"> Login </a>
	<% 	} %>
	</span>
</nav>

<main class="container">
