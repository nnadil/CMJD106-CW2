/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.custom;

import edu.ijse.service.SuperService;

/**
 *
 * @author MSI
 */
public interface CustomerService extends SuperService{
    boolean searchCustomer(String id) throws Exception;
    String registerCustomer(String id,String name,String email)throws Exception;
}
