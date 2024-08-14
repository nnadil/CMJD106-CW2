/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.custom.impl;

import edu.ijse.dao.CrudUtil;
import edu.ijse.entity.OrderEntity;
import java.sql.ResultSet;
import edu.ijse.dao.custom.BorrwingsDao;

/**
 *
 * @author MSI
 */
public class BorrowingsDaoImpl implements BorrwingsDao{

    @Override
    public OrderEntity get(String memberId,String bookId) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM borrowings WHERE Book_Id=? AND Member_Id=?",bookId,memberId );
        if(rst.next()){
            OrderEntity libraryEntity=new OrderEntity(
                    rst.getString("Borrowing_Id"),
                    rst.getString("Member_Id"),
                    rst.getString("Book_Id"),
                    rst.getString("Borrow_Date"),
                    rst.getString("Due_Date"));
            return libraryEntity;
            
        }
        return null;
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO borrowings VALUES(?,?,?,?,?)", 
                t.getBorrowindId(),
                t.getMemberId(),
                t.getBookId(),
                t.getBorrowDate(),
                t.getDueDate());
    }
    
}
