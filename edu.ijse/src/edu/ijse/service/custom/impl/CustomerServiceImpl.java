/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dao.CustomerDao;
import edu.ijse.dao.DaoFactory;
import edu.ijse.dto.CustomerDto;
import edu.ijse.entity.CustomerEntity;
import edu.ijse.service.custom.CustomerService;

/**
 *
 * @author MSI
 */
public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao=(CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public boolean searchCustomer(String id) throws Exception {
        CustomerEntity customerEntity=customerDao.get(id);
        CustomerDto customerDto= new CustomerDto(customerEntity.getMemberId(),customerEntity.getMemberName(),customerEntity.getEmail());
        if(id.equals(customerDto.getMemberId())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String registerCustomer(String id, String name, String email) throws Exception {
        CustomerEntity customerEntity=new CustomerEntity(id,name,email);
        return customerDao.save(customerEntity)?"Successfully Registered":"Failed";
    }

    
}
