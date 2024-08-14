/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.custom.BookDao;
import edu.ijse.dto.BookDto;
import edu.ijse.entity.BookEntity;
import edu.ijse.service.custom.BookService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class BookServiceImpl implements BookService{
    private BookDao bookDao= (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.Book);
    @Override
    public String save(BookDto bookDto) throws Exception {
        BookEntity bookEntity=getBookEntity(bookDto);
        return bookDao.save(bookEntity)?"Success":"Fail";
    }

    @Override
    public String update(BookDto bookDto) throws Exception {
        BookEntity bookEntity=getBookEntity(bookDto);
        return bookDao.update(bookEntity)?"Success":"Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        return bookDao.delete(id)?"Success":"Fail";
    }

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
    
    public BookEntity getBookEntity(BookDto bookDto){
        return new BookEntity(bookDto.getId(),
                bookDto.getName(),
                bookDto.getCategoryId(),
                bookDto.getAuthor(),
                bookDto.getPrice());
    }
    
    public BookDto getBookDto(BookEntity bookEntity){
        return new BookDto(bookEntity.getId(),
                bookEntity.getName(),
                bookEntity.getCategoryId(),
                bookEntity.getAuthor(),bookEntity.getPrice());
    }

    @Override
    public BookDto searchBook(String id) throws Exception {
        BookEntity bookEntity=bookDao.get(id);
        return getBookDto(bookEntity);
    }
    
}
