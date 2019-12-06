<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>

<form action="login" method="post">
	<input type="text"
		name="nombre" id="nombre"
		placeholder="nombre"
		required
	 />
	 <br />
	<input type="text"
		name="password" id="password"
		placeholder="Contraseña"
		required
	 />
	 <br />
	 <button type="submit"> Enviar</button>
</form>

<%@include file="includes/footer.jsp" %>