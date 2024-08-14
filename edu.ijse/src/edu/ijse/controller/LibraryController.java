/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.controller;

import edu.ijse.dto.BookDto;
import edu.ijse.dto.BorrowingsDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.custom.LibraryService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class LibraryController {
    private LibraryService libraryService=(LibraryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LIBRARY);
    
    public ArrayList<BookDto> getAll() throws Exception{
        return libraryService.getAll();
    }
    public BorrowingsDto searchBorrowing(String memberId,String bookId) throws Exception{
        return libraryService.searchBook(memberId,bookId);
    }
    public BookDto getBookDto(String bookId) throws Exception{
        return libraryService.getBookDto(bookId);
    }
}
