/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service;

import edu.ijse.service.custom.impl.BookServiceImpl;
import edu.ijse.service.custom.impl.CategoryServiceImpl;
import edu.ijse.service.custom.impl.CustomerServiceImpl;
import edu.ijse.service.custom.impl.LibraryServiceImpl;
import edu.ijse.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author MSI
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        if(serviceFactory==null){
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }
    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case BOOK:
                return new BookServiceImpl();
            case LIBRARY:
                return new LibraryServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            case CATEGORY:
                return new CategoryServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            default:
                return null;
        }
    }
    public enum ServiceType{
        BOOK,LIBRARY,ORDER,CATEGORY,CUSTOMER
    }
    
    
}
