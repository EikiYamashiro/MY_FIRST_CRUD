<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.insper.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Geral</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<div class="btn-group">
  <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Filtre por Área:
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="ListByRH">RH</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="ListBySoftware">Software</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="ListByHardware">Hardware</a>
  </div>
</div>

	<body>

<table class="table" border='1'>
<thead class="thead-dark">
<tr>
<th scope="col">ID</th>
<th scope="col">Titulo</th>
<th scope="col">Prioridade</th>
<th scope="col">Descricao</th>
<th scope="col">Entrega</th>
<th scope="col">Área</th>
</tr>
</thead>
<c:forEach var="tasks" items="${tasks}">
<tr>
<td>${tasks.id}</td>
<td>${tasks.titulo}</td>
<td>${tasks.prioridade}</td>
<td>${tasks.descricao}</td>
<td>${tasks.entrega}</td>
<td>${tasks.area}</td>
<td><form action="remove" method="post">
<input type="hidden" name='titulo' value='${tasks.titulo}'>
<input class="btn btn-danger" type="submit" value="remover">
</form>
</td>
<td><form action="altera" method="get">
<input type="hidden" name='titulo' value='${tasks.titulo}'>
<input type="hidden" name='prioridade' value='${tasks.prioridade}'>
<input type="hidden" name='entrega' value='${tasks.entrega}'>
<input type="hidden" name='descricao' value='${tasks.descricao}'>
<input type="hidden" name='area' value='${tasks.area}'>
<input type="hidden" name='id' value='${tasks.id}'>
<input class="btn btn-warning" type="submit" value="editar">
</form>
</td>
</tr>
</c:forEach>
</table>

<a class="btn btn-success" href="http://localhost:8080/ExemploDAO/cria" role="button" >
+ ADICIONAR
</a>
	</body>
</html>