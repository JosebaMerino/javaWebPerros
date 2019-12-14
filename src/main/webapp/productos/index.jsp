<%@include file="/includes/header.jsp" %>
<%@include file="/includes/navigation.jsp" %>

<a href="producto?accion=repoblar"> Repoblar</a>

<p>Dato : ${dato }</p>

<c:forEach items="${productos}" var="producto" >

	<p>
		${producto.id} - ${producto.nombre}
		<a href="producto?accion=eliminar&id=${producto.id}"> Eliminar</a>
		<a href="producto?accion=modificar&id=${producto.id}"> Modificar</a>
	</p>
</c:forEach>



<%@include file="/includes/footer.jsp" %>