<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h3>View All Account Records</h3>
	<form action="MainServlet" method="post">
		<input type="hidden" name="operation" value="viewAllRecords" /> <input
			type="submit" value="View All Records" />
	</form>
</body>
</html>
