<!-- Indica en caso de error cual es la pagina a la que tiene que redirigir -->
<%@ page errorPage="error.jsp" %>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>



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

				<c:if test="${not empty mensaje }">
					<div class="alert alert-danger">
						<c:forEach items="${mensaje}" var="men">
							<p>${men}</p>
						</c:forEach>
					</div>
				</c:if>
				<form action="formulario" method="post" class="login">
					<div class="form-group">
						<input type="text"
							name="nombre" id="nombre"
							placeholder="Nombre"
							class="form-control"
							required
							value="${nombre}"
						 />
					 </div>
					 <div class="form-group">
						<input type="text"
							name="email" id="email"
							placeholder="ejemplo@gmail.com"
							class="form-control"
							required
							value="${email}"
						 />
					 </div>

					 <div class="custom-control custom-checkbox">
  <input type="checkbox" class="custom-control-input" id="customCheck1">
  <label class="custom-control-label" for="customCheck1">Check this custom checkbox</label>
</div>

					<p>Deportes favoritos:</p>
					<c:forEach items="${applicationScope.formDeportes}" var="deporte">
						<div class="custom-control custom-checkbox">
							<c:set var="key" value="|${deporte.key}|"></c:set>
							<input ${( fn:contains(deportes, key)) ? "checked" : ""} class="custom-control-input" type="checkbox" name="deportes" value="${deporte.key}" id="${deporte.key}">
							<label class="custom-control-label" for="${deporte.key}"> ${deporte.value }</label>
						</div>
					</c:forEach>

					<label>Sexo:</label>
					<select name="sexo" id="sexo">
						<option value="H" ${sexo eq H ? "selected" : ""}>Hombre</option>
						<option value="M" ${sexo eq M ? "selected" : ""}>Mujer</option>
						<option value="O" ${sexo eq O ? "selected" : ""}>Otro</option>
					</select>

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