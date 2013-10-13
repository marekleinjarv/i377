<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add</title>
<style type="text/css">
@import url("http://ci.itcollege.ee//part3example/static/style.css");
</style>
</head>
<body>
	<ul id="menu">
		<li><a href="Search" id="menu_Search">Otsi</a></li>
		<li><a href="Add" id="menu_Add">Lisa</a></li>
		<li><a href="ClearData" id="menu_ClearData">Tühjenda</a></li>
		<li><a href="InsertSamples" id="menu_InsertData">Sisesta
				näidisandmed</a></li>
	</ul>
	<br />
	<br />
	<br />
	<form method="post" action="Add">
		<table class="formTable" id="formTable">
			<tbody>
				<tr>
					<td>Nimi:</td>
					<td><input name="name" id="nameBox" /></td>
				</tr>
				<tr>
					<td>Kood:</td>
					<td><input name="code" id="codeBox" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><br /> <input type="submit"
						value="Lisa" id="addButton" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>