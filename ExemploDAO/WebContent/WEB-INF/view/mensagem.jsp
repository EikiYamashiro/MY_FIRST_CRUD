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
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

.custom {
	display: flex;
	justify-content: space-between;
    width: 60px;
    height: 30px;
    font-size: 5px;
}

.header  {
	display: flex;
    align-items: center;
    justify-content: center;
	background-color: #0c6657;
	font-size: 40px;
	color: white;
}

#myInput {
  width: 300px;
  font-size: 22px;
}

#myUL {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

#myUL li a {
  display: flex;
  justify-content: space-between;
  width: 240px;
  padding: 12px;
  text-decoration: none;
  font-size: 15px;
  color: white;
}

.container-principal{
	height: 700px;
	background-color: #3d3632;
	display: flex;
}


.search {
	display: flex;
	flex-direction: row;
	margin-bottom: 30px;
}

.search-box {
	border: black;
	background-color: #3d3632;
	padding: 30px;
	
}

.task-individual {
	display: flex;
}

.color-task {
	background-color: #439c8d;
    width: 240px;
    height: 300px;
    margin-right: 30px;
    border: 2px solid white;
 	border-radius: 25px;
}

.titulo-task {
	background-color: #FF6666;
	width: 243px;
	font-size: 20px;
	border: 2px solid white;
 	border-radius: 25px;
}

.prioridade {
	background-color: #FFBE67;
	border: 2px solid #FFBE67;
 	border-radius: 10px;
 	font-size: 20px;
}

.remove{
	margin-left: 170px;
}

.sub-header{
	display: flex;
	flex-direction: column;
	padding-right: 50px;
}

.margin-button{
	margin-right: 50px;
}

.obs{
	background-color: #7D666E;
	color: white;
	height: 180px;
	padding: 10px;
}

</style>
<title>Interface Tasks Entidade X</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
	Projeto 1 - Eiki Yamashiro
</div>

<div class="container-principal">
<div class="search-box">
<div class="sub-header">
<div class="btn-group">
  <button type="button" class="btn btn-info dropdown-toggle margin-button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Filtre por Área...
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="ListByRH">RH</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="ListBySoftware">Software</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="ListByHardware">Hardware</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="Lista">Todos</a>
  </div>
  
  <p><a class="btn btn-success" href="http://localhost:8080/ExemploDAO/cria" role="button" >
+ ADICIONAR
</a></p>

</div>
  
</div>


<div>
<input class="search" id="myInput" type="text" onkeyup="myFunction()" placeholder="Pesquisar">
<ul class="task-individual" id="myUL">
<c:forEach var="tasks" items="${tasks}">
	<li class="color-task">
	<form action="altera" method="get">
	<input type="hidden" name='titulo' value='${tasks.titulo}'>
	<input type="hidden" name='prioridade' value='${tasks.prioridade}'>
	<input type="hidden" name='entrega' value='${tasks.entrega}'>
	<input type="hidden" name='descricao' value='${tasks.descricao}'>
	<input type="hidden" name='area' value='${tasks.area}'>
	<input type="hidden" name='id' value='${tasks.id}'>
	<a class="titulo-task">${tasks.titulo}<input class="btn btn-primary custom" type="submit" value='editar'></a>
	<a>Descrição: ${tasks.descricao}</a>
	<a>Área: ${tasks.area}</a>
	<a>Data de Entrega: ${tasks.entrega}</a>
	<a class="prioridade">Prioridade: ${tasks.prioridade} / 10</a>
	</form>
	<form action="remove" method="post">
	<input type="hidden" name='titulo' value='${tasks.titulo}'>
	<input class="btn btn-danger remove" type="submit" value="remover">
	</form>
	</li>
</c:forEach>
</ul>
</div>
</div>



</div>

<div class="obs">
	<p>OBSERVAÇÕES: </p>
	<p>As tasks são ordenadas com base na prioridade, quanto mais para esquerda, maior o valor da prioridade.</p>
	<p>A barra de pesquisa busca TÍTULOS!</p>
	<p>Considerei uma entidade que possui apenas três áreas: RH, Software e Hardware</p>
</div>
<script>
function myFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}
</script>


	</body>
</html>