package com.wipro.bank.dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.bank.bean.BankBean;
import com.wipro.bank.util.DBUtil;

public class BankDAO {

    public String generateRecordID(String customerName, Date openingDate) {
        String id = "";
        try {
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            String datePart = df.format(openingDate);
            String namePart = customerName.substring(0, 2).toUpperCase();

            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT BANKACCOUNT_SEQ.NEXTVAL FROM dual"
            );
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = datePart + namePart + rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean recordExists(String name, Date date) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT 1 FROM BANKACCOUNT_TB WHERE CUSTOMERNAME=? AND OPENING_DATE=?"
            );
            ps.setString(1, name);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    public String createRecord(BankBean b) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO BANKACCOUNT_TB VALUES (?,?,?,?,?,?,?)"
            );
            ps.setString(1, b.getRecordId());
            ps.setString(2, b.getCustomerName());
            ps.setString(3, b.getAccountType());
            ps.setDate(4, new java.sql.Date(b.getOpeningDate().getTime()));
            ps.setInt(5, b.getBalance());
            ps.setString(6, b.getContact());
            ps.setString(7, b.getRemarks());

            int i = ps.executeUpdate();
            return i > 0 ? b.getRecordId() : "FAIL";
        } catch (Exception e) {
            return "FAIL";
        }
    }

    public BankBean fetchRecord(String name, Date date) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM BANKACCOUNT_TB WHERE CUSTOMERNAME=? AND OPENING_DATE=?"
            );
            ps.setString(1, name);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BankBean b = new BankBean();
                b.setRecordId(rs.getString(1));
                b.setCustomerName(rs.getString(2));
                b.setAccountType(rs.getString(3));
                b.setOpeningDate(rs.getDate(4));
                b.setBalance(rs.getInt(5));
                b.setContact(rs.getString(6));
                b.setRemarks(rs.getString(7));
                return b;
            }
        } catch (Exception e) {}
        return null;
    }

    public List<BankBean> fetchAllRecords() {
        List<BankBean> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM BANKACCOUNT_TB"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BankBean b = new BankBean();
                b.setRecordId(rs.getString(1));
                b.setCustomerName(rs.getString(2));
                b.setAccountType(rs.getString(3));
                b.setOpeningDate(rs.getDate(4));
                b.setBalance(rs.getInt(5));
                b.setContact(rs.getString(6));
                b.setRemarks(rs.getString(7));
                list.add(b);
            }
        } catch (Exception e) {}
        return list;
    }
}
