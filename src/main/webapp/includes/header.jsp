<!doctype html>
<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>
<html lang="es">
<head>
	<meta charset="UTF-8" />
	<title><%=titulo %></title>

<base href="/javaWebPerros/" />

<link rel="stylesheet" href="css/bootstrap.css">

</head>
<body>

<%

Usuario usuario = (Usuario) session.getAttribute("usuario");

%>

<% if(usuario != null) { %>

<h1><%=usuario.getNombre() %></h1>
<p><%=usuario.getId() %></p>
<p> <a href="<%=usuario.getGithub() %>"> GitHub</a> </p>
<p> <img src="<%=usuario.getImagen() %>" alt="" height="20px" width="20px" /> </p>
<a href="logout"> Logout</a>

<% } else { %>
	<a href="login.jsp"> Logearse </a>
<% } %>