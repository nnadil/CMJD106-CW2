/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.custom.impl;

import edu.ijse.dao.CrudUtil;
import edu.ijse.dao.custom.CategoryDao;
import edu.ijse.entity.CategoryEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author MSI
 */
public class CategoryDaoImpl implements CategoryDao{
    @Override
    public boolean save(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO categories VALUES(?,?)", t.getCategoryId(),t.getCategoryName());
    }

    @Override
    public boolean update(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE categories SET Category_Name=? WHERE Category_Id=?",t.getCategoryName(),t.getCategoryId());
    }
        @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM categories WHERE Category_Id=?", id);
    }

    @Override
    public CategoryEntity get(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM categories WHERE Category_Id=?",id);
        if(rst.next()){
            CategoryEntity categoryEntity=new CategoryEntity(rst.getString("Category_Id"),rst.getString("Category_Name"));
            return categoryEntity;
        }
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
                ArrayList<CategoryEntity> categoryEntities=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM categories");
        while(rst.next()){
            CategoryEntity categoryEntity=new CategoryEntity(rst.getString("Category_Id"),rst.getString("Category_Name"));
            categoryEntities.add(categoryEntity);
        }
        return categoryEntities;
    }
}


