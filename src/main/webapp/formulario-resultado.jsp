<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


${ deportes }
${ nombre }

<c:forEach items="${deportes }" var="deporte" >
	<p> ${deporte }</p>
</c:forEach>

${ email }


<%@include file="includes/footer.jsp" %>