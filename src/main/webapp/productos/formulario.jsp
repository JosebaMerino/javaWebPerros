<%@include file="/includes/header.jsp" %>
<%@include file="/includes/navigation.jsp" %>

${mensaje  }
<form action="producto" method="post">

	<input value="${not empty producto ? producto.id : '0'}" readonly type="text" name="id" /><br />
	<input value="${producto.nombre }" type="text" name="nombre" /><br />
	<input value="${producto.precio }" type="text" name="precio" /><br />
	<input value="${producto.imagen }" type="text" name="imagen" /><br />
	<input value="${producto.descripcion }" type="text" name="descripcion" /><br />
	<input value="${producto.descuento }" type="text" name="descuento" /><br />

	<button type="submit"> Enviar  </button>

</form>


<%@include file="/includes/footer.jsp" %>