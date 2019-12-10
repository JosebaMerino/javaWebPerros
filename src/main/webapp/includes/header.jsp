<%
	String requestURL = request.getRequestURL().toString();
	//out.print(requestURL);
	String[] requestURLSplited = requestURL.split("/");
	String URL = requestURLSplited[requestURLSplited.length - 1];

	String titulo = "";
	if( "javaWebPerros".equals(URL)) {
		titulo = "index";
	} else {
		titulo = URL.substring(0, URL.length() - 4);
	}

	char primeraLetra = titulo.charAt(0);
	titulo = Character.toUpperCase(primeraLetra) + titulo.substring(1);
%>

<!doctype html>
<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>
<html lang="es">
<head>
	<meta charset="UTF-8" />
	<title> PerrosWeb | <%=titulo %></title>

<base href="/javaWebPerros/" />

<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet" href="css/custom.css" />

</head>
<body>
