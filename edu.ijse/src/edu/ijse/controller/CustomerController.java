/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.controller;

import edu.ijse.service.ServiceFactory;
import edu.ijse.service.custom.CustomerService;

/**
 *
 * @author MSI
 */
public class CustomerController {
    CustomerService customerService=(CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    
    public boolean searchCustomer(String id) throws Exception{
        return customerService.searchCustomer(id);
    }
    
    public String registerCustomer(String id,String name,String email) throws Exception{
        return customerService.registerCustomer(id,name,email);
    }
}
