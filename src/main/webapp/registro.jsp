<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


<div class="row justify-content-center">
	<div class="col-12 col-md-8 col-lg-6">
		<div class="card mt-3">
			<div class="card-body">
				<h4 class="card-title text-center"> Registro </h4>
				<form action="registrar" method="post" class="login">
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