<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css">


<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f5f5f5;
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<script>
	$(function() {

		$('#addNewBook').button();
		$('#cancel').button();

		$('#cancel').click(function() {
			document.location.href = "/Spring_Assignment_MVC/home";
		});

	})
</script>

<title>Books and Subjects Management</title>
</head>
<body>
	<h2>Add/Edit Book</h2>	
	<div id="addNewBook">
		<form:form method="POST" action="/Spring_Assignment_MVC/saveBook?mode=${mode}&updateBookID=${updateBookID}"
			modelAttribute="book">
			<table>
				<tr>
					<td><form:label path="bookId">ID</form:label></td>
					<td><form:input path="bookId" /></td>
				</tr>
				<tr>
					<td><form:label path="title">Title</form:label></td>
					<td><form:input path="title" /></td>
				</tr>
				<tr>
					<td><form:label path="price">
                      Price</form:label></td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td><form:label path="volume">
                      Volume</form:label></td>
					<td><form:input path="volume" /></td>
				</tr>
				<tr>
					<td><form:label path="publishDate">
                      Publish Date(MM-dd-yyyy)</form:label></td>
					<td><form:input path="publishDate" /></td>
				</tr> 
			</table>
			<table>
				<tr>
					<td><input type="submit" value="Save" id="addNewBook" /></td>
					<td><input type="button" value="Cancel" id="cancel" /></td>
				</tr>
			</table>
		</form:form>

	</div>

</body>
</html>