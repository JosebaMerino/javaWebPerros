<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/navigation.jsp" %>

<div class="row">
	<div class="col">
		<div class="card mt-3">
			<div class="card-body">
				<h1>Perros</h1>

				<form action="perros" method="post" class="form-inline">
					<div class="form-group">
						<input class="form-control" name="nombre" placeholder="nombre del perro" required autofocus>
					</div>

					<input class="btn btn-primary ml-1" type="submit" value="A�adir">
				</form>

				<hr />


				<%
				ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");
				%>
				<table class="table mt-3">
					<thead>
						<th>Id</th>
						<th>Nombre</th>
						<th>Imagen</th>
						<th></th>
					</thead>
					<tfoot>
						<th>Id</th>
						<th>Nombre</th>
						<th>Imagen</th>
						<th></th>
					</tfoot>
					<tbody>
						<% for ( Perro p :  perros ){ %>
							<tr>
								<td><%=p.getId()%></td>
								<td><%=p.getNombre()%></td>
								<td><img src="<%=p.getFoto()%>" alt="" width="20px" height="20px" /></td>
								<td><a href="perros?adoptar&id=<%=p.getId()%>"> Adoptar</a></td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</div>
			<!-- .card-body -->
		</div>
		<!-- .card -->
	</div>
	<!-- .col -->
</div>
<!-- .row -->



<%@include file="/includes/footer.jsp" %>