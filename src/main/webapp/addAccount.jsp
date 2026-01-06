<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Add Account Record</h3>
	<form action="MainServlet" method="post">
		<input type="hidden" name="operation" value="newRecord" /> Customer
		Name: <input type="text" name="customerName" /><br>
		<br> Account Type: <input type="text" name="accountType" /><br>
		<br> Opening Date: <input type="date" name="openingDate" /><br>
		<br> Balance: <input type="text" name="balance" /><br>
		<br> Contact: <input type="text" name="contact" /><br>
		<br> Remarks: <input type="text" name="remarks" /><br>
		<br> <input type="submit" value="Add Account" />
	</form>
</body>
</html>