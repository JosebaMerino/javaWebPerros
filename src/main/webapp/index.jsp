<%
	String titulo = "index";
%>


<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<%

	out.print("<h1>Soy index.jsp</h1>");

%>

<a href="items">CRUD Perros</a>


<%@include file="includes/footer.jsp" %>