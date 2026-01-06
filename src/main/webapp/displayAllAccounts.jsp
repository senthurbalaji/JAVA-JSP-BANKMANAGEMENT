<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.wipro.bank.bean.BankBean"%>
<!DOCTYPE html>
<html>
<body>
	<%
    List<BankBean> list = (List<BankBean>) request.getAttribute("list");
    if (list == null || list.isEmpty()) {
%>
	<h3>No records available!</h3>
	<%
    } else {
%>
	<h3>All Bank Accounts</h3>
	<table border="1">
		<tr>
			<th>Record ID</th>
			<th>Customer Name</th>
			<th>Account Type</th>
			<th>Opening Date</th>
			<th>Balance</th>
			<th>Contact</th>
			<th>Remarks</th>
		</tr>
		<%
        for (BankBean b : list) {
%>
		<tr>
			<td><%= b.getRecordId() %></td>
			<td><%= b.getCustomerName() %></td>
			<td><%= b.getAccountType() %></td>
			<td><%= b.getOpeningDate() %></td>
			<td><%= b.getBalance() %></td>
			<td><%= b.getContact() %></td>
			<td><%= b.getRemarks() %></td>
		</tr>
		<%
        }
%>
	</table>
	<%
    }
%>
</body>
</html>