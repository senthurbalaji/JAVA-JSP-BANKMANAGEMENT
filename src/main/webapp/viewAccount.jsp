<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h3>View Account Record</h3>

	<form action="MainServlet" method="post">
		<input type="hidden" name="operation" value="viewRecord" /> Customer
		Name: <input type="text" name="customerName" /><br>
		<br> Opening Date: <input type="date" name="openingDate" /><br>
		<br> <input type="submit" value="View Record" />
	</form>

</body>
</html>
