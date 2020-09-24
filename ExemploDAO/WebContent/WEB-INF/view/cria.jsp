<head>
<meta charset="ISO-8859-1">
<title>Tarefa</title>
</head>

<body>
	<jsp:useBean id="dao" class="br.edu.insper.model.DAO"/>
	<header>
	</header>
	<form action="cria" method="post">
		<table>
			<tr>
				<td>Titulo</td>
				<td><input type="text" name="titulo"></td>
			</tr>
			<tr>
				<td>Prioridade</td>
				<td><input type="text" name="prioridade"></td>
			</tr>
			<tr>
				<td>Descrição</td>
				<td><input type="text" name="descricao"></td>
			</tr>
			<tr>
				<td>Data de Entrega</td>
				<td><input type="text" name="entrega"></td>
			</tr>
			<tr>
				<td>Área</td>
				<td><input type="text" name="area"></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="OK"></td>
			</tr>
		</table>
	</form>
	<br />
	

	
</body>
</html>