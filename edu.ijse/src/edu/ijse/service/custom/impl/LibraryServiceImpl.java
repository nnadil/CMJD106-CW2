/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.custom.BookDao;
import edu.ijse.dto.BookDto;
import edu.ijse.dto.BorrowingsDto;
import edu.ijse.entity.BookEntity;
import edu.ijse.entity.OrderEntity;
import edu.ijse.service.custom.LibraryService;
import java.util.ArrayList;
import edu.ijse.dao.custom.BorrwingsDao;

/**
 *
 * @author MSI
 */
public class LibraryServiceImpl implements LibraryService{
    private BorrwingsDao libraryDao=(BorrwingsDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.LIBRARY);
    private BookDao bookDao=(BookDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.Book);
    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities=bookDao.getAll();
        if(bookEntities!=null && !bookEntities.isEmpty()){
            ArrayList<BookDto> bookDtos=new ArrayList<>();
            for (BookEntity bookEntity : bookEntities) {
                bookDtos.add(getBookDto(bookEntity));
            }
            return bookDtos;
        }
        return null;
    }

    public BookDto getBookDto(BookEntity bookEntity){
        return new BookDto(bookEntity.getId(),
                bookEntity.getName(),
                bookEntity.getCategoryId(),
                bookEntity.getAuthor(),bookEntity.getPrice());
    }
    
    public BorrowingsDto getLibraryDto(OrderEntity libraryEntity){
        return new BorrowingsDto(
                libraryEntity.getBorrowindId(),
                libraryEntity.getMemberId(),
                libraryEntity.getBookId(),
                libraryEntity.getBorrowDate(),
                libraryEntity.getDueDate());
    }
    
    @Override
    public BorrowingsDto searchBook(String memberId,String bookId) throws Exception {
        OrderEntity libraryEntity=libraryDao.get(memberId,bookId);
        return getLibraryDto(libraryEntity);
    }

    @Override
    public BookDto getBookDto(String bookId) throws Exception {
        BookEntity bookEntity=bookDao.get(bookId);
        return getBookDto(bookEntity);
    }

}
