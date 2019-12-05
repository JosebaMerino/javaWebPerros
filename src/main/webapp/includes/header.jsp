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

<h1><%=usuario.getNombre() %></h1>
<p><%=usuario.getId() %></p>
<p><%=usuario.getGithub() %></p>
<p><%=usuario.getImagen() %></p>
