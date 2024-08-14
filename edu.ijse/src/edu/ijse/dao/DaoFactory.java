/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao;

import edu.ijse.dao.custom.impl.BookDaoImpl;
import edu.ijse.dao.custom.impl.BorrowingsDaoImpl;
import edu.ijse.dao.custom.impl.CategoryDaoImpl;
import edu.ijse.dao.custom.impl.CustomerDaoImpl;
import edu.ijse.dao.custom.impl.ReturnBookDaoImpl;

/**
 *
 * @author MSI
 */
public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {}
    
    public static DaoFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DaoFactory();
        }
        return daoFactory;

    }
    
    public SuperDao getDao(DaoType type){
        switch(type){
            case Book:
                return new BookDaoImpl();
            case LIBRARY:
                return new BorrowingsDaoImpl();
            case ORDER:
                return new ReturnBookDaoImpl();
            case CATEGORY:
                return new CategoryDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoType{
        Book,LIBRARY,ORDER,CATEGORY,CUSTOMER
    }
    
    
}
