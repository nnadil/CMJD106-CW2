/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.custom;

import edu.ijse.dto.BookDto;
import edu.ijse.dto.BorrowingsDto;
import edu.ijse.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public interface OrderService extends SuperService{
    String placeOrder(ArrayList<BorrowingsDto> borrowindDtos)throws Exception;
    String updateFine(Double fine,String borrowingId,String memberId)throws Exception;
}
