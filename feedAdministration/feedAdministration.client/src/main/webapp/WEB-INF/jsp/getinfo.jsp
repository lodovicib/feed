<!-- /WEB-INF/jsp/getInfos.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored ="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=2.0">

	<title>Feed Administration</title>
	<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="css/shCore.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/shCore.js"></script>
	<script type="text/javascript" src="js/demo.js"></script>
	<script type="text/javascript">

$(document).ready(function() {
	$('#example').dataTable( {
		"pagingType": "full_numbers"
	} );
} );

	</script>
	
	
</head>
<body>
<br/><b>Infos:</b><br/>
<% 
	final String path=request.getContextPath();
  	final String infos=(String)request.getAttribute("infos");
  	final int count =  Integer.valueOf(((String)request.getAttribute("count")));
 %>
<h1>
<% if( infos!=null && ! "".equals(infos) ) { %>
 <%=infos%>
 <% }else{%>
 <%="Votre environnement ne semble pas être OK" %>
 <%}%>
</h1>
<body class="dt-example">
	<div class="container">
		<section>
			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Status</th>
						<th>Message</th>
						<th>Date D'ajout</th>
					</tr>
				</thead>

				<!-- <tfoot>
					<tr>
						<th>Name</th>
						<th>Status</th>
						<th>Message</th>
						<th>Date D'ajout</th>
					</tr>
				</tfoot> -->

				<tbody>
				<% for( int i=0; i <  count; i++) { %>
					<%=(String)request.getAttribute("line"+i)%>
				<%} %>
				</tbody>
			</table>
		</section>
	</div>
</body>
</html>