<!-- /WEB-INF/jsp/getInfos.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored ="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC sample</title>
</head>
<body>
<br/><b>Infos:</b><br/>
<% 
	final String path=request.getContextPath();
  	final String infos=(String)request.getAttribute("infos");
 %>
<h1>
<% if( infos!=null && ! "".equals(infos) ) { %>
 <%=infos%>
 <% }else{%>
 <%="Votre environnement ne semble pas être OK" %>
 <%}%>
</h1>
</body>
</html>