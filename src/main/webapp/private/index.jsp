<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/navigation.jsp" %>

<div class="container mt-3">
	<div class="row">
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h1>Hola soy index de private</h1>
					<p> Solo pueden entrar gente que este logeada</p>

					${atributoServlet}

					${usuario.nombre}

					<c:if test="${'admin' eq usuario.nombre}">
						Eres administrador
						<p>
							${numeroUsuariosConectados}
						</p>
						<p>
							* Numero de accesos indebidos: ${numAccesosIndebidos}
						</p>
						<p>
							IPS
							<ul>
								<c:forEach items="${IPs}"  var="ip">
								<li> ${ip} </li>
								</c:forEach>
							</ul>
						</p>
					</c:if>

				</div>
			</div>
		</div>
	</div>
</div>




<%@include file="/includes/footer.jsp" %>