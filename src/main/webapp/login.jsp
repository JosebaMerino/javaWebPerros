<!-- Indica en caso de error cual es la pagina a la que tiene que redirigir -->
<%@ page errorPage="error.jsp" %>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


${ param.mensaje }

<%
	// Descomentar estas lineas para que lance un error
/*
	Object o = null;
	o.toString(); */

%>

<div class="row justify-content-center">
	<div class="col-12 col-md-8 col-lg-6">
		<div class="card mt-3">
			<div class="card-body">
				<h4 class="card-title text-center"> Login </h4>
				<form action="login" method="post" class="login">
					<div class="form-group">
						<input type="text"
							name="nombre" id="nombre"
							placeholder="nombre"
							class="form-control"
							required
						 />
					 </div>
					 <div class="form-group">
						<input type="text"
							name="password" id="password"
							placeholder="Contraseña"
							class="form-control"
							required
						 />
					 </div>
					 <button class="btn btn-block btn-outline-primary" type="submit"> Enviar</button>
				</form>
			</div>
			<!-- .card-body -->
		</div>
		<!-- .card -->
	</div>
	<!-- .col -->
</div>
<!-- .row -->

<%@include file="includes/footer.jsp" %>