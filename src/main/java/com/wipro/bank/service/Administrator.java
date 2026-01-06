package com.wipro.bank.service;
import java.util.*;
import com.wipro.bank.bean.BankBean;
import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.util.InvalidInputException;
public class Administrator {
    BankDAO dao = new BankDAO();
    public String addRecord(BankBean b) {
        try {
            if (b == null || b.getCustomerName() == null || b.getOpeningDate() == null)
                throw new InvalidInputException();
            if (b.getCustomerName().length() < 2)
                return "INVALID CUSTOMER NAME";
            if (dao.recordExists(b.getCustomerName(), b.getOpeningDate()))
                return "ALREADY EXISTS";
            String id = dao.generateRecordID(b.getCustomerName(), b.getOpeningDate());
            b.setRecordId(id);
            return dao.createRecord(b);
        } catch (Exception e) {
            return "INVALID INPUT";
        }
    }
    public BankBean viewRecord(String name, Date date) {
        return dao.fetchRecord(name, date);
    }
    public List<BankBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}
