/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dao.DaoFactory;
import java.sql.Connection;
import edu.ijse.dao.custom.BorrwingsDao;
import edu.ijse.dao.custom.ReturnBookDao;
import edu.ijse.db.DBConnection;
import edu.ijse.dto.BorrowingsDto;
import edu.ijse.entity.OrderEntity;
import edu.ijse.entity.ReturnEntity;
import edu.ijse.service.custom.OrderService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class OrderServiceImpl implements OrderService{
    private BorrwingsDao borrowingsDao=(BorrwingsDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.LIBRARY);
    private ReturnBookDao returnBookDao=(ReturnBookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    @Override
    public String placeOrder(ArrayList<BorrowingsDto> borrowingDtos) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean isBorrowingsSaved=true;
            for (BorrowingsDto borrowingDto : borrowingDtos) {
                    OrderEntity borrowingEntity=new OrderEntity(
                    borrowingDto.getBorrowindId(),
                    borrowingDto.getMemberId(),
                    borrowingDto.getBookId(),
                    borrowingDto.getBorrowDate(),
                    borrowingDto.getDueDate());
                    if(!borrowingsDao.update(borrowingEntity)){
                        isBorrowingsSaved=false;
                    }
            }
            if(isBorrowingsSaved){
                boolean isReturnBookUpdated=true;
                for (BorrowingsDto borrowingDto : borrowingDtos) {
                    ReturnEntity returnEntity=new ReturnEntity(
                    borrowingDto.getBorrowindId(),
                    borrowingDto.getMemberId(),0.0);
                    if(!returnBookDao.update(returnEntity)){
                        isReturnBookUpdated=false;
                    }
                }
                if(isReturnBookUpdated){
                    connection.commit();
                    return "Success";
                }else{
                    connection.rollback();
                    return "Fail";
                }
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return "Order Saved Error";
        }finally{
            connection.setAutoCommit(true);
        }
        return null;
    }

    @Override
    public String updateFine(Double fine,String borrowingId,String memberId) throws Exception {
        return returnBookDao.updateFine(fine, borrowingId, memberId)?"Success":"Fail";
    }
    
}
