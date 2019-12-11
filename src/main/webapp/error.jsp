<%@ page isErrorPage="true" %>

<h1> Error 500 </h1>

<p>Causa => <%=exception.getCause() %></p>
<p>Mensaje => <%=exception.getMessage() %></p>

<pre>
	<%
	  exception.printStackTrace(new java.io.PrintWriter(out));
	%>
</pre>