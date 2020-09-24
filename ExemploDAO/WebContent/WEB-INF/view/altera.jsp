<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,br.edu.insper.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Tarefa</title>
</head>
<body>
	<form action="altera" method="post">
		Titulo: <input type='text' name='titulo' value='${param.titulo}'><br>
		Prioridade: <input type='text' name='prioridade' value='${param.prioridade}'><br>
		Descrição: <input type='text' name='descricao' value='${param.descricao}'><br>
		Data de Entrega: <input type='text' name='entrega' value='${param.entrega}'><br>
		Área: <input type='text' name='entrega' value='${param.area}'><br>
		<input type='hidden' name='id' value='${param.id}'>
		<input type='submit' value='atualizar'>
	</form>
</body>
</html>