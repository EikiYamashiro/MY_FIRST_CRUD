<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,br.edu.insper.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.container-principal {
	background-color: #FF6666;
	display: flex;
	padding: 40px;
	justify-content: center;
}

.container-forms {
	background-color: #439c8d;
	widht: 500px;
	heigh: 500px;
}


</style>

<title>Editar Tarefa</title>
</head>
<body>
	<div class="container-principal">
	<form class="container-forms" action="altera" method="post">
		<table>
			<tr>
				<td class="form-group">
			    <label>Título</label>
			    <td><input type="text" placeholder="Título da Task" class="form-control" name="titulo" value='${param.titulo}'></td>
			</tr>
			<tr>
				<td>Prioridade</td>
				<td><input type="text" placeholder="Prioridade (0 - 10)" class="form-control" name="prioridade" value='${param.prioridade}'></td>
			</tr>
			<tr>
				<td>Descrição</td>
				<td><input type="text" placeholder="Descrição da Task" class="form-control" name="descricao" value='${param.descricao}'></td>
			</tr>
			<tr>
				<td>Data de Entrega</td>
				<td><input type="text" placeholder="dd/mm/aaaa" class="form-control" name="entrega" value='${param.entrega}'></td>
			</tr>
			<tr>
				<td>Área</td>
				<td class="custom-control custom-radio custom-control-inline">
			      <input type="radio" class="toggle" name="area" value="RH">
				  <label class="custom-control-label">RH</label>
			        
			      <input type="radio" class="toggle" name="area" value="Software">
				  <label class="custom-control-label">Software</label>
			        
				  <input type="radio" class="toggle" name="area" value="Hardware">
				  <label class="custom-control-label">Hardware</label>
			        	     
			    </td>
			
			</tr>
			<tr>
			<td><input type="hidden" name="id" value="${param.id}">
			</td>
				<tr>
			<td></td>
			<td><input type="submit" value="OK"></td>
			</tr>
		</table>
	</form>
	</div>
	
</body>
</html>