/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.custom;

import edu.ijse.dto.BookDto;
import edu.ijse.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public interface BookService extends SuperService{
    String save(BookDto manageBookService)throws Exception;
    String update(BookDto manageBookService) throws Exception;
    String delete(String id)throws Exception;
    ArrayList<BookDto> getAll() throws Exception;
    BookDto searchBook(String Id)throws Exception;
}
