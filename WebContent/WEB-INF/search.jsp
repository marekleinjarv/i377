<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="ml"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
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
	<form method="get" action="Search">
		<input name="searchString" id="searchStringBox" value="" /> <input
			type="submit" id="filterButton" value="Filtreeri" /> <br /> <br />
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Nimi</th>
					<th scope="col">Kood</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<ml:forEach var="item" items="${searchResults}">
					<tr>
						<td>
							<div id="row_${item.code}">${item.name}</div>
						</td>
						<td>${item.code}</td>
						<td><a id="delete_${item.code}" href="Delete?&id=${item.id}">Kustuta</a>
						</td>
					</tr>
				</ml:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>