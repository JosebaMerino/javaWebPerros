<%
String titulo = "";

%>
<%@page import="com.ipartek.formacion.model.pojo.Item"%>
<%@page import="java.util.ArrayList"%>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/navigation.jsp" %>


<h1>Perros</h1>


<%
	ArrayList<Item> items = (ArrayList<Item>)request.getAttribute("items");
%>

listado

<ol>
	<c:forEach items="${items }" var="item">
			<li>${item.nombre} - ${item.id}</li>
	</c:forEach>
</ol>

<hr>

formulario

<form action="items" method="post">

	<input name="nombre" placeholder="nombre del item" required>

	<input type="submit" value="Enviar">
</form>


<%@include file="/includes/footer.jsp" %>