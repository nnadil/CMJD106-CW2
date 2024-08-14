/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.custom;

import edu.ijse.dto.CategoryDto;
import edu.ijse.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public interface CategoryService extends SuperService{
    ArrayList<CategoryDto> getAll() throws Exception;
    String update(CategoryDto categoryDto)throws Exception;
    String delete(String id)throws Exception;
    String save(CategoryDto categoryDto)throws Exception;
    CategoryDto getCategory(String CategoryId)throws Exception;
}
