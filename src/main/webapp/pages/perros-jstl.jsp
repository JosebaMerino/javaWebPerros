<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1>Perros jstl</h1>
<p> Mismo ejemplo para hacer un crud pero con tagslibs y EL</p>

<h2> Tenemos ${fn:length(perros)} perros en adopcion </h2>
<main>

	<c:if test="${not empty mensaje}">
		<p>${mensaje}</p>
	</c:if>
	<c:if test="${empty mensaje}">
		<p> No tienes ningun mensaje</p>
	</c:if>
	<ol>
		<c:forEach items="${perros}" var="p">
			<li>${p.id} - ${p.nombre}
			<img src="${p.foto}" alt="" />
			<a href="/javaWebPerros/perros2?accion=modificar&id=${p.id }"> Modificar</a>
			</li>
		</c:forEach>
	</ol>

	<c:if test="${empty modificarPerro}">
		<p>No tenemos perro para editar</p>
		Vamos a inicializarlo.
		<jsp:useBean id="modificarPerro" class="com.ipartek.formacion.model.pojo.Perro"></jsp:useBean>
	</c:if>

	<form action="post"></form>
	${modificarPerro}


</main>