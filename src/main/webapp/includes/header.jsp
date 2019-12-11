<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="req" value="${pageContext.request}"></c:set>
<c:set var="splitedReq" value="${fn:split(req.requestURL, '/')}"></c:set>
<c:set var="url" value="${splitedReq[fn:length(splitedReq) - 1]}"></c:set>

<%
/*
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
*/
%>

<!doctype html>
<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>
<html lang="es">
<head>
	<meta charset="UTF-8" />
	<title> PerrosWeb | ${fn:substringBefore(url, '.jsp')}</title>

<base href="${pageContext.request.contextPath}/" />

<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet" href="css/custom.css" />

</head>
<body>
