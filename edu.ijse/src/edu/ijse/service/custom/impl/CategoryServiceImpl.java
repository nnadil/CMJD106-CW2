/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.custom.CategoryDao;
import edu.ijse.dto.CategoryDto;
import edu.ijse.entity.CategoryEntity;
import edu.ijse.service.custom.CategoryService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDao=(CategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CATEGORY);
    @Override
    public ArrayList<CategoryDto> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities=categoryDao.getAll();
        if(categoryEntities!=null&&!categoryEntities.isEmpty()){
            ArrayList<CategoryDto> categoryDtos=new ArrayList<>();
            for (CategoryEntity categoryEntity : categoryEntities) {
                categoryDtos.add(getcategoryDto(categoryEntity));
            }
            return categoryDtos;
        }
        return null;
    }
    
    public CategoryDto getcategoryDto(CategoryEntity categoryEntity){
        return new CategoryDto(categoryEntity.getCategoryId(),categoryEntity.getCategoryName());
    }
    
    public CategoryEntity getCategoryEntity(CategoryDto categoryDto){
        return new CategoryEntity(categoryDto.getCategoryId(),categoryDto.getCategoryName());
    }

    @Override
    public String update(CategoryDto categoryDto) throws Exception {
        CategoryEntity categoryEntity=getCategoryEntity(categoryDto);
        return categoryDao.update(categoryEntity)?"Success":"Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        return categoryDao.delete(id)?"Success":"Fail";
    }

    @Override
    public String save(CategoryDto categoryDto) throws Exception {
        CategoryEntity categoryEntity=getCategoryEntity(categoryDto);
        return categoryDao.save(categoryEntity)?"Success":"Fail";
    }

    @Override
    public CategoryDto getCategory(String categoryId) throws Exception {
        CategoryEntity categoryEntity=categoryDao.get(categoryId);
        return getcategoryDto(categoryEntity);
    }
    
}
