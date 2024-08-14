/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.custom.impl;

import edu.ijse.dao.CrudUtil;
import edu.ijse.dao.custom.ReturnBookDao;
import edu.ijse.entity.OrderEntity;
import edu.ijse.entity.ReturnEntity;

/**
 *
 * @author MSI
 */
public class ReturnBookDaoImpl implements ReturnBookDao{

    @Override
    public boolean update(ReturnEntity t) throws Exception {
        return  CrudUtil.executeUpdate("INSERT INTO returnBook VALUES(?,?,?)", t.getBorrowingId(),t.getMemberId(),t.getFine());
    }

    @Override
    public boolean updateFine(Double fine,String borrowingId,String memberId) throws Exception {
        return CrudUtil.executeUpdate("UPDATE returnbook SET Fine=? WHERE Borrowing_Id=? AND Member_Id=?", fine,borrowingId,memberId);
    }
    
}
