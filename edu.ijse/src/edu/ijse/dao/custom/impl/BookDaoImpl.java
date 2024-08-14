/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.custom.impl;

import edu.ijse.dao.CrudUtil;
import edu.ijse.dao.custom.BookDao;
import edu.ijse.entity.BookEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author MSI
 */
public class BookDaoImpl implements BookDao{

    @Override
    public boolean save(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?,?)",t.getId(),t.getName(),t.getCategoryId(),t.getAuthor(),t.getPrice());
    }

    @Override
    public boolean update(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE books SET Book_Name=?,Category_id=?,Book_Author=?,Book_Price=? WHERE Book_ID=?",t.getName(),t.getCategoryId(),t.getAuthor(),t.getPrice(),t.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM books WHERE Book_Id=?", id);
    }

    @Override
    public BookEntity get(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM books WHERE Book_Id=?", id);
        if(rst.next()){
            BookEntity bookEntity=new BookEntity(rst.getString("Book_Id"),
                    rst.getString("Book_Name"),
                    rst.getString("Category_Id"),
                    rst.getString("Book_Author"),
                    rst.getDouble("Book_Price"));
            return bookEntity;
            
        }
        return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM books");
        while(rst.next()){
            BookEntity bookEntity=new BookEntity(rst.getString("Book_Id"),
                    rst.getString("Book_Name"),
                    rst.getString("Category_Id"),
                    rst.getString("Book_Author"),
                    rst.getDouble("Book_Price"));
            bookEntities.add(bookEntity);
        }
        return bookEntities;
    }
    
}
