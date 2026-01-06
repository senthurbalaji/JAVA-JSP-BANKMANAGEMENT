<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wipro.bank.bean.BankBean"%>
<!DOCTYPE html>
<html>
<body>
	<%
    BankBean b = (BankBean) request.getAttribute("bean");
    if (b == null) {
%>
	<h3>No matching records exists! Please try again!</h3>
	<%
    } else {
%>
	<h3>Account Details</h3>
	Record ID:
	<%= b.getRecordId() %><br> Customer Name:
	<%= b.getCustomerName() %><br> Account Type:
	<%= b.getAccountType() %><br> Opening Date:
	<%= b.getOpeningDate() %><br> Balance:
	<%= b.getBalance() %><br> Contact:
	<%= b.getContact() %><br> Remarks:
	<%= b.getRemarks() %><br>
	<%
    }
%>
</body>
</html>