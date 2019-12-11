<%@include file="/includes/header.jsp" %>
<%@include file="/includes/navigation.jsp" %>

<h1>Hola soy index de private</h1>
<p> Solo pueden entrar gente que este logeada</p>

${atributoServlet}

${usuario.nombre}



<%@include file="/includes/footer.jsp" %>