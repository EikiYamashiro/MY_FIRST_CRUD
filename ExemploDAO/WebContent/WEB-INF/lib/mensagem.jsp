<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.insper.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Lista pessoas</title>
	</head>
	<body>
<table border='1'>
<c:forEach var="pessoa" items="${pessoas}">
<tr>
<td>${pessoa.nome}</td>
<td>${pessa.idade}</td>
</tr>
</c:forEach>
</table>
	</body>
</html>