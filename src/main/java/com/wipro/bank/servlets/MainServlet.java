package com.wipro.bank.servlets;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.wipro.bank.bean.BankBean;
import com.wipro.bank.service.Administrator;
public class MainServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("operation");
		Administrator admin = new Administrator();
		try {
			if ("newRecord".equals(op)) {
				BankBean b = new BankBean();
				b.setCustomerName(request.getParameter("customerName"));
				b.setAccountType(request.getParameter("accountType"));
				b.setOpeningDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("openingDate")));
				b.setBalance(Integer.parseInt(request.getParameter("balance")));
				b.setContact(request.getParameter("contact"));
				b.setRemarks(request.getParameter("remarks"));
				String result = admin.addRecord(b);
				if ("FAIL".equals(result) || result.contains("INVALID"))
					response.sendRedirect("error.html");
				else
					response.sendRedirect("success.html");
			}
			else if ("viewRecord".equals(op)) {
				BankBean b = admin.viewRecord(request.getParameter("customerName"),
						new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("openingDate")));
				request.setAttribute("bean", b);
				request.getRequestDispatcher("displayAccount.jsp").forward(request, response);
			}
			else if ("viewAllRecords".equals(op)) {
				List<BankBean> list = admin.viewAllRecords();
				request.setAttribute("list", list);
				request.getRequestDispatcher("displayAllAccounts.jsp").forward(request, response);
			}
		} catch (Exception e) {
			response.sendRedirect("error.html");
		}
	}
}
