/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.controller;

import edu.ijse.dto.BorrowingsDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.custom.OrderService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class OrderController {
    private OrderService orderService=(OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    public String placeOrder(ArrayList<BorrowingsDto> borrowingDtos)throws Exception{
        return orderService.placeOrder(borrowingDtos);
    }
    public String updateFine(Double fine,String borrowingId,String memberId) throws Exception{
        return orderService.updateFine(fine, borrowingId, memberId);
    }
}
